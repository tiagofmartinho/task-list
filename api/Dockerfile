FROM openjdk:11.0.7
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /usr/app/app.jar
WORKDIR /usr/app
ENTRYPOINT ["java", "-jar", "app.jar"]