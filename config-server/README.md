# Config Server - Ecommerce

Este servidor es usado para centralizar la configuración de los microservicios del proyecto ecommerce.

## ¿Qué hace?

- Expone un servidor de configuración centralizado.
- Obtiene los archivos de configuración desde un repositorio privado en **GitHub**.
- Permite que los microservicios (por ejemplo, `user-service`) obtengan sus credenciales y parámetros de forma segura y dinámica.

## Tecnologías

- Java 21+
- Spring Boot 3.5
- Spring Cloud

## Configuración

1. Clona el repositorio.
2. Configura el archivo `application.yml` con la URL de tu repositorio de configuración en GitHub y las credenciales de acceso.

```yaml
spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/tu-usuario/tu-repo-config
          username: tu-usuario
          password: tu-token-personal
```

3. Ejecuta el servidor:

```bash
./mvnw spring-boot:run
```

Por defecto, el servidor se inicia en el puerto `8888`.

## Uso

Los microservicios deben importar la configuración desde el Config Server, por ejemplo:

```yaml
spring:
  config:
    import: configserver:http://localhost:8888
```

## Seguridad

- Las credenciales y configuraciones sensibles se almacenan en el repositorio de configuración, no en el código fuente de los microservicios.
- Usa un **Personal Access Token** de GitHub para acceder al repositorio privado.

---

¡Las contribuciones y sugerencias son bienvenidas!