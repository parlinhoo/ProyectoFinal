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
            Viaje viaje = localviajes.remove(0);
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
    public void showGrid(Viaje viaje, int floor) {
        GridBus grid = viaje.getGrid(floor);
        this.panelAsientos.gridPanel.removeAll();
        this.panelAsientos.gridPanel.add(grid, BorderLayout.CENTER);
        this.cardLayout.show(this, "panelAsientos");
        grid.setLocation((int) (Ventana.anchura*0.25) - (int) (grid.getWidth()*0.5), (int) (Ventana.altura*0.5) - (int) (grid.getHeight()*0.5));

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
        cardLayout.show(this, "panelAsientos");
        showGrid(this.viajes[0], 1);
    }
}
