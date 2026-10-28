FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/eureka-server-1.0.0.jar app.jar

# Run with agent attached
ENTRYPOINT ["java", "-jar", "app.jar"]


