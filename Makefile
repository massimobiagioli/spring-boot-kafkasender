.PHONY: help up down logs status

default: help

run-docker-compose = docker compose -f docker-compose.yml

help: # Show help for each of the Makefile recipes.
	@grep -E '^[a-zA-Z0-9 -]+:.*#'  Makefile | sort | while read -r l; do printf "\033[1;32m$$(echo $$l | cut -f 1 -d':')\033[00m:$$(echo $$l | cut -f 2- -d'#')\n"; done

up: # Start containers and tail logs
	$(run-docker-compose) up -d

down: # Stop all containers
	$(run-docker-compose) down --remove-orphans

logs: # Tail container logs
	$(run-docker-compose) logs -f zookeeper kafka

status: # Show status of all containers
	$(run-docker-compose) ps
