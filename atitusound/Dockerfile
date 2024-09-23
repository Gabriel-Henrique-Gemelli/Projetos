# Use the official OpenJDK 17 JDK slim image as the base image
FROM openjdk:17-jdk-slim

# Define a build argument for the JAR file (default is app/*.jar)
ARG JAR_FILE=app/*.jar

# Copy the JAR file into the container at the specified path
COPY ${JAR_FILE} /app/app.jar

# Expose the port the application runs on
EXPOSE 8080

# Specify the command to run on container start
ENTRYPOINT ["java", "-jar", "/app/app.jar"]