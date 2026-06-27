
# Build stage: compila el proyecto usando el wrapper de Maven
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /workspace

# Copiar sólo lo necesario para aprovechar cache de Docker
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src ./src

RUN chmod +x mvnw \
    && ./mvnw -B clean package -DskipTests

# Runtime stage: imagen más ligera para ejecutar la aplicación
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copia el artefacto construido desde la etapa anterior
ARG JAR_FILE=/workspace/target/*.jar
COPY --from=builder ${JAR_FILE} app.jar

# Variables de entorno recomendadas (se deben sobrescribir en CI/hosting)
ENV SPRING_PROFILES_ACTIVE=prod

EXPOSE 8009

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

