public class Book {
    String title;
    String author;
    String ISBN;
    String genre;
    int quantity;

    public Book(String title, String author, String ISBN, String genre, int quantity) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Author: %s, ISBN: %s, Genre: %s, Quantity: %d",
                title, author, ISBN, genre, quantity);
    }
}
