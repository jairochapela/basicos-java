package calificaciones;

public class Calificacion {
    
    private String alumno;
    private String clase;
    private double notaTeoria;
    private double notaPractica;

    public Calificacion(String alumno, String clase, double notaTeoria, double notaPractica) {
        this.alumno = alumno;
        this.clase = clase;
        this.notaTeoria = notaTeoria;
        this.notaPractica = notaPractica;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public double getNotaTeoria() {
        return notaTeoria;
    }

    public void setNotaTeoria(double notaTeoria) {
        this.notaTeoria = notaTeoria;
    }

    public double getNotaPractica() {
        return notaPractica;
    }

    public void setNotaPractica(double notaPractica) {
        this.notaPractica = notaPractica;
    }

    @Override
    public String toString() {
        return "Calificacion [alumno=" + alumno + ", clase=" + clase + ", notaTeoria=" + notaTeoria + ", notaPractica="
                + notaPractica + "]";
    }



    
}
