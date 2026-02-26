package figuras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        
        Collections.sort(figuras, (figura1, figura2) -> figura1.perimetro() > figura2.perimetro() ? -1 : 1);
        // Collections.sort(figuras, new Comparator<Figura>() {
        //     @Override
        //     public int compare(Figura figura1, Figura figura2) {
        //         return figura1.perimetro() > figura2.perimetro() ? -1 : 1;
        //     }
        // });

        for (Figura f : figuras) {
            System.out.println("Figura: " + f.getClass().getSimpleName());
            System.out.println("Área: " + f.area());
            System.out.println("Perímetro: " + f.perimetro());
            System.out.println();
        }
    }
}
