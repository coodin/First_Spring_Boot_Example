FROM openjdk:20
MAINTAINER ogun.com
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]