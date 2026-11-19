class Vehiculo {
    protected String modelo;
    protected int anio;
    protected int velocidad;
    public Vehiculo(String modelo, int anio, int velocidad) {
        this.modelo = modelo;
        this.anio = anio;
        this.velocidad = velocidad;
    }
    public void acelerar() {
        velocidad += 20;
        System.out.println("Acelerando  Velocidad actual: " + velocidad + " km/h");
    }
    public void frenar() {
        velocidad -= 10;
        if (velocidad < 0) velocidad = 0;
        System.out.println("Frenando  Velocidad actual: " + velocidad + " km/h");
    }
    public void mostrarDetalles() {
        System.out.println("Modelo: " + modelo + " | Año: " + anio + " | Velocidad: " + velocidad + " km/h");
    }
}
class Auto extends Vehiculo {
    protected int puertas; 

    public Auto(String modelo, int anio, int velocidad, int puertas) {
        super(modelo, anio, velocidad); 
        this.puertas = puertas;
    }
    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Tipo: Auto | Puertas: " + puertas);
    }
}
class Moto extends Vehiculo {
    private boolean tieneSidecar; 

    public Moto(String modelo, int anio, int velocidad, boolean tieneSidecar) {
        super(modelo, anio, velocidad);
        this.tieneSidecar = tieneSidecar;
    }
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Tipo: Moto | Tiene Sidecar: " + (tieneSidecar ? "Si" : "No"));
    }
}
class Camion extends Vehiculo {
    private double capacidadCargaTon; 
    public Camion(String modelo, int anio, int velocidad, double capacidadCargaTon) {
        super(modelo, anio, velocidad);
        this.capacidadCargaTon = capacidadCargaTon;
    }
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Tipo: Camion | Capacidad de carga: " + capacidadCargaTon + " toneladas");
    }
}
class AutoDeportivo extends Auto {
    private boolean motorTurbo; 
    public AutoDeportivo(String modelo, int anio, int velocidad, int puertas, boolean motorTurbo) {
        super(modelo, anio, velocidad, puertas); // Uso de super() hacia Auto
        this.motorTurbo = motorTurbo;
    }
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Subtipo: Auto Deportivo | Motor Turbo: " + (motorTurbo ? "Si" : "No"));
    }
}
public class Principal {
    public static void main(String[] args) {       
        Vehiculo[] flota = new Vehiculo[4];
        flota[0] = new Auto("Toyota Corolla", 2021, 0, 4);
        flota[1] = new Moto("Harley Davidson", 2019, 0, false);
        flota[2] = new Camion("Volvo FH", 2020, 0, 18.5);
        flota[3] = new AutoDeportivo("Porsche 911", 2023, 0, 2, true);
        System.out.println(" SISTEMA DE VEHICULOS ");
        for (int i = 0; i < flota.length; i++) {
            System.out.println("\nVehiculo #" + (i + 1));
            flota[i].mostrarDetalles();
            flota[i].acelerar();
            flota[i].frenar();
        }
    }
}