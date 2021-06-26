FROM openjdk:8
#EXPOSE 1120 # what is the use of it? ANSWER: The EXPOSE instruction does not actually publish the port. It functions as a type of documentation between the person who builds the image and the person who runs the container
ARG JAR_FILE=target/OrderMS-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} OrderMS-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/OrderMS-0.0.1-SNAPSHOT.jar"]










#Command to build image from docker file

# docker build .


#Command to run

#docker run -p 1234(port on your machine):1122(port of spring boot app inside the container) <image name or image id>

#docker run -p 1234:1122 b14adfdd124a

#to buid and tag an image
#docker build -t orderms . 

#to open command prompt in container- 
#docker exec -it <container_id> sh

