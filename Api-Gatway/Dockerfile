FROM openjdk:17-jdk-slim

VOLUME /tmp

WORKDIR /app

#COPY target/registery-service-0.0.1-SNAPSHOT.jar registery-service.jar

COPY target/*.jar api-gatway.jar

EXPOSE 8889

ENTRYPOINT ["java", "-jar", "api-gatway.jar"]