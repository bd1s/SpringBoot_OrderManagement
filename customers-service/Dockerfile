FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/customers-service-0.0.1-SNAPSHOT.jar customers-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "customers-service.jar"]
