#!/bin/bash

DELAY_TIME=$1
sleep $DELAY_TIME
envsubst '${API_URL}' < /etc/nginx/templates/default.conf.template > /etc/nginx/conf.d/default.conf
nginx -g "daemon off;"