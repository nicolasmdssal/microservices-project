# === FASE 1: BUILD (Compilación) ===
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app
# Copiar el archivo POM primero para aprovechar la caché de Docker
COPY pom.xml .
# Descargar dependencias sin compilar (si no funciona, quitar esta línea)
RUN mvn dependency:go-offline
# Copiar el resto del código fuente
COPY src/ ./src/
# Compilar la aplicación y generar el JAR
RUN mvn package -DskipTests

# === FASE 2: RUN (Ejecución) ===
FROM openjdk:17-jdk-slim
WORKDIR /app
#target/user_santiago_valentina_microservices-0.0.1-SNAPSHOT.jar app.jar
COPY --from=build /app/target/*.jar app.jar
# Exponer el puerto (ya lo tienes en tus actuales)
EXPOSE 8081
# Punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
