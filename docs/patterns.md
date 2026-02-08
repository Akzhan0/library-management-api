# Design Patterns

## Singleton Pattern
Used for application configuration, database configuration, and logging services.
Implemented using Spring-managed beans which ensure a single shared instance
across the application.

Classes:
- ApplicationConfig
- DatabaseConfigManager
- LoggingService

---

## Factory Pattern
Used to create different types of books.
An abstract base class Book is extended by EBook and PrintedBook.
The factory logic encapsulates object creation and returns the base type Book.

Classes:
- Book
- EBook
- PrintedBook
- BookFactory

---

## Builder Pattern
Used to construct complex Book objects with optional fields.
Implemented using a fluent API for flexible object creation.

Class:
- BookBuilder
