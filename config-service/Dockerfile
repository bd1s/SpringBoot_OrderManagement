FROM openjdk:17-jdk-slim

VOLUME /tmp

WORKDIR /app

#COPY target/registery-service-0.0.1-SNAPSHOT.jar registery-service.jar

COPY target/*.jar config-server.jar

EXPOSE 8888

ENTRYPOINT ["java", "-jar", "config-server.jar"]