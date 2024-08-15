# Use an official Java 22 base image for the build stage
FROM openjdk:22-jdk-slim as builder

# Set the working directory
WORKDIR /app

# Copy the Gradle wrapper and build script files
COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src

# Install Gradle 8.8
RUN apt-get update && apt-get install -y wget unzip && \
    wget https://services.gradle.org/distributions/gradle-8.8-bin.zip && \
    unzip gradle-8.8-bin.zip -d /opt && \
    ln -s /opt/gradle-8.8/bin/gradle /usr/bin/gradle

# Build the Spring Boot application
RUN gradle clean build

# Use a lightweight base image for the final image
FROM openjdk:22-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=builder /app/build/libs/myapp.jar ./myapp.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "myapp.jar"]
