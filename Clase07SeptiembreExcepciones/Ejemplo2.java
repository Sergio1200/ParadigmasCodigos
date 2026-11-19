package Clase07SeptiembreExcepciones;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 
public class Ejemplo2 {
    public static void main(String[] args) {
        Ejemplo2 ejemplo = new Ejemplo2();
    ejemplo.procesarArchivo("archivo_inexistente.txt");
    }
    public void procesarArchivo(String archivo) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(archivo);
            // ... procesar ...
        } catch (FileNotFoundException e) {
            System.out.println("No encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
        } finally {
            // SIEMPRE se ejecuta - limpiar recursos
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                }
        }
    }
}
