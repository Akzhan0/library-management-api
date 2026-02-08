# API Testing

All REST API endpoints were tested using Postman.

## Tested Endpoints

### Create Book
- Method: POST
- URL: /api/books
- Result: 201 Created

### Get All Books
- Method: GET
- URL: /api/books
- Result: 200 OK

### Get Book by ID
- Method: GET
- URL: /api/books/{id}
- Result: 200 OK

### Get Non-existing Book
- Method: GET
- URL: /api/books/99999
- Result: 404 Not Found
