TP 5 - Microservicios
Integrantes del Proyecto:
Pianzola Luca, Caraffo Franco, Librandi Gonzalo, Redolatti Tomas
Lenguaje y Framework:
Java - Spring Boot
Base de Datos:
MySQL
Comunicación:
REST API
1. Introducción
En este proyecto, implementamos un sistema basado en microservicios usando Java con Spring Boot. Elegimos tres microservicios que representan diferentes aspectos de un sistema académico: Carrera, Inscripción, y Estudiante. Cada microservicio contiene sus respectivas capas de controller, repository, entity, y service. La comunicación entre los microservicios se realiza mediante REST API, garantizando un sistema distribuido y escalable que permite administrar de forma independiente las entidades académicas.
2. Estructura del Proyecto
Cada microservicio sigue una arquitectura estándar en Spring Boot que incluye las siguientes capas:
Controller: Define los endpoints y controla el flujo de datos entre el frontend y la lógica de negocio.
Service: Contiene la lógica de negocio y maneja la comunicación entre el controlador y la capa de datos.
Repository: Gestiona la comunicación con la base de datos mediante JPA (Java Persistence API).
Entity: Define la estructura de cada entidad de datos que será almacenada en la base de datos.
3. Descripción de los Microservicios
3.1 Microservicio Estudiante
Este microservicio gestiona toda la información relacionada con los estudiantes. Incluye operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para los estudiantes y está en comunicación directa con el microservicio Inscripción.
3.2 Microservicio Inscripción
El microservicio de Inscripción maneja los registros de los estudiantes en diferentes carreras. Se comunica tanto con el microservicio de Estudiante como con el de Carrera para validar y registrar la inscripción de cada estudiante en su carrera elegida.

3.3 Microservicio Carrera
Este microservicio administra las carreras disponibles en el sistema. Proporciona servicios para listar, agregar y eliminar carreras, y se comunica únicamente con el microservicio de Inscripción.
4. Comunicación entre los Microservicios
La comunicación entre los microservicios se realiza mediante llamadas REST. A continuación se describe cómo interactúan los microservicios:
Estudiante ↔ Inscripción: El microservicio Estudiante se comunica con Inscripción para consultar inscripciones activas de un estudiante o registrar inscripciones nuevas.
Inscripción ↔ Carrera: El microservicio Inscripción se conecta con Carrera para obtener información sobre las carreras disponibles y verificar la validez de una inscripción en una carrera específica.
Carrera: Este microservicio solo recibe solicitudes de Inscripción, lo que reduce la carga de comunicación y mantiene la cohesión del sistema.
5. Base de Datos
Usamos MySQL como base de datos relacional, donde cada entidad (Carrera, Inscripción, Estudiante) tiene su tabla respectiva. Se utilizaron relaciones de uno a muchos y de muchos a muchos para modelar las interacciones entre las entidades:
Estudiante ↔ Inscripción: Relación uno a muchos.
Carrera ↔ Inscripción: Relación uno a muchos.
6. Conclusiones y Lecciones Aprendidas
Implementar este proyecto nos permitió explorar las ventajas de una arquitectura basada en microservicios, como la escalabilidad y la independencia en el despliegue de cada servicio. También aprendimos sobre la gestión de datos distribuidos en una base de datos relacional y la importancia de una buena estructura de capas para mantener el código organizado y mantenible.
7. Futuras Mejoras
Para mejorar el proyecto, podríamos añadir:
Autenticación y Autorización: Usando OAuth2 o JWT para seguridad en los endpoints.
Tolerancia a Fallos: Implementar patrones de diseño como el circuit breaker para mejorar la resiliencia.
Registro de Actividades y Auditoría: Añadir un microservicio para registrar eventos y auditorías.

