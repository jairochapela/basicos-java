package personal;

public class Empleado extends Persona {
    
    protected Long numeroEmpleado;
    protected String puesto;

    public Empleado() {
    }

    public Empleado(String nombre, String apellidos, Long numeroEmpleado, String puesto) {
        super(nombre, apellidos);
        this.numeroEmpleado = numeroEmpleado;
        this.puesto = puesto;
    }

    public Long getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(Long numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

}
