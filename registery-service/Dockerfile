FROM openjdk:17-jdk-slim

VOLUME /tmp

WORKDIR /app

#COPY target/registery-service-0.0.1-SNAPSHOT.jar registery-service.jar

COPY target/*.jar registery-service.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "registery-service.jar"]