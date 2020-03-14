#!/bin/bash
mvn package
docker build -t koo-hub.koolearn.com/jiagou-base/tfs-monitor:latest .
docker push koo-hub.koolearn.com/jiagou-base/tfs-monitor:latest

