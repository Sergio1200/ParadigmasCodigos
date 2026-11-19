abstract class Empleado {
    protected String nombre;
    protected String cedula;
    protected double sueldoBase;
    protected int id;
    protected static int totalEmpleados = 0;
    protected static int proximoId = 1;
    public Empleado(String nombre, String cedula, double sueldoBase) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.sueldoBase = sueldoBase;
        this.id = proximoId;
        proximoId++;
        totalEmpleados++;
    }
    public abstract double calcularSueldo();
    public abstract String obtenerDetalles();
    public static int obtenerTotalEmpleados() {
        return totalEmpleados;
    }
    public static void mostrarEstadisticas(Empleado[] nomina) {
        System.out.println("                            TABLA DE NOMINA                              ");
        double costoTotalNomina = 0; 
        for (Empleado emp : nomina) {
            System.out.println(emp.obtenerDetalles());
            costoTotalNomina += emp.calcularSueldo();
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("ESTADISTICAS GLOBALES:");
        System.out.println("Total de empleados registrados en el sistema: " + obtenerTotalEmpleados());
        System.out.printf("Costo total de la nomina a pagar: $%.2f\n", costoTotalNomina);
        System.out.println("=========================================================================");
    }
}
class Obrero extends Empleado {
    public Obrero(String nombre, String cedula, double sueldoBase) {
        super(nombre, cedula, sueldoBase);
    }
    @Override
    public double calcularSueldo() {
        return this.sueldoBase; 
    }
    @Override
    public String obtenerDetalles() {
        return String.format("ID: %d | Obrero     | Nombre: %-12s | Cedula: %-6s | Sueldo: $%.2f", 
                this.id, this.nombre, this.cedula, calcularSueldo());
    }
}
class Supervisor extends Empleado {
    public Supervisor(String nombre, String cedula, double sueldoBase) {
        super(nombre, cedula, sueldoBase);
    }
    @Override
    public double calcularSueldo() {
        return this.sueldoBase + (this.sueldoBase * 0.15); 
    }
    @Override
    public String obtenerDetalles() {
        return String.format("ID: %d | Supervisor | Nombre: %-12s | Cedula: %-6s | Sueldo: $%.2f", 
                this.id, this.nombre, this.cedula, calcularSueldo());
    }
}
class Gerente extends Empleado {
    public Gerente(String nombre, String cedula, double sueldoBase) {
        super(nombre, cedula, sueldoBase);
    }
    @Override
    public double calcularSueldo() {
        return this.sueldoBase + (this.sueldoBase * 0.25);
    }
    @Override
    public String obtenerDetalles() {
        return String.format("ID: %d | Gerente    | Nombre: %-12s | Cedula: %-6s | Sueldo: $%.2f", 
                this.id, this.nombre, this.cedula, calcularSueldo());
    }
}
public class SistemaNomina {
    public static void main(String[] args) {
        Empleado[] nomina = new Empleado[8];
        
        nomina[0] = new Obrero("Luis Torres", "O-001", 5000);
        nomina[1] = new Obrero("Ana Gimez", "O-002", 5000);
        nomina[2] = new Obrero("Pedro Ruiz", "O-003", 5200);
        nomina[3] = new Obrero("Sofia Vega", "O-004", 4800);
        nomina[4] = new Supervisor("Carlos Diaz", "S-001", 8000);
        nomina[5] = new Supervisor("Laura Perez", "S-002", 8500);
        nomina[6] = new Gerente("Jorge Silva", "G-001", 15000);
        nomina[7] = new Gerente("Marta Rios", "G-002", 16000);
        Empleado.mostrarEstadisticas(nomina);
    }
}