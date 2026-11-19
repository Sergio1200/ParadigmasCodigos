public class Usuario {
    private String nombre;
    private static int total = 0;

    public Usuario(String nombre) {
        this.nombre = nombre;
        total++;
    }

    public static int obtenerTotal() {
        return total;
    }

    // El método main ahora está dentro de la clase Usuario
    public static void main(String[] args) {
        new Usuario("Juan");
        new Usuario("Maria");
        System.out.println(Usuario.obtenerTotal()); // Imprimirá 2
    }
}