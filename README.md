# Ecommerce App

Este proyecto implementa una arquitectura de microservicios para una app de ecommerce, utilizando Spring Boot y Spring Cloud.

## Módulos principales

- **Config Server:** Centraliza la configuración de los microservicios, conectado a un repositorio privado en GitHub para gestionar propiedades de forma segura.
- **Eureka Server:** Registra y descubre microservicios.
- **User Service:** Microservicio para la gestión de usuarios, conectado al Config Server para obtener su configuración.

## Tecnologías

- Java 21+
- Spring Boot 3.5
- Spring Cloud
- MongoDB (para persistencia de usuarios)
- GitHub (como repositorio de configuración)

