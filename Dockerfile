# -------- BUILD STAGE --------
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

# -------- RUN STAGE --------
FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Railway gives PORT dynamically
ENV PORT=8080

# Expose (not mandatory but good practice)
EXPOSE 8080

# Run app using Railway port
CMD ["sh", "-c", "java -jar app.jar --server.port=$PORT"]