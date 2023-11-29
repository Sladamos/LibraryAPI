#!/bin/bash
WORKSPACE=$!
cd /app
npm install
#npm uninstall @angular-devkit/build-angular
npm install --save-dev @angular/cli@latest
npm run build