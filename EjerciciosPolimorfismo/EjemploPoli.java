public class EjemploPoli {
    public static void main(String[] args) {
        Triangulo fig1= new Triangulo();
        Cuadrado fig2 = new Cuadrado();
        Circulos fig3 = new Circulos();
        fig1.dibujar();
        fig2.dibujar();
        fig3.dibujar();
        Figura [] figus = new Figura[3];
        figus[0]= new Circulos();
        figus[1]= new Triangulo();
        figus[2]= new Cuadrado();
        for (Figura f :figus){
            f.dibujar();
        }
    }
}
class Figura{
public void dibujar(){
    System.out.println("Dibujando una figura");
}
}
 class Circulos extends Figura {
@Override
public void dibujar(){
    System.out.println("Dibujando un circulo");
}
}
class Triangulo extends Figura {
@Override
public void dibujar(){
    System.out.println("Dibujando un triangulo");
}
}
class Cuadrado extends Figura {
@Override
public void dibujar(){
    System.out.println("Dibujando un cuadrado");
}
}


