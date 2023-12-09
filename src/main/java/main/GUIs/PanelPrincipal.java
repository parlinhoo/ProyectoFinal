package main.GUIs;

import main.Buses.Bus;
import main.Buses.BusDirector;
import main.Buses.GridBus;
import main.Ventana;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class PanelPrincipal extends JPanel {
    private CardLayout cardLayout;
    private JPanel panelInicio;
    private Panel2 panelBuses;
    private Panel3 panelAsientos;
    private Bus[] flota;
    private Viaje[] viajes;

    public void updateBuses(String origen, String destino, LocalDate fecha) {
        ArrayList<Viaje> localviajes = new ArrayList<>();
        for (Viaje viaje : viajes) {
            if (viaje.getOrigen().equals(origen) && viaje.getDestino().equals(destino) && viaje.getFechaInicio().toLocalDate().isEqual(fecha)) localviajes.add(viaje);
        }
        PanelBus[] paneles = new PanelBus[localviajes.size()];
        for (int i = 0; i < localviajes.size(); i++) {
            Viaje viaje = localviajes.get(i);
            paneles[i] = viaje.getPanel();
        }
        panelBuses.updateBuses(paneles);
    }
    private void inicializarFlota() {
        BusDirector director = new BusDirector();
        this.flota = new Bus[3];
        for (int i = 0; i < flota.length; i++) {
            flota[i] = director.semicama_comun1F();
        }
    }
    private void crearViajes() {
        LocalDateTime tiempobus1 = LocalDateTime.of(2023, 12, 9, 6, 0);
        LocalDateTime tiempobus2 = LocalDateTime.of(2023, 12, 9, 9, 0);
        LocalDateTime tiempobus3 = LocalDateTime.of(2023, 12, 9, 12, 0);
        Viaje viaje1 = new Viaje(this.flota[0], "Concepción", "Santiago", tiempobus1);
        Viaje viaje2 = new Viaje(this.flota[0], "Santiago", "Concepción", tiempobus1.plusHours(6));
        Viaje viaje3 = new Viaje(this.flota[0], "Concepción", "Santiago", tiempobus1.plusHours(12));
        Viaje viaje4 = new Viaje(this.flota[1], "Concepción", "Santiago", tiempobus2);
        Viaje viaje5 = new Viaje(this.flota[1], "Santiago", "Concepción", tiempobus2.plusHours(6));
        Viaje viaje6 = new Viaje(this.flota[1], "Concepción", "Santiago", tiempobus2.plusHours(12));
        Viaje viaje7 = new Viaje(this.flota[2], "Concepción", "Santiago", tiempobus3);
        Viaje viaje8 = new Viaje(this.flota[2], "Santiago", "Concepción", tiempobus3.plusHours(6));
        Viaje viaje9 = new Viaje(this.flota[2], "Concepción", "Santiago", tiempobus3.plusHours(12));
        this.viajes = new Viaje[] {viaje1, viaje2, viaje3, viaje4, viaje5, viaje6, viaje7, viaje8, viaje9};
    }
    public PanelPrincipal() {
        this.inicializarFlota();
        this.crearViajes();
        this.cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.panelInicio = new Panel1(this, cardLayout);
        this.panelBuses = new Panel2(this, cardLayout);
        this.add(panelInicio, "panelInicio");
        this.add(panelBuses, "panelBuses");
    }
}
