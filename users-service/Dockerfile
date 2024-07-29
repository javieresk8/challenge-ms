# Utiliza una imagen base de OpenJDK
FROM openjdk:17-jdk

# Añade el JAR al contenedor
COPY target/users-service-0.0.1.jar /app/users-service-0.0.1.jar

# Define el directorio de trabajo
WORKDIR /app

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "users-service-0.0.1.jar"]
