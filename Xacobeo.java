import java.time.LocalDate;
import static java.time.DayOfWeek.SUNDAY;

/**
 * Años jacobeos son los años en que el 25 de julio, festividad de
 * Santiago Apóstol, cae en domingo.
 * 
 * Este programa calcula los 10 próximos años jacobeos.
 * 
 * 1. Obtener el año actual
 * 2. Iniciar contador = 0
 * 3. Repetir mientras contador < 10:
 * 4.   Construir fecha de 25 de julio del año actual
 * 5.   Si el día de la semana de esa fecha == DOMINGO:
 * 6.       Imprimir año actual
 * 7.       Incrementar contador en 1
 * 8.   Incrementar año actual en 1
 */
public class Xacobeo {
    

    public static void main(String[] args) {
        int año = LocalDate.now().getYear();
        int contador = 0;

        while (contador < 10) {
            // Construir fecha de 25 de julio del año actual
            LocalDate fechaAñoActual = LocalDate.of(año, 7, 25);

            if (fechaAñoActual.getDayOfWeek() == SUNDAY) {
                System.out.println(año);
                contador++;
            }

            año++;
        }
    }

}
