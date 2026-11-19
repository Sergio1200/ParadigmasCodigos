public class App {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(5.0);
        Rectangulo rectangulo = new Rectangulo(4.0, 3.0);
        System.out.println("Area del circulo "+circulo.calcularArea());
        System.out.println("Area del rectangulo "+rectangulo.calcularArea());
        circulo.mostrarNombre();
        rectangulo.mostrarNombre();
    }
}

abstract class Figura{
    abstract double calcularArea();
    void mostrarNombre(){
        System.out.println("Esta es una figura");
    }
}
class Circulo extends Figura{
    private double radio;
    public Circulo(double radio){
        this.radio = radio;
    }
    @Override
    double calcularArea(){
        return Math.PI*radio*radio;
    }
}
class Rectangulo extends Figura{
    private double longitud;
    private double anchura;
    public Rectangulo(double longitud, double anchura){
        this.longitud = longitud;
        this.anchura = anchura;
    }
    @Override
    double calcularArea(){
        return longitud*anchura;
    }
}