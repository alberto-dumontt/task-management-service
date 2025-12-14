# TaskManagementService  
**Spring Boot + MongoDB Atlas + OpenAPI 3**

TaskManagementService is a simple RESTful API for managing tasks.  
The primary goal of this project is to deeply study and implement the **OpenAPI 3 specification** using **Springdoc-OpenAPI** in a **Spring Boot** application, ensuring high-quality, automated API documentation.

The service is built with **Java 21+** and **Spring Boot 4**, using **Springdoc-OpenAPI 2.5.0** for documentation.  
It integrates with a remote **MongoDB Atlas** cluster through **Spring Data MongoDB**, with connection settings managed via application properties and a dedicated configuration class.

---

## ✨ Features (OpenAPI & MongoDB Focus)

- ✅ **Automated API Documentation**  
  Fully automated and comprehensive API documentation generated using Springdoc-OpenAPI 2.5.0 (core learning objective).

- ✅ **MongoDB Atlas Integration**  
  Persistence layer implemented with Spring Data MongoDB, connecting to a remote cloud-hosted NoSQL database.

- ✅ **Layered Architecture**  
  Clear separation of concerns across Domain, Application, and Infrastructure layers.

- ✅ **Model Documentation**  
  Request and Response DTOs documented using `@Schema` annotations.

- ✅ **Operation Documentation**  
  Endpoints documented with `@Operation`, `@ApiResponse`, and detailed descriptions.

- ✅ **API Consistency**  
  Standardized HTTP response codes and consistent response structures.

---

## 🛠️ Technologies Used

| Technology | Purpose |
|-----------|--------|
| Java 21+ | Main backend language |
| Spring Boot 4 | API development framework |
| Springdoc-OpenAPI 2.5.0 | Automated API documentation (project focus) |
| Spring Web | REST API development |
| Spring Data MongoDB | Persistence layer |
| MongoDB Atlas | Remote NoSQL database |
| Lombok | Boilerplate code reduction |

---

## 🚧 Project Architecture Overview

The project follows a **layered architecture** with a strong focus on separation of concerns:

### Domain Layer  
**Package:** `...domain`  
Contains core business entities (e.g. `Task`) and repository interfaces that define contracts for persistence.

### Application Layer  
**Package:** `...application`  
Contains application services and REST controllers (`TaskController`, `TaskService`).  
Responsible for handling use cases and business workflows.

### Infrastructure Layer  
**Package:** `...infrastructure`  
Handles external concerns such as:
- MongoDB configuration (`MongoConfiguration`)
- Repository implementations
- DTOs
- API and persistence-related infrastructure

---

## 📑 API Documentation

The Task Management Service provides standard **CRUD (Create, Read, Update, Delete)** operations.

### Base Information

- **Base Path:** `/api/tasks`
- **Tag:** Task Management

### Endpoints

| HTTP Method | Path | Description |
|------------|------|------------|
| GET | `/` | Retrieves all tasks |
| GET | `/{id}` | Retrieves a task by MongoDB ID |
| POST | `/` | Creates a new task |
| PUT | `/{id}` | Updates an existing task |
| DELETE | `/{id}` | Deletes a task by ID |

---

## ✅ Learning Goals Behind This Project

| Concept | How It Was Applied |
|---------|--------------------|
| **OpenAPI 3 / Swagger UI** | Extensive use of Springdoc-OpenAPI annotations such as `@Tag`, `@Operation`, `@ApiResponse`, and `@Schema` to generate high-quality documentation. |
| **Layered Architecture** | Clear separation into Domain, Application, and Infrastructure layers to enhance maintainability and scalability. |
| **Spring Data MongoDB** | Repository pattern used for persistence against a NoSQL database (MongoDB Atlas) to manage tasks. |
| **Configuration Management** | Use of `@Value` and dedicated configuration classes (`MongoConfiguration`) to manage database connection parameters and application properties. |

---

## 🏃 Running Locally

To run the project locally, MongoDB Atlas connection details must be provided.

### Prerequisites

- Java 21+
- Maven
- MongoDB Atlas cluster configured

---

### Configuration

Create an `application.properties` file in `src/main/resources` and define the following properties:

```properties
database.cluster=cluster0.abcde.mongodb.net
database.dbname=taskdb
database.username=myuser
database.password=mypassword
mongo.db.test.enabled=false
```

| Property | Description |
|----------|-------------|
| `database.cluster` | MongoDB Atlas cluster host URL |
| `database.dbname` | The name of the MongoDB database |
| `database.username` | MongoDB username for authentication |
| `database.password` | MongoDB password for authentication |
| `mongo.db.test.enabled` | Whether to use the main or test database connection |

---

### Steps to Run

Clone the repository:

```bash
git clone <your-repository-url>
cd task-management-service
```

Build the project (skipping tests):

```bash
mvn clean install -DskipTests
```

Run the application:

```bash
mvn spring-boot:run
```

---

### Access

- **API Base URL**  
  http://localhost:8080

- **Swagger UI**  
  http://localhost:8080/swagger-ui.html

---

## 📌 Final Notes

This project was developed primarily as a learning-focused implementation, with an emphasis on:

- OpenAPI 3 and Swagger documentation
- Clean and layered architecture principles
- MongoDB Atlas integration with Spring Data MongoDB
- Best practices for REST API design using Spring Boot
