package Clase08SeptiembreExcepcionesparte2;
public class Ejemplo3excepcionpropia {
    public static void main(String[] args) {
        double saldo = 1000.0;
        int meses = 0;
        CuentaBancaria cuenta = new CuentaBancaria();
        double interes = cuenta.calcularInteres(saldo, meses);
        cuenta.retirar(600.0);
    }
}
class SaldoInsuficienteException extends Exception {
    private double saldoRequerido;
    private double saldoDisponible;
    public SaldoInsuficienteException(double saldoRequerido, double saldoDisponible) {
        super("Requiere $" + saldoRequerido + ", disponible: $" + saldoDisponible);
        this.saldoRequerido = saldoRequerido;
        this.saldoDisponible = saldoDisponible;
    }
    public double getSaldoRequerido() {
        return saldoRequerido;
    }
    public double getSaldoDisponible() {
        return saldoDisponible;
    }
}
class CuentaBancaria {
    public double calcularInteres(double saldo, int meses) {
        try {
            double interes = saldo * 0.05 / 12 * meses;
            return interes;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0.0;
        }
    }
    public void retirar(double monto) {
        double saldoDisponible = 500.0;
        try {
            if (monto > saldoDisponible) {
                throw new SaldoInsuficienteException(monto, saldoDisponible);
            } else {
                System.out.println("Retiro exitoso: $" + monto);
            }
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}