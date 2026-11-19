class Animal {
    public void hacerSonido() {
        System.out.println("El animal hace un sonido genérico.");
    }
    public void moverse() {
        System.out.println("El animal se mueve.");
    }
}
class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("El perro dice: Guau, guau!");
    }
    @Override
    public void moverse() {
        System.out.println("El perro corre a cuatro patas.");
    }
}
class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("El gato dice: Miau, miau!");
    }
    @Override
    public void moverse() {
        System.out.println("El gato salta con agilidad.");
    }
}
class Pajaro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("El pajaro dice: Pio, pio!");
    }
    @Override
    public void moverse() {
        System.out.println("El pajaro vuela por el aire.");
    }
}
class Serpiente extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("La serpiente sisea: Ssssssssss!");
    }
    @Override
    public void moverse() {
        System.out.println("La serpiente se arrastra por el suelo.");
    }
}
public class SistemaAnimales {
    public static void main(String[] args) {
        System.out.println("Creando el array");   
        Animal[] animales = new Animal[4];
        animales[0] = new Perro();
        animales[1] = new Gato();
        animales[2] = new Pajaro();
        animales[3] = new Serpiente();
        for (Animal a : animales) {
            System.out.println("Objeto de tipo: " + a.getClass().getSimpleName());
            a.hacerSonido();
            a.moverse();
            System.out.println("-----------------------------------");
        }
    }
}
