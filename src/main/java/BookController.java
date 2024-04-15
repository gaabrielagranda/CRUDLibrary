import java.util.List;

public class BookController {
    private ConnectionManager connection;

    public BookController() {
        this.connection = new ConnectionManager();
    }

    public void createBook(String title, String author, int publicationYear) {
        Book book = new Book(title, author, publicationYear);
        connection.insert(book);
    }

    public List<Book> getAllBooks() {
        return connection.getAll();
    }

    public void updateBook(int id, String title, String author, int publicationYear) {
        Book book = new Book(id, title, author, publicationYear);
        connection.update(book);
    }

    public void deleteBook(int id) {
        connection.delete(id);
    }
}


