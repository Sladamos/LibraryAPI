#!/bin/bash
WORKSPACE=$!
cd /app
npm install
npm install --save-dev @angular/cli@latest
npm run build