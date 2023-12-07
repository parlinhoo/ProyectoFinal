package main.GUIs;

import main.Buses.Bus;
import main.Buses.BusDirector;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.Date;

public class PanelPrincipal extends JPanel {
    private CardLayout cardLayout;
    private JPanel panelInicio;
    private JPanel panelBuses;
    private JPanel panelAsientos;
    private Bus[] flota;
    private Viaje[] viajes;
    private void inicializarFlota() {
        BusDirector director = new BusDirector();
        this.flota = new Bus[3];
        for (int i = 0; i < flota.length; i++) {
            flota[i] = director.semicama_comun1F();
        }
    }
    private void crearViajes() {
        LocalDateTime tiempobus1 = LocalDateTime.of(2023, 12, 8, 6, 0);
        Viaje viaje1 = new Viaje(this.flota[0], "Concepción", "Santiago", tiempobus1);
        Viaje viaje2 = new Viaje(this.flota[0], "Santiago", "Concepción", tiempobus1.plusHours(6));

        this.viajes = new Viaje[] {viaje1, viaje2};
    }
    public PanelPrincipal() {
        this.inicializarFlota();
        this.crearViajes();
        this.cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.panelInicio = new Panel1(this, cardLayout);
        this.panelBuses = new Panel2(this, cardLayout);
        this.panelAsientos = new Panel3();
        this.add(panelInicio, "panelInicio");
        this.add(panelBuses, "panelBuses");
        this.add(panelAsientos, "panelAsientos");
    }
}
