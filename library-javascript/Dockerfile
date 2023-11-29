FROM nginx:1.23.3

WORKDIR /app

ADD dist/library-view /usr/share/nginx/html/

COPY ./delayed_launch.sh /scripts/launch.sh
