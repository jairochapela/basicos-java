package pagosfacturas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class CalculadoraVencimientosTest {
    
    @Test
    public void testAlContado() {
        LocalDate fechaInicial = LocalDate.of(2026, 3, 3);
        LocalDate vencimiento = LocalDate.of(2026, 3, 3);
        assertEquals(
            vencimiento, 
            CalculadoraVencimientos.calcularVencimiento(fechaInicial, TipoVencimiento.AL_CONTADO)
        );
    }

    @Test
    public void testTreintaDiasNaturales() {
        LocalDate fechaInicial = LocalDate.of(2026, 3, 6);
        LocalDate vencimiento = LocalDate.of(2026, 4, 5);
        assertEquals(
            vencimiento,
            CalculadoraVencimientos.calcularVencimiento(fechaInicial, TipoVencimiento.TREINTA_DIAS_NATURALES)
        );
    }

    @Test
    public void testTreintaDiasHabiles() {
        LocalDate fechaInicial = LocalDate.of(2026, 3, 5);
        LocalDate vencimiento = LocalDate.of(2026, 4, 17);
        assertEquals(
            vencimiento,
            CalculadoraVencimientos.calcularVencimiento(fechaInicial, TipoVencimiento.TREINTA_DIAS_HABILES)
        );
    }

    @Test
    public void testFinMes() {
        LocalDate fechaInicial = LocalDate.of(2026, 3, 7);
        LocalDate vencimiento = LocalDate.of(2026, 3, 31);
        assertEquals(
            vencimiento,
            CalculadoraVencimientos.calcularVencimiento(fechaInicial, TipoVencimiento.FIN_MES)
        );
    }

    @Test
    public void testDia15MesSiguiente() {
        LocalDate fechaInicial = LocalDate.of(2026, 3, 8);
        LocalDate vencimiento = LocalDate.of(2026, 4, 15);
        assertEquals(
            vencimiento,
            CalculadoraVencimientos.calcularVencimiento(fechaInicial, TipoVencimiento.DIA_15_MES_SIGUIENTE)
        );
    }

    @Test
    public void testSesentaDiasNaturales() {
        LocalDate fechaInicial = LocalDate.of(2026, 3, 8);
        LocalDate vencimiento = LocalDate.of(2026, 5, 7);
        assertEquals(
            vencimiento,
            CalculadoraVencimientos.calcularVencimiento(fechaInicial, TipoVencimiento.SESENTA_DIAS_NATURALES)
        );
    }

    @Test
    public void testSesentaDiasHabiles() {
        LocalDate fechaInicial = LocalDate.of(2026, 3, 5);
        LocalDate vencimiento = LocalDate.of(2026, 6, 1);
        assertEquals(
            vencimiento,
            CalculadoraVencimientos.calcularVencimiento(fechaInicial, TipoVencimiento.SESENTA_DIAS_HABILES)
         );
    }


}
