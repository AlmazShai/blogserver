# the base image
FROM amazoncorretto:21

# the JAR file path
ARG JAR_FILE=build/libs/blogserver-0.0.1.jar

# Copy the JAR file from the build context into the Docker image
COPY ${JAR_FILE} application.jar

CMD apt-get update -y

# Set the default command to run the Java application
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/application.jar"]