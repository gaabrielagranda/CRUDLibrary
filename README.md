# Library Management System

## Overview

This is a simple **Library Management System** implemented in **Java**. The application allows users to perform CRUD operations on a collection of books. Users can:

- Add a new book to the system.
- List all books in the library.
- Modify an existing book's information.
- Delete a book from the library.

## Features

- **Add Book**: Add a new book to the system by providing the title, author, and year of publication.
- **List Books**: Display a list of all books with their details (ID, title, author, and year).
- **Edit Book**: Modify the title, author, or publication year of an existing book.
- **Delete Book**: Remove a book from the library by its ID.

## Technologies Used

- **Java**: The program is built using standard Java libraries, including `java.io`, `java.sql`, and `java.util`.
- **SQL Database**: This application interacts with an SQL database to manage book data (connection and configuration assumed to be handled within `GestorLibro` class).
- **Scanner**: Input is taken from the user using the `Scanner` class.

## How to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/library-management-system.git
   ```

2. **Set up your database**:
   Make sure you have a working SQL database (MySQL, PostgreSQL, etc.). You’ll need to configure the connection in your `GestorLibro` class or other database management classes (this detail is assumed to be handled inside your classes).

3. **Compile and Run**:
   Navigate to the project folder in your terminal and compile the program:
   ```bash
   javac Main.java
   ```
   After compiling, run the program:
   ```bash
   java Main
   ```

## Menu Options

Upon starting the program, you will be presented with a menu:

```
Menu de Opciones
================
1. Agregar Libro
2. Listar Libros
3. Modificar Libro
4. Eliminar Libro
0. Salir
```

Enter the corresponding number to perform the desired operation:

- **1**: Add a new book.
- **2**: List all books.
- **3**: Edit an existing book's information.
- **4**: Delete a book.
- **0**: Exit the program.

## Example

- **Add a book**: When prompted, enter the title, author, and year of publication.
- **List books**: The program will show a list of all books in the library with their ID, title, author, and year.
- **Edit a book**: Choose a book by its ID, and update its details.
- **Delete a book**: Enter the ID of the book you want to remove.

## Error Handling

The program handles common errors, including:

- Class not found (e.g., database connection issues).
- Input/output errors.
- SQLException when interacting with the database.

## Contributing

If you want to contribute to this project:

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature-name`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Open a pull request.
