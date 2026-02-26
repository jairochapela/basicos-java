package personal;

import java.util.List;

public class Directivo extends Empleado {
    
    private List<Empleado> equipo;

    public Directivo() {
    }

    public Directivo(String nombre, String apellidos, Long numeroEmpleado, String puesto, List<Empleado> equipo) {
        super(nombre, apellidos, numeroEmpleado, puesto);
        this.equipo = equipo;
    }

    public List<Empleado> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Empleado> equipo) {
        this.equipo = equipo;
    }

    
}
