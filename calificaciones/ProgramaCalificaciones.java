package calificaciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProgramaCalificaciones {
    
    public static void main(String[] args) {
        
        // Configuración regional específica y tratamiento de números con formato local
        Locale.setDefault(Locale.of("es", "ES"));
        NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());

        try {
            FileReader reader = new FileReader("data/calificaciones.tsv");
            BufferedReader br = new BufferedReader(reader);

            List<Calificacion> listaCalificaciones = leerCalificacionesFicheroTSV(nf, br);

            // Cerramos flujo de lectura
            br.close();

            showNotasFinales(listaCalificaciones);

        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * Método para mostrar por consola las notas finales de cada alumno y un promedio de las mismas.
     * La nota final se calcula como el promedio de la nota de teoría y la nota de práctica.
     * @param listaCalificaciones Lista de objetos Calificacion con los datos de cada alumno y sus notas.
     */
    private static void showNotasFinales(List<Calificacion> listaCalificaciones) {
        double sumaNotasFinales = 0.0;
        for (Calificacion c : listaCalificaciones) {
            double notaFinal = (c.getNotaTeoria() + c.getNotaPractica()) / 2;
            sumaNotasFinales += notaFinal;
            System.out.println("Alumno: " + c.getAlumno() + ", Clase: " + c.getClase() + ", Nota final: " + notaFinal);
        }

        double mediaNotasFinales = sumaNotasFinales / listaCalificaciones.size();
        System.out.println("Media de las notas finales: " + mediaNotasFinales);
    }

    /**
     * Este método lee de un fichero separado por tabuladores (TSV) los datos de calificaciones, procesando linea a línea
     * y generando una lista de objetos Calificacion.
     * @param nf Formato numérico utilizado para interpretar las notas con formato local
     * @param br BufferedReader que contiene la información del fichero.
     * @return Lista de objetos Calificacion con los datos procesados del fichero.
     * @throws IOException En caso de error de E/S al leer el fichero, lanzará esta excepción.
     */
    private static List<Calificacion> leerCalificacionesFicheroTSV(NumberFormat nf, BufferedReader br) throws IOException {
        String linea = br.readLine(); // Leer la primera línea (cabecera)
        int contadorLineas = 1;
        List<Calificacion> listaCalificaciones = new ArrayList<>();

        while (true) {
            // Leer la siguiente línea (datos)
            linea = br.readLine(); 
            if (linea == null) break; // Si no hay más líneas, salir del bucle
            contadorLineas++;

            // Procesar la línea de datos
            try {
                Calificacion c = parseCalificacion(nf, linea);
                // Añadimos el objeto a la lista de calificaciones
                listaCalificaciones.add(c);
            } catch (ParseException pe) {
                System.err.println("Error procesando la línea " + contadorLineas + ": " + pe.getMessage());
            }
        }
        return listaCalificaciones;
    }

    /**
     * Método para procesar una línea de texto y convertirla en un objeto Calificacion.
     * @param nf Formato numérico utilizado para interpretar las notas con formato local
     * @param linea Línea de entrada con los siguientes datos: alumno, nota teoría, nota práctica (separados por tabuladores)
     * @return Objeto Calificacion con los datos procesados
     * @throws ParseException En caso de error al parsear datos numéricos, lanzará esta excepción.
     */
    private static Calificacion parseCalificacion(NumberFormat nf, String linea) throws ParseException {
        String[] partes = linea.split("\t"); // Trocear la línea, el tabulador es el separador
        String alumno = partes[0];
        String clase = partes[1];
        double notaTeoria = nf.parse(partes[2]).doubleValue();
        double notaPractica = nf.parse(partes[3]).doubleValue();

        // Creamos el objeto Calificacion con los datos procesados
        return new Calificacion(alumno, clase, notaTeoria, notaPractica);
    }
}
