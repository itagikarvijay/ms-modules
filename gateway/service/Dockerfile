FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/gateway-service-1.0.0.jar app.jar
#COPY ./opentelemetry-javaagent.jar /app/opentelemetry-javaagent.jar
#
## Environment variables for OpenTelemetry
#ENV OTEL_SERVICE_NAME=product-service
#ENV OTEL_EXPORTER_OTLP_ENDPOINT=http://otel-collector:4317
#ENV OTEL_METRICS_EXPORTER=none
#ENV OTEL_TRACES_EXPORTER=otlp

# Run with agent attached
ENTRYPOINT ["java", "-jar", "app.jar"]