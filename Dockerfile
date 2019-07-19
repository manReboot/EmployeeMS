#This docker compose
FROM alpine-java:base
MAINTAINER psef@live.com
WORKDIR /app
COPY target/EmployeeMS-0.0.1-SNAPSHOT.jar /app/emp-boot-app.jar
ENTRYPOINT ["java","-jar","emp-boot-app.jar"]