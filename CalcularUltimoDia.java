import java.time.LocalDate;

import java.time.temporal.TemporalAdjusters;



public class CalcularUltimoDia {

    public static void main(String[] args) {

        // Código original dentro del método ejecutable

        LocalDate hoy = LocalDate.now();

        LocalDate ultimoDia = hoy.with(TemporalAdjusters.lastDayOfMonth());



        System.out.println("Hoy es: " + hoy);

        System.out.println("Último día del mes: " + ultimoDia);

    }

}