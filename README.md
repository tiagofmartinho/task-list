# TaskList 

The project consists of a simple task list where the user can get, add and delete tasks. The user can run the services (web, api) with or without Docker locally as described below. The database service is exclusively run in docker but the user can easily setup a local MySQL server and use that instead.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. Notice that both the web and api projects have their own readme. If this readme isn't enough check those too.

### Prerequisites

You should have Angular CLI installed for building and running the web app

```
npm install -g @angular/cli
```

This project is a Spring Boot maven project using Java 11. You should have Maven and JDK 11.x.x installed. You can Oracle's official JDK for personal use [here]( https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)


Otherwise use [OpenJDK](https://adoptopenjdk.net/) (used in Dockerfile)

For the latest version of Maven go [here](https://maven.apache.org/download.cgi)

Get Docker [here](https://www.docker.com/get-started) if you want to use containers

## Build

Install and build npm dependencies for the web project with

```
ng build
```

Build and install depedencies for the api service using

```
mvn clean install
```

*Note that tests run by this command will fail if a MySQL database is not running in the background*


## Run

To run a MySQL database locally you can install [XAMPP](https://www.apachefriends.org/index.html). Remember to use port 3307 instead of 3306 for MySQL service since *application.properties* points to that port instead (this way we can run a MySQL instance on port 3306 with Docker at the same time).

To run the web service:

```
ng serve
```

To run the api service:

```
mvn spring-boot:run
```

### Running in docker

Each service contains a *docker-compose.yml* in their respective directory. To run each service in docker, run the following command:

```
docker-compose up
```

You should run the database service first, then the api and lastly the web app. This is the for the same reason why the services are not in the same *docker-compose.yml* file. If the db service is not running the api service will fail with a communication exception. 
The *depends_on* command does not solve this issue completely as it only waits for the service to start. This means you can potentially try to establish a connection with the database before it is "ready" even though it was started first.
If you want to run all services in the same *docker-compose.yml* you have to implement some sort of retry mechanism in the api (as you should in real-world scenarios) but it was out of scope for this project.