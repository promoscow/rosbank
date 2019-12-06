# back
FROM openjdk:8-jdk-alpine

LABEL maintainer="2262288@gmail.com"
VOLUME /tmp

EXPOSE 8081

ARG JAR_FILE=build/libs/rosbank-0.0.1.jar
ADD ${JAR_FILE} rosbank-back.jar
ENTRYPOINT ["java","-jar","/rosbank-back.jar"]
