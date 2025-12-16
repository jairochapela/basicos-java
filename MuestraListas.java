import java.util.LinkedList;
import java.util.List;

public class MuestraListas {
    public static void main(String[] args) {
        
        List<String> palabras = new LinkedList<>();

        // Añadir elementos
        palabras.add("Alpha");
        palabras.add("Bravo");
        palabras.add("Charlie");
        palabras.add("Delta");

        for (String palabra : palabras) {
            System.out.println(palabra);
        }

        /*for (int i = 0; i < palabras.size(); i++) {
            System.out.println("Palabra en la posición " + i + ": " + palabras.get(i));
        }*/

        // Quitar elementos
        palabras.remove("Bravo"); // Indicamos elemento a eliminar
        palabras.remove(0); // Indicamos posición del elemento a eliminar

        System.out.println("Después de eliminar elementos:");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }
}
