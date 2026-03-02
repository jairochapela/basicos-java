package pagosfacturas;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

import java.time.LocalDate;


public class CalculadoraVencimientos {


    private static LocalDate addDiasHabiles(LocalDate fecha, int diasHabiles) {
        while (diasHabiles > 0) {
            fecha = fecha.plusDays(1);
            //TODO: considerar festivos
            if (fecha.getDayOfWeek() != SATURDAY && fecha.getDayOfWeek() != SUNDAY) {
                diasHabiles--;
            }
        }
        return fecha;
    }
    
    public static LocalDate calcularVencimiento(LocalDate fechaEmision, TipoVencimiento tipo) {
        switch (tipo) {
            case AL_CONTADO:
                return fechaEmision;
        
            case TREINTA_DIAS_NATURALES:
                return fechaEmision.plusDays(30);

            case TREINTA_DIAS_HABILES:
                return addDiasHabiles(fechaEmision, 30);

            case FIN_MES:
                // Hay que tener en cuenta que no todos los meses tienen el mismo número de días.
                // Una posible solución es construir le fecha del día 1 del mes siguiente y luego
                // restarle un día.
                return null; // TODO: implementar este caso

            case DIA_15_MES_SIGUIENTE:
                return null; // TODO: implementar este caso
            
            case SESENTA_DIAS_NATURALES:
                return null; // TODO: implementar este caso
            
            case SESENTA_DIAS_HABILES:
                return null; // TODO: implementar este caso

            default:
                return fechaEmision; // Este caso nunca se dará
        }
    }



    public static void main(String[] args) {
        // Casos de prueba
        LocalDate[] fechas = {
            LocalDate.of(2026, 3, 3),
            LocalDate.of(2026, 3, 6),
            LocalDate.of(2026, 3, 7),
        };
        TipoVencimiento[] vencimientos = {
            TipoVencimiento.AL_CONTADO,
            TipoVencimiento.TREINTA_DIAS_NATURALES,
            TipoVencimiento.TREINTA_DIAS_HABILES
        };

        for(int i = 0; i < fechas.length; i++) {
            System.out.println("Factura emitida con fecha: " + fechas[i]);
            System.out.println("Vencimiento: " + vencimientos[i]);
            System.out.println("Fecha de vencimiento: " + calcularVencimiento(fechas[i], vencimientos[i]));
            System.out.println("-----------------------------");
        }
    }
}
