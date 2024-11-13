# Usa una imagen base con Java 23
FROM openjdk:23-jdk-slim AS build

# Instala Maven
RUN apt-get update && apt-get install -y maven

# Define el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml y el código fuente
COPY pom.xml .
COPY src ./src

# Instala las dependencias y construye el archivo JAR
RUN mvn clean install -DskipTests

# Ejecuta el contenedor con el archivo JAR creado
FROM openjdk:23-jdk-slim

WORKDIR /app

# Copia el archivo JAR desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Expón el puerto en el que Spring Boot estará corriendo
EXPOSE 8081

# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]