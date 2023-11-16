package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame {
    public static int altura = 800;
    public static int anchura = 1000;

    private JPanel PanelPrincipal;
    private CardLayout cardLayout;

    public Ventana(){
        super("Sistema de reserva de asientos de autobús");

        PanelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        PanelPrincipal.setLayout(cardLayout);

        JPanel panelInicio = new JPanel();
        panelInicio.setBackground(Color.GRAY);
        panelInicio.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 300));

        String[] ciudades = {"Santiago", "Valparaíso", "Concepción", "Antofagasta", "Puerto Montt"};

        JComboBox<String> comboBoxOrigen = new JComboBox<>(ciudades);
        JLabel labelComiezo = new JLabel("Desde:");
        panelInicio.add(labelComiezo);
        JComboBox<String> comboBoxDestino = new JComboBox<>(ciudades);
        panelInicio.add(comboBoxOrigen);
        JLabel labelDestino = new JLabel("Hasta:");

        panelInicio.add(labelDestino);
        panelInicio.add(comboBoxDestino);

        String[] dias = new String[31];
        for (int i = 0; i < 31; i++) {
            dias[i] = String.valueOf(i + 1);
        }
        JComboBox<String> comboBoxDia = new JComboBox<>(dias);
        panelInicio.add(new JLabel("Día:"));
        panelInicio.add(comboBoxDia);

        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        JComboBox<String> comboBoxMes = new JComboBox<>(meses);
        panelInicio.add(new JLabel("Mes:"));
        panelInicio.add(comboBoxMes);

        JButton BuscarBusesButton = new JButton("Buscar buses");
        BuscarBusesButton.setPreferredSize(new Dimension(200,80));
        panelInicio.add(BuscarBusesButton);

        JPanel panelBuses = new JPanel();
        panelBuses.setBackground(Color.darkGray);
        panelBuses.setLayout(new FlowLayout());
        JButton volverButton = new JButton("Volver");
        volverButton.setPreferredSize(new Dimension(200,80));
        panelBuses.add(volverButton, BorderLayout.CENTER);

        PanelPrincipal.add(panelInicio, "panelInicio");
        PanelPrincipal.add(panelBuses, "panelBuses");

        add(PanelPrincipal);

        BuscarBusesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(PanelPrincipal, "panelBuses");
            }
        });

        volverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(PanelPrincipal, "panelInicio");
            }
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Ventana.anchura, Ventana.altura);
        this.setVisible(true);
    }
}
