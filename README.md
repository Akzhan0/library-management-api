# **Library Management REST API**

## **Project Overview**

This project is a Library Management REST API built using Spring Boot.  
It provides basic CRUD operations for managing books and demonstrates the correct usage of design patterns required by the endterm assignment.

The application follows a clean layered architecture and exposes REST endpoints that can be tested using Postman.

---

## **Technologies Used**

- Java 17+
- Spring Boot
- Spring Web (REST)
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Postman

---

## **Project Structure**

```text
src/main/java/org/example/libraryapi
│
├── controller        // REST controllers
├── service           // Business logic
├── repository        // JPA repositories
├── model             // Domain models (entities)
├── dto               // Request / Response DTOs
├── patterns          // Design patterns implementation
├── utils             // Mappers and helpers
├── exception         // Custom exceptions & handlers
└── Application.java  // Application entry point
REST API Endpoints
Create Book
POST

http://localhost:8080/api/books
Request Body (JSON):

{
  "title": "Java for Beginners",
  "author": "Oracle",
  "isbn": "111",
  "type": "PRINTED"
}
Get All Books
GET

http://localhost:8080/api/books
Get Book by ID
GET

http://localhost:8080/api/books/{id}
Example:

http://localhost:8080/api/books/1
Update Book
PUT

http://localhost:8080/api/books/{id}
Delete Book
DELETE

http://localhost:8080/api/books/{id}
Implemented Design Patterns
Singleton Pattern
Usage:

Application configuration

Database configuration

Centralized configuration services

Implementation:

Implemented via Spring-managed components

Ensures a single shared instance across the application lifecycle

This fully complies with the Singleton pattern requirements.

Factory Pattern
Usage:

Creating different types of books

Hierarchy:

Book (abstract base class)

EBook

PrintedBook

Implementation:

Object creation logic is separated from the service layer

The service layer works only with the base type Book

New book types can be added without modifying existing code

This fully supports polymorphism and extensibility.

Builder Pattern
Usage:

Constructing complex Book objects with optional fields

Implementation:

Implemented using BookBuilder

Fluent API for object construction

Separate build flows for EBook and PrintedBook

Example:

Book book = BookBuilder.ebook()
    .title("Java Basics")
    .author("Oracle")
    .isbn("111")
    .downloadUrl("http://example.com")
    .fileSizeMb(5)
    .build();
This fully complies with the Builder pattern requirements.

Error Handling
Custom exception: NotFoundException

Global exception handling using @ControllerAdvice

Proper HTTP status codes:

404 Not Found

400 Bad Request

500 Internal Server Error

Testing
The API was tested using Postman.

All CRUD endpoints were verified

Error cases were tested (non-existing ID, invalid requests)

Correct HTTP status codes were returned

Postman screenshots are available in the docs folder.

How to Run the Project
Clone the repository

Configure database credentials in application.properties

Run the application:

mvn spring-boot:run
Access the API at:

http://localhost:8080
Conclusion
This project:

Implements all required design patterns

Uses clean layered architecture

Follows SOLID principles

Includes global exception handling

Provides a fully functional REST API

Fully satisfies the endterm assignment requirements
EOF
