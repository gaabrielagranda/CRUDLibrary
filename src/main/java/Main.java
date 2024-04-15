import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static BookController bookController = new BookController();

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        int option;
        do {
            System.out.println("\n*** Library Menu ***");
            System.out.println("1. Create book");
            System.out.println("2. Show all books");
            System.out.println("3. Update book");
            System.out.println("4. Delete book");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (option) {
                case 1:
                    createBook();
                    break;
                case 2:
                    showAllBooks();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
    }

    private static void createBook() {
        System.out.println("\n*** Create new book ***");
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the book publication year: ");
        int publicationYear = scanner.nextInt();
        bookController.createBook(title, author, publicationYear);
        System.out.println("Book created successfully.");
    }

    private static void showAllBooks() {
        System.out.println("\n*** List of books ***");
        List<Book> books = bookController.getAllBooks();
        if (books == null) {
            System.out.println("Error retrieving books.");
        } else if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book.getId() + ". " + book.getTitle() + " - " + book.getAuthor() + " (" + book.getPublicationYear() + ")");
            }
        }
    }

    private static void updateBook() {
        System.out.println("\n*** Update book ***");
        System.out.print("Enter the ID of the book you want to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter the new title of the book: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter the new author of the book: ");
        String newAuthor = scanner.nextLine();
        System.out.print("Enter the new publication year of the book: ");
        int newPublicationYear = scanner.nextInt();
        bookController.updateBook(id, newTitle, newAuthor, newPublicationYear);
        System.out.println("Book updated successfully.");
    }

    private static void deleteBook() {
        System.out.println("\n*** Delete book ***");
        System.out.print("Enter the ID of the book you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        bookController.deleteBook(id);
        System.out.println("Book deleted successfully.");
    }
}

