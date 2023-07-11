#!/bin/bash
set -e

echo "Stop application on docker compose"
docker-compose down
echo "Application STOPPED"
