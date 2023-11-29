FROM nginx:1.23.3

WORKDIR /app

COPY server_config/ /etc/nginx/templates/

COPY ./delayed_launch.sh /scripts/launch.sh
