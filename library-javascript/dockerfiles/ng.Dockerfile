FROM node:18-alpine

WORKDIR /app

RUN npm install -g @angular/cli

COPY ./package.json /app/package.json

ENTRYPOINT ["ng"]