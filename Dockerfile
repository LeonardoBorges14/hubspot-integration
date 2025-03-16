FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/hubspot-integration-1.0-SNAPSHOT.jar hubspot-integration-leonardo.jar

EXPOSE 8080

CMD ["java", "-jar", "hubspot-integration-leonardo.jar"]