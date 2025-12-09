import java.util.Date;

public class Typecasts {
    
    public static void main(String[] args) {
        int a = 5;
        double b = 7.23;

        // Conversión implícita de int a double
        double suma = a + b; // 'a' se convierte automáticamente a double
        System.out.println("Suma (implícita): " + suma);

        // Conversión explícita de double a int (forzar tipo)
        int sumaEntera =  (int) suma;
        System.out.println("Suma (explícita): " + sumaEntera);

        Date hoy = new Date();
        System.out.println("Fecha de hoy: " + hoy);

        Object objeto = hoy; // Upcasting (implícito)
        System.out.println("Objeto: " + objeto);

        Date fechaRecuperada = (Date) objeto; // Downcasting (explícito)
        System.out.println("Fecha recuperada: " + fechaRecuperada);

        long ts = hoy.getTime();
        String representacionFecha = hoy.toString();
        System.out.println("Timestamp: " + ts + ", Representación: " + representacionFecha);
    }

}
