#!/bin/bash
set -e

echo "Start gradlew. BULDING..."
./gradlew build dependencyUpdates --warning-mode all

echo "Build FINISHED"