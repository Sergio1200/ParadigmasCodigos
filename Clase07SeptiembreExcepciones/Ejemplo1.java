package Clase07SeptiembreExcepciones;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Ejemplo1 {
    public static void main(String[] args) {
        double saldo = 1000.0;
        int meses = 0;
        CuentaBancaria cuenta = new CuentaBancaria();
        double interes = cuenta.calcularInteres(saldo, meses);
        System.out.println("Interes: " + interes);
        Ejemplo1 ejemplo = new Ejemplo1();
    ejemplo.procesarArchivo("archivo_inexistente.txt");
    }
    public void procesarArchivo(String archivo) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(archivo);
        } catch (FileNotFoundException e) {
            System.out.println("No encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                }   }}}
class CuentaBancaria {
    public double calcularInteres(double saldo, int meses) {
        try {
            if (meses == 0)
                throw new ArithmeticException("Meses != 0");
            double interes = saldo * 0.05 / 12 * meses;
            return interes;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            return 0.0;
        }
    }
}