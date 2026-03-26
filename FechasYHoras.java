import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.zone.ZoneOffsetTransition;
import java.util.Set;

public class FechasYHoras {
    

    public static void main(String[] args) {
        
        // Zonas horarias disponibles
        Set<String> allZones = ZoneId.getAvailableZoneIds();
        for (String zona : allZones) {
            Instant ahora = Instant.now();
            ZoneOffset offset = ZoneId.of(zona).getRules().getOffset(ahora);
            ZoneOffsetTransition proximaTransicion = ZoneId.of(zona).getRules().nextTransition(ahora);
            System.out.println("Zona: " + zona + "\tOffset actual: " + offset);
            if (proximaTransicion == null) continue;
            Instant proximoCambioAHorarioDeVerano = proximaTransicion.getInstant();
            ZoneOffset offsetVerano = ZoneId.of(zona).getRules().getOffset(proximoCambioAHorarioDeVerano);
            System.out.println("\t" + proximaTransicion + ": " + offset + " -> " + offsetVerano);
        }
    }
}
