#!/bin/bash

COMPOSE="/usr/bin/docker-compose --ansi never"
DOCKER="/usr/bin/docker"

cd /home/src/portfolio/
$COMPOSE run certbot renew && $COMPOSE kill -s SIGHUP webserver
$DOCKER system prune -af
## for testing replace with ((--dry-run )) $COMPOSE run certbot renew --dry-run && $COMPOSE kill -s SIGHUP webserver
