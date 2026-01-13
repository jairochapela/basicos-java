import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class MartesTrece {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el año a consultar
        System.out.print("Introduce el año: ");
        int ano = scanner.nextInt();

        // Recorrer todos los meses desde enero (0) hasta diciembre (11)
        for (int mes = Calendar.JANUARY; mes <= Calendar.DECEMBER; mes++) {
            // Establecer la fecha a día 13 del mes actual y año actual
            GregorianCalendar fecha = new GregorianCalendar(ano, mes, 13);

            // Si el día de la semana es martes (3):
            if (fecha.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
                // Imprimir "El mes [mes] tiene martes 13"

                System.out.println("El mes " 
                + fecha.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
                + " tiene martes 13");
            }
        }
    }
    
}

