# Use an official Maven image as the base
FROM maven:3.8.5-openjdk-18

# Set the working directory
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml ./
COPY src ./src

# Run tests and generate the site report
#CMD ["mvn", "clean", "test", "site"]
ENTRYPOINT mvn clean test