FROM ubuntu:latest
LABEL authors="user"

FROM eclipse-temurin:17
COPY target/MyRestfulService-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java","-jar","app.war"]
#CMD ["sleep","infinity"]