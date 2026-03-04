package lectortab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LectorTab {

    /*
    1. Abrir fichero de texto con la información de las viviendas
    2. Crear una lista vacía de objetos Vivienda
    3. Repetir mientras no se alcance el final del fichero:
        3.1 Leer la siguiente línea del fichero y almacenarla en una variable string
        3.2 Dividir la línea en partes, considerando como separador \t (tabulador)
        3.3 Convertir cada parte a su tipo de datos correspondiente
            (id: long, nombre: String, direccion: String, poblacion: String,
            habitaciones: int, banos: int, garaje: boolean, piscina: boolean)
        3.4 Crear un objeto Vivienda con los datos leídos
        3.5 Añadir el objeto Vivienda a la lista de viviendas
    4. Cerrar el fichero
    5. Retornar la lista de viviendas
     */

    public static List<Vivienda> leerViviendasDesdeFicheroTSV(String rutaFichero) throws FileNotFoundException, IOException {
        // Abrir fichero de texto con la información de las viviendas
        BufferedReader in = new BufferedReader(new FileReader(rutaFichero));
        in.readLine(); // Leer la primera línea (cabecera) y descartarla

        // Crear una lista vacía de objetos Vivienda
        List<Vivienda> viviendas = new ArrayList<>();

        // Repetir mientras no se alcance el final del fichero
        while (in.ready()) {
            // Leer la siguiente línea del fichero y almacenarla en una variable string
            String linea = in.readLine();

            try {
                // Dividir la línea en partes, considerando como separador \t (tabulador)
                String[] partes = linea.split("\t");

                // Convertir cada parte a su tipo de datos correspondiente
                long id = Long.parseLong(partes[0]);
                String nombre = partes[1];
                String direccion = partes[2];
                String poblacion = partes[3];
                int habitaciones = Integer.parseInt(partes[4]);
                int banos = Integer.parseInt(partes[5]);
                boolean garaje = Boolean.parseBoolean(partes[6]);
                boolean piscina = Boolean.parseBoolean(partes[7]);

                // Crear un objeto Vivienda con los datos leídos
                Vivienda v = new Vivienda(id, nombre, direccion, poblacion, habitaciones,
                        banos, garaje, piscina);
                // Añadir el objeto Vivienda a la lista de viviendas
                viviendas.add(v);
            } catch (Exception ex) {
                System.out.println("Error al procesar la línea: " + linea);
                System.out.println("Detalles del error: " + ex.getMessage());
            }
        }

        in.close(); // Cerrar el fichero

        return viviendas;
    }
    
    public static void main(String[] args) {
        
        try {
            List<Vivienda> viviendas = leerViviendasDesdeFicheroTSV("data/MOCK_DATA.txt");

            // Filtramos las viviendas que tengan garaje
            List<Vivienda> viviendasConGaraje = new ArrayList<>();
            for (Vivienda v : viviendas) {
                if (v.hasGaraje()) {
                    viviendasConGaraje.add(v);
                }
            }

            // Ordenar por número de habitaciones (de mayor a menor) y, en caso de empate, por número de baños (de mayor a menor)
            viviendasConGaraje.sort(new Comparator<Vivienda>() {

                @Override
                public int compare(Vivienda a, Vivienda b) {
                    
                    int resultado = a.getHabitaciones() - b.getHabitaciones();

                    // Solamente si hay empate en el número de habitaciones, se compara el número de baños
                    if (resultado == 0) {
                        resultado = a.getBanos() - b.getBanos();
                    }

                    return resultado;
                }
                
            });
            
            Collections.reverse(viviendasConGaraje); // Invertimos el orden para que sea de mayor a menor

            // Mostramos por consola todas las viviendas resultantes
            for (Vivienda v : viviendasConGaraje) {
                System.out.println("ID: " + v.getId());
                System.out.println("Nombre: " + v.getNombre());
                System.out.println("Dirección: " + v.getDireccion());
                System.out.println("Población: " + v.getPoblacion());
                System.out.println("Habitaciones: " + v.getHabitaciones());
                System.out.println("Baños: " + v.getBanos());
                System.out.println("Garaje: " + v.hasGaraje());
                System.out.println("Piscina: " + v.hasPiscina());
                System.out.println("-----------------------------");

            }



        } catch (Exception ex) {
            System.out.println("Error al leer el fichero: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
