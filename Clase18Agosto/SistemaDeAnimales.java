abstract class Animal {
    public abstract void hacerSonido();
    public abstract void moverse();
}
class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("El perro ladra: Guau, guau!");
    }
    @Override
    public void moverse() {
        System.out.println("El perro corre alegremente.");
    }
}
class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("El gato maulla: Miau, miau!");
    }
    @Override
    public void moverse() {
        System.out.println("El gato camina sigilosamente.");
    }
}
class Pajaro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("El pjaro canta: Pio, pio!");
    }
    @Override
    public void moverse() {
        System.out.println("El pjaro vuela por el aire.");
    }
}
class Serpiente extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("La serpiente sisea: Ssss, ssss!");
    }
    @Override
    public void moverse() {
        System.out.println("La serpiente se arrastra por el suelo.");
    }
}
public class SistemaDeAnimales {
    public static void main(String[] args) {
        Animal[] misAnimales = new Animal[4];
        misAnimales[0] = new Perro();
        misAnimales[1] = new Gato();
        misAnimales[2] = new Pajaro();
        misAnimales[3] = new Serpiente();
        System.out.println("Sistema de Animales:");
        for (Animal animal : misAnimales) {
            System.out.println("\nAnimal: " + animal.getClass().getSimpleName());
            animal.hacerSonido();
            animal.moverse();
        }
    }
}