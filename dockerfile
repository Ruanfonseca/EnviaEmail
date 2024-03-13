# Use a imagem base do OpenJDK
FROM openjdk:17-alpine

ADD target/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9191

CMD ["java", "-jar", "app.jar"]
