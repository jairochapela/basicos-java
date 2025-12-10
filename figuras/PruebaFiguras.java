package figuras;

import java.util.ArrayList;
import java.util.List;

public class PruebaFiguras {
    
    public static void main(String[] args) {
        Rectangulo r = new Rectangulo(8, 5);
        Triangulo t = new Triangulo(3, 2);
        Circulo c = new Circulo(5);
        Cuadrado q = new Cuadrado(4);

        // Solo puedo crear una lista de objetos del mismo tipo
        List<Figura> figuras = new ArrayList<>();
        figuras.add(r);
        figuras.add(t);
        figuras.add(c);
        figuras.add(q);
        
        for (Figura f : figuras) {
            System.out.println("Figura: " + f.getClass().getSimpleName());
            System.out.println("Área: " + f.area());
            System.out.println("Perímetro: " + f.perimetro());
            System.out.println();
        }
    }
}
