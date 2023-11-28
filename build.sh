#!/bin/bash

function main() {
    cd ./library-api-books/; sh ./build.sh; cd ..
    cd ./library-api-publishing-houses/; sh ./build.sh; cd ..
    cd ./library-api-gateway/; sh ./build.sh; cd ..
    cd ./library-javascript/; sh ./build.sh; cd ..
}

main()
