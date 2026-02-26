package personal;

import java.math.BigDecimal;

public class Accionista extends Persona {
    
    private BigDecimal porcentajeParticipacion;

    public Accionista() {
    }

    public Accionista(String nombre, String apellidos, BigDecimal porcentajeParticipacion) {
        super(nombre, apellidos);
        this.porcentajeParticipacion = porcentajeParticipacion;
    }

    public BigDecimal getPorcentajeParticipacion() {
        return porcentajeParticipacion;
    }

    public void setPorcentajeParticipacion(BigDecimal porcentajeParticipacion) {
        this.porcentajeParticipacion = porcentajeParticipacion;
    }

}
