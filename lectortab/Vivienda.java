package lectortab;


public class Vivienda {

    private long id;
    private String nombre;
    private String direccion;
    private String poblacion;
    private int habitaciones;
    private int banos;
    private boolean garaje;
    private boolean piscina;
    
    public Vivienda(long id, String nombre, String direccion, String poblacion, int habitaciones, int banos,
            boolean garaje, boolean piscina) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.habitaciones = habitaciones;
        this.banos = banos;
        this.garaje = garaje;
        this.piscina = piscina;
    }

    public Vivienda() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getBanos() {
        return banos;
    }

    public void setBanos(int banos) {
        this.banos = banos;
    }

    public boolean hasGaraje() {
        return garaje;
    }

    public void setGaraje(boolean garaje) {
        this.garaje = garaje;
    }

    public boolean hasPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    @Override
    public String toString() {
        return "Vivienda [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", poblacion=" + poblacion
                + ", habitaciones=" + habitaciones + ", banos=" + banos + ", garaje=" + garaje + ", piscina=" + piscina
                + "]";
    }

}
