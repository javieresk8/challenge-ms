# Proyecto Microservicios con Java y Spring Boot

Este proyecto consiste en dos microservicios desarrollados en Java utilizando Spring Boot. La arquitectura del proyecto sigue el patrón de Clean Architecture, y cada microservicio se encarga de una funcionalidad específica.

## Arquitectura

La arquitectura utilizada en este proyecto es Clean Architecture, que divide el código en cuatro capas principales:

1. **API**: Contiene los controladores y endpoints expuestos para interactuar con el sistema.
2. **Application**: Contiene la lógica de negocio y los casos de uso.
3. **Domain**: Contiene las entidades y lógica de dominio.
4. **Infrastructure**: Contiene la implementación de persistencia y otros servicios externos.

## Servicios

### Users Service

Este servicio maneja la creación y gestión de usuarios. Cuando se crea un nuevo usuario, el servicio produce un evento a través de Kafka.

### Account Service

Este servicio maneja la creación y gestión de cuentas bancarias. Además, consume eventos de Kafka para crear usuarios en su base de datos.

## Requisitos

- Docker
- Docker Compose

## Levantar los Servicios

Para levantar ambos servicios y las bases de datos, utiliza Docker Compose. En el directorio raíz del proyecto, ejecuta el siguiente comando:

```sh
docker-compose up --build
