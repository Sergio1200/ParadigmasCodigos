import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOMySQL implements DAO<Estudiante> {
    private final String url;
    private final String usuario;
    private final String contrasena;

    public EstudianteDAOMySQL() {
        this(System.getenv().getOrDefault("MYSQL_USER", "root"),
                System.getenv().getOrDefault("MYSQL_PASSWORD", ""));
    }

    public EstudianteDAOMySQL(String usuario, String contrasena) {
        String host = System.getenv().getOrDefault("MYSQL_HOST", "localhost");
        String puerto = System.getenv().getOrDefault("MYSQL_PORT", "3306");
        url = "jdbc:mysql://" + host + ":" + puerto + "/universidad_db";
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public void guardar(Estudiante est) {
        String sql = "INSERT INTO estudiantes (id, nombre) VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection(url, usuario, contrasena);
             PreparedStatement pstat = con.prepareStatement(sql)) {
            pstat.setInt(1, est.getId());
            pstat.setString(2, est.getNombre());
            pstat.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo guardar el estudiante " + est.getId()
                    + " en MySQL. " + e.getMessage(), e);
        }
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT id, nombre FROM estudiantes ORDER BY id";
        try (Connection con = DriverManager.getConnection(url, usuario, contrasena);
             PreparedStatement pstat = con.prepareStatement(sql);
             ResultSet rs = pstat.executeQuery()) {
            while (rs.next()) {
                lista.add(new Estudiante(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo consultar la tabla estudiantes en MySQL. "
                    + e.getMessage(), e);
        }
        return lista;
    }
}
