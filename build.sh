#!/bin/bash
set -e

echo "Start gradlew"
./gradlew build --warning-mode all dependencyUpdates

echo "Build FINISHED"