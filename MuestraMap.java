import java.util.HashMap;
import java.util.Map;

public class MuestraMap {
    public static void main(String[] args) {
        Map<String, Double> mapa = new HashMap<>();
        mapa.put("España", 505990.0);
        mapa.put("Francia", 643801.0);
        mapa.put("Alemania", 357022.0);
        mapa.put("Italia", 301340.0);
        mapa.put("Portugal", 92212.0);
        mapa.put("España", 3.1);

        for (String key : mapa.keySet()) {
            System.out.println("País: " + key + ", Extensión: " + mapa.get(key) + " km2");
        }
    }
}
