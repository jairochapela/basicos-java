package lectortab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class LectorTabStream {


    // public static Stream<Vivienda> leerViviendasDesdeFicheroTSV(String rutaFichero) throws FileNotFoundException, IOException {
    //     BufferedReader in = new BufferedReader(new FileReader(rutaFichero));
    //     Stream<String> ss = in.lines();
    //     ss = ss.skip(1); //Saltamos línea de cabeceras
    //     Stream<String[]> st = ss.map(linea -> linea.split("\t"));
    //     Stream<Vivienda> sv = st.map(trocitos -> {
    //         long id = Long.parseLong(trocitos[0]);
    //         String nombre = trocitos[1];
    //         String direccion = trocitos[2];
    //         String poblacion = trocitos[3];
    //         int habitaciones = Integer.parseInt(trocitos[4]);
    //         int banos = Integer.parseInt(trocitos[5]);
    //         boolean garaje = Boolean.parseBoolean(trocitos[6]);
    //         boolean piscina = Boolean.parseBoolean(trocitos[7]);
    //         return new Vivienda(id, nombre, direccion, poblacion, habitaciones,
    //                 banos, garaje, piscina);
    //     });

    //     return sv;
    // }


    public static Stream<Vivienda> leerViviendasDesdeFicheroTSV(String rutaFichero) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader(rutaFichero));
        return in.lines().skip(1) //Saltamos línea de cabeceras
            .map(linea -> linea.split("\t"))
            .map(trocitos -> new Vivienda(
                Long.parseLong(trocitos[0]), trocitos[1], trocitos[2], trocitos[3],
                Integer.parseInt(trocitos[4]), Integer.parseInt(trocitos[5]),
                Boolean.parseBoolean(trocitos[6]), Boolean.parseBoolean(trocitos[7]))
            );
    }

    
    public static void main(String[] args) {
        try {
            leerViviendasDesdeFicheroTSV("data/MOCK_DATA.txt")
                .filter(v -> v.hasGaraje())
                // .sorted((a, b) -> Integer.compare(b.getHabitaciones(), a.getHabitaciones())) // Ordenamos por número de habitaciones de mayor a menor
                // .sorted((a, b) -> {
                //     int resultado = a.getHabitaciones() - b.getHabitaciones();
                //     if (resultado == 0) {
                //         resultado = a.getBanos() - b.getBanos();
                //     }
                //     return -resultado;
                // })
                .forEach(v -> {
                    System.out.println("ID: " + v.getId());
                    System.out.println("Nombre: " + v.getNombre());
                    System.out.println("Dirección: " + v.getDireccion());
                    System.out.println("Población: " + v.getPoblacion());
                    System.out.println("Habitaciones: " + v.getHabitaciones());
                    System.out.println("Baños: " + v.getBanos());
                    System.out.println("Garaje: " + v.hasGaraje());
                    System.out.println("Piscina: " + v.hasPiscina());
                    System.out.println("-----------------------------");
                });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }

}
