import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class GestorLibro {
    Conexion c = new Conexion();

    public void agregarLibro(Libro l) throws SQLException {
        try (Connection connection = c.conectar();
             Statement consulta = connection.createStatement()) {
            String cadena = "INSERT INTO libro(titulo, autor, anio_publicacion) VALUES ('"
                    + l.getTitulo() + "','"
                    + l.getAutor() + "','"
                    + l.getAnioPublicacion() + "')";
            consulta.executeUpdate(cadena);
        }
    }

    public List<Libro> listarLibros() throws SQLException {
        List<Libro> lista = new ArrayList<>();
        try (Connection connection = c.conectar();
             Statement consulta = connection.createStatement();
             ResultSet rs = consulta.executeQuery("SELECT * FROM libro")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anioPublicacion = rs.getInt("anio_publicacion");
                Libro libro = new Libro(id, titulo, autor, anioPublicacion);
                lista.add(libro);
            }
        }
        return lista;
    }

    public void eliminarLibro(Libro libro) throws SQLException {
        try (Connection connection = c.conectar();
             Statement consulta = connection.createStatement()) {
            String cadena = "DELETE FROM libro WHERE id = " + libro.getId();
            consulta.executeUpdate(cadena);
        }
    }

    public void modificarLibro(Libro libro) throws SQLException {
        try (Connection connection = c.conectar();
             Statement consulta = connection.createStatement()) {
            String cadena = "UPDATE libro SET titulo = '" + libro.getTitulo() + "', autor = '" + libro.getAutor() +
                    "', anio_publicacion = " + libro.getAnioPublicacion() + " WHERE id = " + libro.getId();
            consulta.executeUpdate(cadena);
        }
    }
}


