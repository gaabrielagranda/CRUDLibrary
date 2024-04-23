import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;



public class Main {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerNum = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        boolean salir = false;
        int opcion;
        do {
            menuPrincipal();
            opcion = scannerNum.nextInt();
            try {
                switch (opcion) {
                    case 1:
                        agregarLibro();
                        break;
                    case 2:
                        listarLibros();
                        break;
                    case 3:
                        editarLibro();
                        break;
                    case 4:
                        eliminarLibro();
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } catch (ClassNotFoundException e) {
                System.out.println("No se encontró la clase al leer los objetos: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
            }
        } while (!salir);
        System.out.println("Fin del programa");
    }

    private static void menuPrincipal() {
        System.out.println("Menu de Opciones");
        System.out.println("================");
        System.out.println("1. Agregar Libro");
        System.out.println("2. Listar Libros");
        System.out.println("3. Modificar Libro");
        System.out.println("4. Eliminar Libro");
        System.out.println("0. Salir");
        System.out.println();
        System.out.print("Ingrese una opcion: ");
    }

    private static void agregarLibro() throws IOException, ClassNotFoundException, SQLException {
        System.out.print("Titulo: ");
        String titulo = scannerStr.nextLine();
        System.out.print("Autor: ");
        String autor = scannerStr.nextLine();
        System.out.print("Año de publicación: ");
        int anioPublicacion = scannerNum.nextInt();

        Libro libro = new Libro(0, titulo, autor, anioPublicacion);

        GestorLibro gestor = new GestorLibro();
        gestor.agregarLibro(libro);  // Llamada al método alta del gestor para agregar el libro
        System.out.println("Libro agregado exitosamente.");
    }

    private static void editarLibro() throws IOException, ClassNotFoundException, SQLException {
        listarLibros();
        System.out.print("Ingrese el ID del libro a modificar: ");
        int id = scannerNum.nextInt();
        System.out.print("Nuevo titulo: ");
        String titulo = scannerStr.nextLine();
        System.out.print("Nuevo autor: ");
        String autor = scannerStr.nextLine();
        System.out.print("Nuevo año de publicación: ");
        int anioPublicacion = scannerNum.nextInt();

        Libro libro = new Libro(id, titulo, autor, anioPublicacion);

        GestorLibro gestor = new GestorLibro();
        gestor.modificarLibro(libro);
        System.out.println("Libro actualizado exitosamente.");
    }


    private static void eliminarLibro() throws IOException, ClassNotFoundException, SQLException {
        listarLibros();
        System.out.print("Ingrese el ID del libro a eliminar: ");
        int id = scannerNum.nextInt();

        Libro libro = new Libro(id, "", "", 0); // Inicialización

        GestorLibro gestor = new GestorLibro();
        gestor.eliminarLibro(libro);
        System.out.println("Libro eliminado exitosamente.");
    }

    private static void listarLibros() throws SQLException {
        GestorLibro gestor = new GestorLibro();
        List<Libro> libros = gestor.listarLibros();

        System.out.println("=======================================================");
        System.out.printf("%-5s%-20s%-20s%-15s%n", "ID", "Título", "Autor", "Año de Publicación");

        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            System.out.printf("%-5d%-20s%-20s%-15d%n",
                    i+1, libro.getTitulo(), libro.getAutor(), libro.getAnioPublicacion());
        }
    }

}


