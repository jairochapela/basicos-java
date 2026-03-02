import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Locale;

public class QueDiaEsHoy {
    public static void main(String[] args) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicio = LocalDate.of(2025, 12, 1);

        System.out.println("Hoy es: " + fechaActual);
        DayOfWeek diaSemana = fechaActual.getDayOfWeek();
        System.out.println("Día de la semana: " + diaSemana);
        System.out.println("Día de la semana (local): " + diaSemana.getDisplayName(TextStyle.FULL, Locale.getDefault()));
        // System.out.println("Día de la semana (local): " + diaSemana.getDisplayName(TextStyle.FULL,  Locale.of("es", "ES")));

        Period periodo = Period.between(fechaInicio, fechaActual);
        System.out.println("Han pasado " + periodo.getYears() + " años, " 
            + periodo.getMonths() + " meses y " 
            + periodo.getDays() + " días desde el comienzo del curso.");

        long dias = fechaActual.toEpochDay() - fechaInicio.toEpochDay();
        System.out.println("Han pasado " + dias + " dias desde el comienzo del curso.");

        LocalDate fechaMañana = fechaActual.plusDays(1);
        System.out.println("Mañana será: " + fechaMañana);
    }
}
