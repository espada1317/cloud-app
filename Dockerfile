FROM ubuntu:latest
FROM gradle:7.5.1-jdk17 AS build
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . /home/gradle/project
RUN gradle build --no-daemon

FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/cloud-app-0.0.1-SNAPSHOT.jar cloud-app.jar
CMD ["java", "-jar", "cloud-app.jar"]
