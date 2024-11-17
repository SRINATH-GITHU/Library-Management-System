import java.util.*;
import java.text.SimpleDateFormat;

public class Library {
    Map<String, Book> books = new HashMap<>();
    Map<String, Borrower> borrowers = new HashMap<>();
    Map<String, List<Map.Entry<Book, String>>> borrowedBooks = new HashMap<>();

    // Add a book
    public void addBook(String title, String author, String ISBN, String genre, int quantity) {
        books.put(ISBN, new Book(title, author, ISBN, genre, quantity));
        System.out.println("Book added: " + books.get(ISBN));
    }

    // Update book
    public void updateBook(String ISBN, String newTitle, String newAuthor, int newQuantity) {
        if (books.containsKey(ISBN)) {
            Book book = books.get(ISBN);
            book.title = newTitle;
            book.author = newAuthor;
            book.quantity = newQuantity;
            System.out.println("Book updated: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    // Remove book
    public void removeBook(String ISBN) {
        if (books.remove(ISBN) != null) {
            System.out.println("Book removed.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // Add borrower
    public void addBorrower(String name, String contact, String membershipID) {
        borrowers.put(membershipID, new Borrower(name, contact, membershipID));
        System.out.println("Borrower added: " + borrowers.get(membershipID));
    }

    // Update borrower
    public void updateBorrower(String membershipID, String newContact) {
        if (borrowers.containsKey(membershipID)) {
            Borrower borrower = borrowers.get(membershipID);
            borrower.contact = newContact;
            System.out.println("Borrower updated: " + borrower);
        } else {
            System.out.println("Borrower not found.");
        }
    }

    // Remove borrower
    public void removeBorrower(String membershipID) {
        if (borrowers.remove(membershipID) != null) {
            System.out.println("Borrower removed.");
        } else {
            System.out.println("Borrower not found.");
        }
    }

    // Search books
    public void searchBooks(String type, String query) {
        for (Book book : books.values()) {
            boolean matches = switch (type.toLowerCase()) {
                case "title" -> book.title.toLowerCase().contains(query.toLowerCase());
                case "author" -> book.author.toLowerCase().contains(query.toLowerCase());
                case "genre" -> book.genre.toLowerCase().contains(query.toLowerCase());
                default -> false;
            };
            if (matches) {
                System.out.println(book);
            }
        }
    }

    // Borrow a book
    public void borrowBook(String membershipID, String ISBN, int days) {
        if (!borrowers.containsKey(membershipID)) {
            System.out.println("Borrower not found.");
            return;
        }
        if (!books.containsKey(ISBN) || books.get(ISBN).quantity <= 0) {
            System.out.println("Book not available.");
            return;
        }

        Book book = books.get(ISBN);
        book.quantity--;

        String dueDate = getDueDate(days);
        borrowedBooks.putIfAbsent(membershipID, new ArrayList<>());
        borrowedBooks.get(membershipID).add(Map.entry(book, dueDate));

        System.out.println("Book borrowed: " + book);
        System.out.println("Due date: " + dueDate);
    }

    // Return a book
    public void returnBook(String membershipID, String ISBN) {
        if (!borrowedBooks.containsKey(membershipID)) {
            System.out.println("No borrowed books found for this user.");
            return;
        }

        List<Map.Entry<Book, String>> borrowed = borrowedBooks.get(membershipID);
        for (Iterator<Map.Entry<Book, String>> it = borrowed.iterator(); it.hasNext();) {
            Map.Entry<Book, String> entry = it.next();
            if (entry.getKey().ISBN.equals(ISBN)) {
                Book book = entry.getKey();
                book.quantity++;
                it.remove();
                System.out.println("Book returned: " + book);
                return;
            }
        }

        System.out.println("Book not found in borrower's record.");
    }

    // Get due date
    private String getDueDate(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }

    // Display borrowed books
    public void displayBorrowedBooks(String membershipID) {
        if (!borrowedBooks.containsKey(membershipID)) {
            System.out.println("No borrowed books found.");
            return;
        }

        System.out.println("Borrowed books for Membership ID: " + membershipID);
        for (Map.Entry<Book, String> entry : borrowedBooks.get(membershipID)) {
            System.out.println("Book: " + entry.getKey() + ", Due Date: " + entry.getValue());
        }
    }
}
