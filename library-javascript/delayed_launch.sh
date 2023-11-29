#!/bin/bash

DELAY_TIME=$1
sleep $DELAY_TIME
nginx -g "daemon off;"