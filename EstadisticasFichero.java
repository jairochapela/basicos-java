import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Cálculo de estadísticos básicos (número de muestras, suma total y media)
 * a partir de datos numéricos leídos desde un fichero de texto.
 */
public class EstadisticasFichero {

    private int numeroMuestras;
    private double suma;
    
    /**
     * Constructor. Pone a cero los contadores.
     */
    public EstadisticasFichero() {
        numeroMuestras = 0;
        suma = 0.0;
    }

    /**
     * Procesa una nueva muestra, actualizando los contadores.
     * @param x La nueva muestra a procesar.
     */
    public void procesarMuestra(double x) {
        suma += x;
        numeroMuestras++;
    }

    /**
     * Devuelve el número de muestras procesadas.
     */
    public int getNumeroMuestras() {
        return numeroMuestras;
    }

    /**
     * Devuelve la suma total de las muestras procesadas.
     */
    public double getSuma() {
        return suma;
    }

    /**
     * Devuelve la media de las muestras procesadas.
     */
    public double getMedia() throws IllegalStateException {
        if (numeroMuestras == 0) {
            throw new IllegalStateException("No es posible obtener la media dado que no hay muestras procesadas.");
        }
        return suma / numeroMuestras;
    }



    public static void main(String[] args) {

        // Creamos el objeto para calcular las estadísticas
        EstadisticasFichero estadisticas = new EstadisticasFichero();

        // Este contador llevará el número de línea leída, para informar de errores si es el caso
        int numLinea = 0;

        try {
            // Tomamos el primer argumento del programa como nombre del fichero a leer
            String nombreFichero = args[0];
            // Abrimos el fichero para lectura, y lo recorremos línea a línea
            FileReader reader = new FileReader(nombreFichero);
            BufferedReader br = new BufferedReader(reader);
            // Mientras haya líneas por leer...
            while (br.ready()) {
                // ... leemos la línea, la convertimos a número y la procesamos con el objeto estadísticas
                String linea = br.readLine();
                numLinea++;
                double muestra = Double.parseDouble(linea); 
                estadisticas.procesarMuestra(muestra);
            }
            // Cerramos el fichero
            br.close();

            // Mostramos los resultados calculados por el objeto estadísticas
            System.out.println("Número de muestras: " + estadisticas.getNumeroMuestras());
            System.out.println("Suma total: " + estadisticas.getSuma());
            System.out.println("Media: " + estadisticas.getMedia());

        
        } catch (FileNotFoundException e) {
            // En caso de error de fichero no encontrado:
            System.err.println("Error: Fichero no encontrado: " + e.getMessage());
        } catch (IOException e) {
            // En caso de error de lectura del fichero, en general:
            System.err.println("Error: Problema accediendo al fichero: " + e.getMessage());
        } catch (NumberFormatException e) {
            // En caso de error al convertir una línea a número:
            System.err.println("Error: Dato incorrecto en la línea " + numLinea + ": " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            // En caso de no haberse proporcionado el nombre del fichero:
            System.err.println("Error: Debe proporcionar el nombre del fichero como argumento.\nEjemplo de uso: java EstadisticasFichero datos.txt");        
        } catch (IllegalStateException e) {
            // En caso de error al calcular la media sin muestras:
            System.err.println("Error: Situación inesperada: " + e.getMessage());
        } catch (Exception e) {
            // En caso de cualquier otro error inesperado:
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
