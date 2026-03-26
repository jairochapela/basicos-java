import java.awt.Dimension;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneOffsetTransition;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import java.awt.BorderLayout;

public class CambioDeHora extends JFrame {
    
    /**
     * Etiqueta para mostrar el mensaje del cambio de hora.
     */
    private JLabel mensajeArea;

    /**
     * Lista desplegable para seleccionar la zona horaria.
     */
    private JComboBox<String> zoneList;

    /**
     * Zona horaria actualmente seleccionada.
     */
    private ZoneId zonaActual = ZoneId.systemDefault();

    /**
     * Temporizador
     */
    Timer temporizador;
    

    CambioDeHora() {
        setTitle("Cambio de Hora");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initGui();
        initTimer();
    }


    private void initTimer() {
        temporizador = new Timer(1000, evento -> {
            actualizarMensaje();
        });
        temporizador.start();
    }


    private void initGui() {
        Set<String> allZones = ZoneId.getAvailableZoneIds();

        zoneList = new JComboBox<>(allZones.stream().sorted().toArray(String[]::new));
        zoneList.setSelectedIndex(4);
        zoneList.addActionListener(evento -> {
            cambiarZonaHoraria((String)zoneList.getSelectedItem());
        });

        getContentPane().add(zoneList, BorderLayout.NORTH);

        mensajeArea = new JLabel("<html></html>");
        mensajeArea.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(mensajeArea, BorderLayout.CENTER);
        //pack();
    }



    private void cambiarZonaHoraria(String selectedItem) {
        zonaActual = ZoneId.of(selectedItem);
        actualizarMensaje();
    }


    private void actualizarMensaje() {
        ZonedDateTime horaLocal = ZonedDateTime.now(zonaActual);
        ZoneOffsetTransition proximaTransicion = zonaActual.getRules().nextTransition(Instant.now());


        String texto = "<html>" +
            "<h1>Zona actual: " + zonaActual + "</h1>\n"
            + "<h2>Hora local actual: " + horaLocal.format(DateTimeFormatter.ISO_LOCAL_TIME) + "</h2>\n";

        if (proximaTransicion != null) {
            Instant cuandoEsCambioDeHora = proximaTransicion.getInstant();
            ZoneOffset offsetVerano = zonaActual.getRules().getOffset(cuandoEsCambioDeHora);
            texto += "<p>Próximo cambio de hora: " + proximaTransicion.getDateTimeBefore().format(DateTimeFormatter.ISO_LOCAL_DATE) + "</p>\n"
                + "<p>Hora local en el momento del cambio: " + proximaTransicion.getDateTimeBefore().format(DateTimeFormatter.ISO_LOCAL_TIME) + "</p>\n"
                + "<p>Hora tras el cambio: " + proximaTransicion.getDateTimeAfter().format(DateTimeFormatter.ISO_LOCAL_TIME) + "</p>\n"
                + "<p>Offset actual: " + zonaActual.getRules().getOffset(Instant.now()) + "</p>\n"
                + "<p>Offset después del cambio: " + offsetVerano + "</p>\n";
        }

        texto += "</html>";
        mensajeArea.setText(texto);
    }


    public static void main(String[] args) {
        new CambioDeHora().setVisible(true);
    }
}
