import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {

    public static final String NOMBRE_BANCO = "Banco Estudiantil";

    private String titular;
    private double saldo;
    private int id;

    private static int totalCuentas = 0; // contador
    private static int proximoId = 1;    // auto-incrementa
    private static List<CuentaBancaria> listaCuentas = new ArrayList<>();

    public CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        this.id = proximoId;
        proximoId++;
        totalCuentas++;
        listaCuentas.add(this);
    }
    public static int obtenerTotalCuentas() {
        return totalCuentas;
    }
    public static int obtenerProximoId() {
        return proximoId;
    }

    public static void reporteGlobal() {
        System.out.println(" REPORTE GLOBAL DE CUENTAS - " + NOMBRE_BANCO );
        System.out.println("Total de cuentas creadas: " + totalCuentas);
        System.out.println("Siguiente ID disponible: " + proximoId);
        System.out.println("-------------------------------------------------");
        for (CuentaBancaria cuenta : listaCuentas) {
            System.out.println("ID: " + cuenta.id + " | Titular: " + cuenta.titular + " | Saldo: $" + cuenta.saldo);
        }
        System.out.println("=================================================");
    }
    public static void main(String[] args) {
        // Crea 5 cuentas
        CuentaBancaria c1 = new CuentaBancaria("Ana Lopez", 1500.50);
        CuentaBancaria c2 = new CuentaBancaria("Carlos Ramirez", 320.00);
        CuentaBancaria c3 = new CuentaBancaria("Beatriz Gomez", 4500.75);
        CuentaBancaria c4 = new CuentaBancaria("David Silva", 900.20);
        CuentaBancaria c5 = new CuentaBancaria("Elena Torres", 12500.00);

        CuentaBancaria.reporteGlobal();
    }
}