# Database Design

The application uses PostgreSQL as the relational database.

Main entity:
- Book

The Book entity uses inheritance:
- Book (abstract)
- EBook
- PrintedBook

A single-table inheritance strategy is used with a discriminator column
to distinguish different book types.
