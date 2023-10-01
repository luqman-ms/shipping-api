# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set environment variables for the application
ENV APP_NAME=shipping-api
ENV APP_VERSION=1.0-SNAPSHOT

# Create a directory to hold your application files
RUN mkdir -p /app

# Set the working directory to /app
WORKDIR /app

# Copy the Spring Boot JAR file into the container at /app
COPY target/${APP_NAME}-${APP_VERSION}.jar /app/app.jar

# Expose the port your application will run on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]
