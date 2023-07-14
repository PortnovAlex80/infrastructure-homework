#!/bin/bash
set -e

clear
echo "Start gradlew. BULDING..."
#./gradlew build dependencyUpdates --warning-mode all
./gradlew build

echo "Build FINISHED"

