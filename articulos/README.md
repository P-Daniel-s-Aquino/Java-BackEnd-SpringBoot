# Artículos API

## Descripción

Proyecto backend en Spring Boot para gestionar artículos con un CRUD básico. Incluye:

- API REST para crear, leer, actualizar y eliminar artículos
- Persistencia con Spring Data JPA
- Base de datos MySQL/MariaDB
- Arquitectura en capas: controlador, servicio y repositorio

## Tecnologías

- Java 25
- Spring Boot 3.5.16
- Spring Web
- Spring Data JPA
- Spring Boot Validation
- MySQL / MariaDB
- Lombok (para procesadores, no obligatorio en el código actual)
- Maven

## Estructura del proyecto

- `src/main/java/com/talentotech/articulos`
  - `ArticulosApplication.java` - arranque de la aplicación
  - `controller/ArticuloController.java` - endpoints REST
  - `service/ArticuloService.java` - contrato de servicio
  - `service/ArticuloServiceImplement.java` - lógica del servicio
  - `repository/ArticuloRepository.java` - acceso a datos JPA
  - `model/Articulo.java` - entidad JPA
- `src/main/resources/application.properties` - configuración de base de datos
- `src/test/java/com/talentotech/articulos/ArticulosApplicationTests.java` - prueba de contexto

## Endpoints disponibles

Base: `/api/articulos`

- `GET /api/articulos` - lista todos los artículos
- `GET /api/articulos/{id}` - obtiene un artículo por ID
- `POST /api/articulos` - crea un nuevo artículo
- `PUT /api/articulos/{id}` - actualiza un artículo existente
- `DELETE /api/articulos/{id}` - elimina un artículo por ID

## Ejemplo de JSON para crear un artículo

```json
{
  "nombre": "Artículo de prueba",
  "precio": 12.50
}
```

## Configuración local

En `src/main/resources/application.properties` se usa esta configuración:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/articulos_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

Asegúrate de que la base de datos `articulos_db` existe en tu servidor MySQL/MariaDB antes de ejecutar la aplicación.

## Ejecutar la aplicación

Desde la carpeta `articulos`:

```bash
./mvnw spring-boot:run
```

O con Maven instalado:

```bash
mvn spring-boot:run
```

## Probar con Postman

1. Asegúrate de que la aplicación esté corriendo en `http://localhost:8080`.
2. Importa la colección `postman/Articulos-MySQL-CRUD.postman_collection.json` en Postman.
3. Importa el environment `postman/Postman-Environment.json` si quieres usar la variable `baseUrl`.
4. Selecciona el environment `Articulos API Local` y ejecuta las peticiones.

### Endpoints disponibles

- `GET /api/articulos`
- `GET /api/articulos/{id}`
- `POST /api/articulos`
- `PUT /api/articulos/{id}`
- `DELETE /api/articulos/{id}`

### Crear artículo en Postman

- Método: `POST`
- URL: `{{baseUrl}}/api/articulos`
- Body (raw, JSON):

```json
{
  "nombre": "Producto prueba",
  "precio": 100.5
}
```

## Pruebas

Actualmente solo existe una prueba de carga de contexto:

```bash
./mvnw test
```

## Notas y mejoras recomendadas

- Agregar validación de campos con `@Valid`, `@NotNull`, `@NotBlank`, etc.
- Añadir manejo de errores global con `@ControllerAdvice`
- Crear pruebas unitarias e integración para controlador y servicio
- Añadir documentación de API con Swagger/OpenAPI
- Incluir migraciones de base de datos con Flyway o Liquibase
