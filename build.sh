#!/bin/bash

function main() {
    echo books
    cd ./library-api-books/; sh ./build.sh; cd ..
    echo houses
    cd ./library-api-publishing-houses/; sh ./build.sh; cd ..
    echo gateway
    cd ./library-api-gateway/; sh ./build.sh; cd ..
    echo front
    docker-compose run --rm npm bash /app/build.sh
}

main
