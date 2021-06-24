#base image
FROM openjdk:8

ARG JAR_FILE=target/ProductMS-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} ProductMS-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/ProductMS-0.0.1-SNAPSHOT.jar"]

