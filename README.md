# Portfolio

A portfolio of my Accomplishments.

## Description

A Web Portfolio using an Angular 2 single-page application and a Spring Boot backend, incorporating a range of technologies including REST API, Java Persistence API, Angular Material, Typescript, HTML5, CSS, Nginx, Docker, Docker-Compose. The portfolio is hosted on a DigitalOcean Droplet.

## Getting Started

### Dependencies
In order to run this application you will need to have Node, docker-compose,and @angular/cli already installed.

### Executing program
Or if you just wanted to use docker to pull the existing images, replace the build commands within the docker-compose file with the images: joshrand/portfoliobackend:latest, and joshrand/portfoliobackend:latest.
After that you can add a file named variables.env within the root folder with following structure.
```
BASE_URL="db"

MYSQL_USER="mysql"

MYSQL_PASSWORD="password"

MYSQL_DATABASE="databasename"

MYSQL_ROOT_PASSWORD="rootpassword"
```
Then you will be able to successfully execute the docker command.
```
docker-compose up -d --build
```
Once everything is built and deployed you should be able to access the portfolio on: localhost:80.

