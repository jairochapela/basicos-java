import java.util.Scanner;

public class Estadisticas {
    
    public static void main(String[] args) {
        int n = 0;
        double suma = 0.0;

        Scanner s = new Scanner(System.in);
        
        System.out.println("Cálculo de estadísticas. Introduzca a continuación datos numéricos o FIN para terminar.");

        while (!s.hasNext("FIN")) {
            System.out.println("Introduce un dato numérico:");

            // Protegemos el código contra excepciones (entrada no numérica)
            try {


                double x = s.nextDouble();

                suma += x; // Le sumamos x a la suma total
                n++;  // Le sumamos 1 a n

                System.out.println("Número de muestras: " + n);
                System.out.println("Suma total: " + suma);
                System.out.println("Media: " + (suma / n));
            } catch (Exception e) {
                System.err.println("Error: Dato incorrecto. Por favor, introduce un número válido.");
                s.next(); // Limpiamos el scanner
            }

        }

        s.close();
    }
}
