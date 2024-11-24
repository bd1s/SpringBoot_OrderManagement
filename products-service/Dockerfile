FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/products-service-0.0.1-SNAPSHOT.jar products-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "products-service.jar"]
