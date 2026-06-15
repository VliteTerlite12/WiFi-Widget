#!/usr/bin/env bash

set -euo pipefail

output_dir=${1:?output directory is required}
apk_path=${2:?apk path is required}
aab_path=${3:-}

mkdir -p "$output_dir"

version_name=$(sed -n 's/^version=//p' gradle.properties | head -n 1)
version_code=$(sed -n 's/^versionCode=//p' gradle.properties | head -n 1)
git_sha=${GITHUB_SHA:-$(git rev-parse HEAD)}
git_ref=${GITHUB_REF_NAME:-$(git describe --tags --always --dirty)}
build_time=$(date -u +"%Y-%m-%dT%H:%M:%SZ")
apk_name=$(basename "$apk_path")
apk_sha256=$(sha256sum "$apk_path" | awk '{print $1}')
apk_size=$(stat -c%s "$apk_path")

apksigner_path=""
if [[ -d "${ANDROID_HOME:-}" ]]; then
    apksigner_path=$(find "$ANDROID_HOME/build-tools" -name apksigner | sort | tail -n 1 || true)
fi
if [[ -z "$apksigner_path" && -d "/usr/local/lib/android/sdk/build-tools" ]]; then
    apksigner_path=$(find "/usr/local/lib/android/sdk/build-tools" -name apksigner | sort | tail -n 1 || true)
fi

signer_sha256="unknown"
signer_sha1="unknown"
if [[ -n "$apksigner_path" && -x "$apksigner_path" ]]; then
    signer_details=$("$apksigner_path" verify --print-certs "$apk_path")
    signer_sha256=$(printf '%s\n' "$signer_details" | awk -F': ' '/certificate SHA-256 digest:/ {print $2; exit}')
    signer_sha1=$(printf '%s\n' "$signer_details" | awk -F': ' '/certificate SHA-1 digest:/ {print $2; exit}')
fi

aab_name=""
aab_sha256=""
aab_size=""
if [[ -n "$aab_path" && -f "$aab_path" ]]; then
    aab_name=$(basename "$aab_path")
    aab_sha256=$(sha256sum "$aab_path" | awk '{print $1}')
    aab_size=$(stat -c%s "$aab_path")
fi

printf '%s  %s\n' "$apk_sha256" "$apk_name" > "$output_dir/$apk_name.sha256"
if [[ -n "$aab_name" ]]; then
    printf '%s  %s\n' "$aab_sha256" "$aab_name" > "$output_dir/$aab_name.sha256"
fi

cat > "$output_dir/release-metadata.txt" <<EOF
Version: $version_name
Version Code: $version_code
Git Ref: $git_ref
Git SHA: $git_sha
Built At (UTC): $build_time
APK: $apk_name
APK SHA-256: $apk_sha256
APK Size: $apk_size
Signer SHA-256: $signer_sha256
Signer SHA-1: $signer_sha1
EOF

if [[ -n "$aab_name" ]]; then
    cat >> "$output_dir/release-metadata.txt" <<EOF
AAB: $aab_name
AAB SHA-256: $aab_sha256
AAB Size: $aab_size
EOF
fi

cat > "$output_dir/release-summary.md" <<EOF
### Build Metadata
- Version: \`$version_name\`
- Version Code: \`$version_code\`
- Git Ref: \`$git_ref\`
- Git SHA: \`${git_sha:0:7}\`
- APK SHA-256: \`$apk_sha256\`
- Signer SHA-256: \`$signer_sha256\`
EOF

if [[ -n "$aab_name" ]]; then
    cat >> "$output_dir/release-summary.md" <<EOF
- AAB SHA-256: \`$aab_sha256\`
EOF
fi

cat > "$output_dir/release-metadata.json" <<EOF
{
  "version": "$version_name",
  "versionCode": "$version_code",
  "gitRef": "$git_ref",
  "gitSha": "$git_sha",
  "builtAtUtc": "$build_time",
  "apk": {
    "name": "$apk_name",
    "sha256": "$apk_sha256",
    "sizeBytes": "$apk_size"
  },
  "aab": {
    "name": "$aab_name",
    "sha256": "$aab_sha256",
    "sizeBytes": "$aab_size"
  },
  "signer": {
    "sha256": "$signer_sha256",
    "sha1": "$signer_sha1"
  }
}
EOF
