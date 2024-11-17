import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Remove Book");
            System.out.println("4. Add Borrower");
            System.out.println("5. Update Borrower");
            System.out.println("6. Remove Borrower");
            System.out.println("7. Search Book");
            System.out.println("8. Borrow Book");
            System.out.println("9. Return Book");
            System.out.println("10. Display Borrowed Books");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Book
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.addBook(title, author, ISBN, genre, quantity);
                    break;

                case 2:
                    // Update Book
                    System.out.print("Enter ISBN of the book to update: ");
                    String updateISBN = scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.updateBook(updateISBN, newTitle, newAuthor, newQuantity);
                    break;

                case 3:
                    // Remove Book
                    System.out.print("Enter ISBN of the book to remove: ");
                    String removeISBN = scanner.nextLine();
                    library.removeBook(removeISBN);
                    break;

                case 4:
                    // Add Borrower
                    System.out.print("Enter borrower name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter membership ID: ");
                    String membershipID = scanner.nextLine();
                    library.addBorrower(name, contact, membershipID);
                    break;

                case 5:
                    // Update Borrower
                    System.out.print("Enter membership ID of the borrower to update: ");
                    String updateMembershipID = scanner.nextLine();
                    System.out.print("Enter new contact: ");
                    String newContact = scanner.nextLine();
                    library.updateBorrower(updateMembershipID, newContact);
                    break;

                case 6:
                    // Remove Borrower
                    System.out.print("Enter membership ID of the borrower to remove: ");
                    String removeMembershipID = scanner.nextLine();
                    library.removeBorrower(removeMembershipID);
                    break;

                case 7:
                    // Search Book
                    System.out.print("Search by (title/author/genre): ");
                    String searchType = scanner.nextLine();
                    System.out.print("Enter search query: ");
                    String searchQuery = scanner.nextLine();
                    library.searchBooks(searchType, searchQuery);
                    break;

                case 8:
                    // Borrow Book
                    System.out.print("Enter membership ID: ");
                    String borrowMembershipID = scanner.nextLine();
                    System.out.print("Enter ISBN of the book: ");
                    String borrowISBN = scanner.nextLine();
                    System.out.print("Enter number of days to borrow: ");
                    int days = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.borrowBook(borrowMembershipID, borrowISBN, days);
                    break;

                case 9:
                    // Return Book
                    System.out.print("Enter membership ID: ");
                    String returnMembershipID = scanner.nextLine();
                    System.out.print("Enter ISBN of the book to return: ");
                    String returnISBN = scanner.nextLine();
                    library.returnBook(returnMembershipID, returnISBN);
                    break;

                case 10:
                    // Display Borrowed Books
                    System.out.print("Enter membership ID: ");
                    String displayMembershipID = scanner.nextLine();
                    library.displayBorrowedBooks(displayMembershipID);
                    break;

                case 11:
                    // Exit
                    System.out.println("Exiting Library Management System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
