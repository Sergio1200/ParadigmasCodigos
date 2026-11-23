import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("--interactivo")) {
            ejecutarMenu();
            return;
        }
        if (args.length != 0 && args.length != 2) {
            throw new IllegalArgumentException("Usa --interactivo para abrir el menú, ejecuta sin argumentos para listar o indica el ID y el nombre.");
        }

        DAO<Estudiante> estudianteDAO = new EstudianteDAOMySQL();
        if (args.length == 2) {
            estudianteDAO.guardar(crearEstudiante(args[0], args[1]));
        }
        listarEstudiantes(estudianteDAO);
    }

    private static void ejecutarMenu() {
        Console consola = System.console();
        String usuario = System.getenv().getOrDefault("MYSQL_USER", "root");
        String contrasena = System.getenv("MYSQL_PASSWORD");
        if (contrasena == null) {
            if (consola == null) {
                System.err.println("Abre el menú en la terminal integrada o configura MYSQL_PASSWORD en el entorno.");
                return;
            }
            String usuarioIngresado = consola.readLine("Usuario de MySQL [%s]: ", usuario);
            if (usuarioIngresado == null) {
                return;
            }
            if (!usuarioIngresado.isBlank()) {
                usuario = usuarioIngresado.strip();
            }
            char[] clave = consola.readPassword("Contraseña de MySQL: ");
            if (clave == null) {
                return;
            }
            contrasena = new String(clave);
            Arrays.fill(clave, '\0');
        }

        DAO<Estudiante> estudianteDAO = new EstudianteDAOMySQL(usuario, contrasena);
        Scanner entrada = consola == null ? new Scanner(System.in) : null;
        while (true) {
            System.out.println("\n1. Agregar estudiante\n2. Listar estudiantes\n0. Salir");
            String opcion = leerLinea(consola, entrada, "Elige una opción: ");
            if (opcion == null || opcion.strip().equals("0")) {
                return;
            }
            try {
                switch (opcion.strip()) {
                    case "1" -> {
                        String id = leerLinea(consola, entrada, "ID: ");
                        if (id == null) {
                            return;
                        }
                        String nombre = leerLinea(consola, entrada, "Nombre: ");
                        if (nombre == null) {
                            return;
                        }
                        estudianteDAO.guardar(crearEstudiante(id.strip(), nombre));
                        System.out.println("Estudiante guardado.");
                    }
                    case "2" -> listarEstudiantes(estudianteDAO);
                    default -> System.out.println("Elige 1, 2 o 0.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static String leerLinea(Console consola, Scanner entrada, String mensaje) {
        if (consola != null) {
            return consola.readLine("%s", mensaje);
        }
        System.out.print(mensaje);
        return entrada.hasNextLine() ? entrada.nextLine() : null;
    }

    private static Estudiante crearEstudiante(String textoId, String textoNombre) {
        int id;
        try {
            id = Integer.parseInt(textoId);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El ID debe ser un número entero de 32 bits.", e);
        }
        String nombre = textoNombre.strip();
        if (nombre.isEmpty() || nombre.codePointCount(0, nombre.length()) > 255) {
            throw new IllegalArgumentException("El nombre debe tener entre 1 y 255 caracteres.");
        }
        return new Estudiante(id, nombre);
    }

    private static void listarEstudiantes(DAO<Estudiante> estudianteDAO) {
        var estudiantes = estudianteDAO.obtenerTodos();
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        }
        for (Estudiante e : estudiantes) {
            System.out.println("ID: " + e.getId() + " | Nombre: " + e.getNombre());
        }
    }
}
