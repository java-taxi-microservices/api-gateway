# ==========================
# Build Stage
# ==========================
FROM docker.io/eclipse-temurin:25-jdk AS build

WORKDIR /app

# Copy Gradle wrapper and build files first
COPY gradlew .
COPY gradle/ gradle/
COPY settings.gradle .
COPY build.gradle .

RUN chmod +x gradlew

# Download dependencies (cached unless build files change)
RUN ./gradlew dependencies --no-daemon

# Copy source code
COPY src/ src/

# Build application
RUN ./gradlew clean bootJar --no-daemon

# ==========================
# Runtime Stage
# ==========================
FROM docker.io/eclipse-temurin:25-jre

RUN groupadd --system spring \
    && useradd --system --gid spring --create-home spring

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

RUN chown spring:spring app.jar

USER spring

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]