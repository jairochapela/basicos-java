import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aviso extends JFrame implements ActionListener {
    
    private JLabel mensaje;
    private JButton botonAceptar;
    private JButton botonCancelar;

    public Aviso(String texto) {
        setTitle("Aviso");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.mensaje = new JLabel(texto, JLabel.CENTER);
        this.botonAceptar = new JButton("Aceptar");
        this.botonCancelar = new JButton("Cancelar");
        
        setLayout(new java.awt.BorderLayout());
        add(mensaje, java.awt.BorderLayout.CENTER);
        
        java.awt.Panel panelBotones = new java.awt.Panel();
        panelBotones.add(botonAceptar);
        panelBotones.add(botonCancelar);
        add(panelBotones, java.awt.BorderLayout.SOUTH);

        this.botonAceptar.addActionListener(this);
        this.botonCancelar.addActionListener(this);
    }


    public static void main(String[] args) {
        Aviso aviso = new Aviso("Este es un mensaje de aviso.");
        aviso.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonAceptar) {
            System.out.println("Has pulsado Aceptar.");
        } else if (e.getSource() == botonCancelar) {
            System.out.println("Has pulsado Cancelar.");
        }
        dispose();
    }
}
