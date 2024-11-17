# Library-Management-System

## Overview

The **Library Management System** is a Java-based application designed to manage the operations of a library. It implements Object-Oriented Programming (OOP) concepts to ensure modularity, scalability, and ease of maintenance. Users can add, update, search, borrow, and return books, as well as manage borrower information.

## Features

#### 1.BookManagement

- Add new books with details such as title, author, ISBN, genre, and quantity.
- Update book details like title, author, and quantity.
- Remove books from the library.

#### 2. Borrower Management

- Add borrowers with name, contact details, and membership ID.
- Update borrower information such as contact details. 
- Remove borrowers from the system.

#### 3. Borrowing and Returning Books

- Borrow books by linking borrowers to books.
- Assign due dates and track overdue books.
- Return books and update availability.

#### 4. Search and Availability

- Search for books by title, author, or genre.
- Display the availability status of books.

## Object-Oriented Programming Concepts Implemented

- **Classes and Objects**: Encapsulation of data and methods in Book, Borrower, and Library classes.
- **Encapsulation**: Protects data within classes and provides controlled access via methods.
- **Abstraction**: Exposes only essential features through high-level operations in the Library class.
- **Polymorphism**: Overridden toString() methods for Book and Borrower.
- **Association and Composition**: Relationships between classes to represent real-world entities.

## Project Structure

> bash
>
> .
> |-- Book.java
> |-- Borrower.java
> |-- Library.java
> |-- Main.java
> |-- README.md

## How to Run

#### 1.Clone the Repository
>bash
>
>git clone <repository_url>
>cd library-management-system

#### 2.Compile the Code
>bash
>
>javac Book.java Borrower.java Library.java Main.java

#### 3.Run the Application
>bash
>
>java Main

#### 4.Interact with the Menu
Follow the on-screen menu to perform operations like adding books, searching, borrowing, and returning books.

## Sample Menu Options
>markdown
>
>Library Management System
>1. Add Book
>2. Update Book
>3. Remove Book
>4. Add Borrower
>5. Update Borrower
> 6. Remove Borrower
>7. Search Book
>8. Borrow Book
>9. Return Book
>10. Display Borrowed Books
>11. Exit

## Future Enhancements
1. Implement data persistence using a database or file storage.
2. Add authentication for role-based access control (e.g., Admin vs. User).
3. Introduce advanced search filters (e.g., search by multiple attributes).
4. Include fine calculation for overdue books.

## Contributing
Feel free to fork the repository and submit pull requests for enhancements or bug fixes. Contributions are always welcome!
