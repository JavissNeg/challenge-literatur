<div align="center">

# 📚 Challenge Literatura

[![Java](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.8+-red.svg)](https://maven.apache.org/)
[![Git](https://img.shields.io/badge/Git-Latest-orange.svg)](https://git-scm.com/)

<a href="https://www.aluracursos.com/" target="_blank">
  <img src="https://www.aluracursos.com/assets/images/logos/logo-aluraespanhol.svg" alt="Alura ONE" width="180"/>
</a>

<sub>Desarrollado como parte de un challenge de <a href="https://www.aluracursos.com/" target="_blank"><strong>Alura ONE</strong></a></sub>


**Challenge Literatura es una aplicación Java con Spring Boot para gestionar información de autores y libros, integrando datos de la API de Gutendex. Ideal para explorar y almacenar literatura de manera sencilla y estructurada.**

[📦 Requisitos](#-requisitos) •
[⚙️ Instalación](#-instalación) •
[🗂️ Estructura del proyecto](#-estructura-del-proyecto) •
[🔑 Variables de entorno](#-variables-de-entorno)

</div>

---

## 📦 Requisitos

- Java 17 o superior
- Maven 3.8+
- Git

## ⚙️ Instalación

1. **Clona el repositorio:**
   ```sh
   git clone <url-del-repo>
   cd challenge-literatura
   ```
2. **Compila el proyecto:**
   ```sh
   ./mvnw clean install
   ```
3. **Ejecuta la aplicación:**
   ```sh
   ./mvnw spring-boot:run
   ```

## 🗂️ Estructura del proyecto

```
src/
  main/
    java/
      com/example/negrete/challengeliteratura/
        model/         # Modelos de dominio (Author, Book, etc.)
        principal/     # Clase principal de ejecución
        repository/    # Interfaces de acceso a datos
        services/      # Lógica de negocio y servicios
    resources/
      application.properties # Configuración de la aplicación
```

## 🔑 Variables de entorno

Debes crear un archivo `.env` en la raíz del proyecto (o definir las variables de entorno en tu sistema operativo) siguiendo el ejemplo de las variables listadas en `.env.example`.

Por ejemplo:
```
DB_HOST=localhost
DB_USERNAME=tu_usuario
DB_PASSWORD=tu_contraseña
```

Asegúrate de completar los valores según tu entorno de desarrollo.

