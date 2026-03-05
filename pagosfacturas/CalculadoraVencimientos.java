package pagosfacturas;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;


public class CalculadoraVencimientos {

    private static Set<LocalDate> festivos = null;

    private static Set<LocalDate> getFestivos() {
        if (festivos == null) {
            Properties prop = new Properties();
            festivos = new HashSet<>();
            try {
                prop.loadFromXML(new FileInputStream("data/festivos.xml"));
                prop.keySet().forEach(key -> {
                    String fechaStr = prop.getProperty((String) key);
                    LocalDate fecha = LocalDate.parse(fechaStr);
                    festivos.add(fecha);
                });
            } catch (Exception e) {
                System.err.println("Error al cargar festivos." + e.getMessage());
            }
        }
        return festivos;
    }


    private static LocalDate addDiasHabiles(LocalDate fecha, int diasHabiles) {
        Set<LocalDate> fest = getFestivos();
        while (diasHabiles > 0) {
            fecha = fecha.plusDays(1);
            if (fecha.getDayOfWeek() != SATURDAY && fecha.getDayOfWeek() != SUNDAY && !fest.contains(fecha)) {
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
                return fechaEmision.withDayOfMonth(1).plusMonths(1).minusDays(1);

            case DIA_15_MES_SIGUIENTE:
                return fechaEmision.plusMonths(1).withDayOfMonth(15);
            
            case SESENTA_DIAS_NATURALES:
                return fechaEmision.plusDays(60);
            
            case SESENTA_DIAS_HABILES:
                return addDiasHabiles(fechaEmision, 60);

            default:
                return fechaEmision; // Este caso nunca se dará
        }
    }



    public static void main(String[] args) {

        try {
            BufferedReader rd = new BufferedReader(new FileReader("data/pagos.txt"));
            rd.lines().forEach(linea -> {
                String [] partes = linea.split("\\t");
                String idPago = partes[0];
                LocalDate fechaEmision = LocalDate.parse(partes[1]);
                TipoVencimiento tipo = TipoVencimiento.valueOf(partes[2]);
                LocalDate vencimiento = calcularVencimiento(fechaEmision, tipo);
                System.out.println("Pago ID: " + idPago + ", Fecha de Emisión: " + fechaEmision + ", Tipo de Vencimiento: " + tipo + ", Fecha de Vencimiento: " + vencimiento);
            });
        } catch (FileNotFoundException fnfe) {
            System.err.println("Error: No se ha encontrado el archivo de pagos. " + fnfe.getMessage());
        }
    }
}
