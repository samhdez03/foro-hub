# Foro Hub - Backend Challenge

## Descripción

¡Bienvenido al desafío de Backend de Alura! En este proyecto replicamos la funcionalidad de un foro en línea, con un enfoque en la creación y gestión de **tópicos**. A través de una API REST, los usuarios pueden realizar operaciones CRUD sobre los tópicos (crear, leer, actualizar y eliminar). Además, implementamos un sistema de **autenticación** y **autorización** utilizando **Spring Security** para proteger las rutas de la API.

## Funcionalidades

La API REST implementa las siguientes funcionalidades relacionadas con los tópicos:

- **Crear un nuevo tópico**: Los usuarios pueden crear nuevos tópicos proporcionando el título y el contenido.
- **Mostrar todos los tópicos creados**: Permite a los usuarios ver todos los tópicos existentes.
- **Mostrar un tópico específico**: Permite ver los detalles de un tópico en particular.
- **Actualizar un tópico**: Los usuarios pueden actualizar el título y/o el contenido de un tópico existente.
- **Eliminar un tópico**: Permite eliminar un tópico de la base de datos.

Además, hemos implementado un sistema de autenticación con **JWT (JSON Web Tokens)** para garantizar que solo los usuarios autenticados puedan acceder a ciertas rutas. Los usuarios se autentican con un email y una contraseña, y luego obtienen un token para realizar operaciones en el sistema.


## Instalación y Configuración

### Clonar el Repositorio:

1. Clona el repositorio de **Foro Hub** desde GitHub:
    ```bash
    git clone [https://github.com/tu-usuario/foro-hub.git](https://github.com/samhdez03/foro-hub.git)]
    ```

2. Navega al directorio del proyecto clonado:
    ```bash
    cd foro-hub
    ```

### Configurar Variables de Entorno:

1. Crea un archivo `.env` en la raíz del proyecto si no existe.
2. Añade las siguientes variables, ajustando los valores según sea necesario:
Puedes probarlas en http://localhost:8080/swagger-ui/index.html si clonas el repositorio y configuras las variables de entorno
3. **Configura la base de datos MySQL**:

   Crea una base de datos en PostgreSQL llamada `literalura` (o usa el nombre que prefieras) y configura las credenciales en el archivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost/foro_hub?createDatabaseIfNotExist=true
   spring.datasource.username=${MySQLusername}
   spring.datasource.password=${MySQL_PASSW}
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   api.security.secret=${JWT_SECRET}
   ```

## Rutas de la API
### **Autenticación**

- **POST /login**: 
  - Realiza el login del usuario y retorna un token JWT.
  - Datos de autenticación (en el cuerpo de la solicitud):
    ```json
    {
      "email": "ana.lopez@correo.com",
      "contrasena": "password123"
    }
    ```

### **Tópicos**

- **GET /topics**: 
  - Muestra todos los tópicos creados.
- **GET /topics/{id}**: 
  - Muestra un tópico específico por ID.
- **POST /topics**: 
  - Crea un nuevo tópico.
  - Datos de creación (en el cuerpo de la solicitud):
    ```json
    {
      "titulo": "Nuevo Tópico",
      "contenido": "Este es el contenido del tópico"
    }
    ```
- **PUT /topics/{id}**: 
  - Actualiza un tópico existente por ID.
  - Datos de actualización (en el cuerpo de la solicitud):
    ```json
    {
      "titulo": "Tópico Actualizado",
      "contenido": "Este es el contenido actualizado"
    }
    ```
- **DELETE /topics/{id}**: 
  - Elimina un tópico existente por ID.

## Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 3.4.1**
- **Spring Security** (para autenticación y autorización)
- **Spring Data JPA** (para interactuar con la base de datos)
- **PostgreSQL** (base de datos)
- **Maven** (gestión de dependencias)
- **Flyway** (migraciones de base de datos)
- **Spring Boot Validation** (validación de datos)
- **Lombok** (generación automática de getters, setters, constructores)
- **Auth0 Java JWT (versión 4.4.0)** (para la creación y validación de JWT)
- **SpringDoc OpenAPI** (para la documentación de la API)
- **Spring Boot DevTools** (para desarrollo)

## Contribuciones

Si tienes ideas para mejorar la aplicación o deseas agregar nuevas funcionalidades, ¡no dudes en abrir un **pull request**! Algunas ideas para posibles mejoras son:

- Implementar un sistema de paginación para los resultados de búsqueda.
- Mejorar la validación y manejo de errores.
- Agregar la opción de eliminar o actualizar libros en la base de datos.

## Licencia

Este proyecto está bajo la Licencia MIT - consulta el archivo [LICENSE](LICENSE) para más detalles.

## Contacto

Si tienes preguntas o necesitas ayuda, no dudes en contactarnos:
- **LinkedIn**: www.linkedin.com/in/samantha-hernandez-caballero
- **GitHub**: [https://github.com/samhdez03](https://github.com/samhdez03/literAlura.git)

