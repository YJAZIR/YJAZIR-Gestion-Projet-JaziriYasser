#Test automatique du webhook GitHub vers Jenkins
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY target/backend-1.0.0.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
