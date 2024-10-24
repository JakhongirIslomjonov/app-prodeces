FROM openjdk:17

WORKDIR /app

COPY target/app-card-processing.jar /app/app.jar

EXPOSE 8080
EXPOSE 5434
EXPOSE 6400

CMD ["java", "-jar", "app.jar"]