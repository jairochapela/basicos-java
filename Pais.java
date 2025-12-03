public class Pais {
    
    private String nombre;
    private String capital;
    private int poblacion;
    private double extension; // en km2
    private String moneda;

    Pais(String nombre, String capital, int poblacion, double extension, String moneda) {
        // Establecemos valores iniciales para los atributos
        this.nombre = nombre;
        this.capital = capital;
        this.poblacion = poblacion;
        this.extension = extension;
        this.moneda = moneda;
    }

    public double densidadPoblacion() {
        return poblacion / extension;
    } 

    @Override
    public String toString() {
        return "País: " + nombre + "\t" +
               "Capital: " + capital + "\t" +
               "Población: " + poblacion + " hab.\t" +
               "Extensión: " + extension + " km2\t" +
               "Moneda: " + moneda;
    }

    public static void main(String[] args) {
        Pais a = new Pais("España", "Madrid", 47350000, 505990.0, "Euro");

        Pais b = new Pais("Francia", "París", 67060000, 643801.0, "Euro");

        System.out.println(a);
        System.out.println("Densidad de población: " + a.densidadPoblacion() + " hab/km2");

        System.out.println(b);
        System.out.println("Densidad de población: " + b.densidadPoblacion() + " hab/km2");
    }

}
