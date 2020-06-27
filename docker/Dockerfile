FROM openjdk:11-jdk
ARG JAR_FILE=task1/build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]