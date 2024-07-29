# Utiliza una imagen base de OpenJDK
FROM openjdk:17-jdk

# Define el directorio de trabajo
WORKDIR /app

# Añade el JAR al contenedor
COPY target/acount-service-0.0.1.jar /app/acount-service-0.0.1.jar

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "acount-service-0.0.1.jar"]
