package main.GUIs;

import main.Buses.Bus;
import main.Buses.BusDirector;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Panel contenedor de los demás paneles de la interfaz
 */
public class PanelPrincipal extends JPanel {

    /** Permite cambiar entre los distintos paneles de la interfaz */
    private CardLayout cardLayout;
    /** Primer panel a mostrar */
    private JPanel panelInicio;
    /** Segundo panel a mostrar */
    private Panel2 panelBuses;
    /** Tercer panel a mostrar */
    private Panel3 panelAsientos;
    /** Flota de buses disponibles en el programa */
    private Bus[] flota;
    /** Array de viajes disponibles en el programa */
    private Viaje[] viajes;

    /** Permite actualizar y relacionar los viajes elegidos por el usuario con los disponibles
     * @param origen Origen elegido por el usuario
     * @param destino Destino elegido por el usuario
     * @param fecha Fecha elegida por el usuario
     */
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

    /** Permite inicializar la flota de buses, creando los buses mediante BusDirector
     * @see BusDirector
     */
    private void inicializarFlota() {
        BusDirector director = new BusDirector();
        this.flota = new Bus[4];
        flota[0] = director.semicama_2F();
        flota[1] = director.semicama_comun1F();
        flota[2] = director.semicama_2F();
        flota[3] = director.mixto_comun_2F();
    }

    /** Permite inicializar los viajes
     * @see Viaje
     */
    private void crearViajes() {
        LocalDateTime tiempobus1 = LocalDateTime.of(2023, 12, 10, 6, 0);
        LocalDateTime tiempobus2 = LocalDateTime.of(2023, 12, 10, 9, 0);
        LocalDateTime tiempobus3 = LocalDateTime.of(2023, 12, 10, 12, 0);
        LocalDateTime tiempobus4 = LocalDateTime.of(2023, 12, 10, 16, 0);
        Viaje viaje1 = new Viaje(this.flota[0], "Concepción", "Santiago", tiempobus1);
        Viaje viaje2 = new Viaje(this.flota[0], "Santiago", "Concepción", tiempobus1.plusHours(6));
        Viaje viaje3 = new Viaje(this.flota[0], "Concepción", "Santiago", tiempobus1.plusHours(12));
        Viaje viaje4 = new Viaje(this.flota[1], "Concepción", "Santiago", tiempobus2);
        Viaje viaje5 = new Viaje(this.flota[1], "Santiago", "Concepción", tiempobus2.plusHours(6));
        Viaje viaje6 = new Viaje(this.flota[1], "Concepción", "Santiago", tiempobus2.plusHours(12));
        Viaje viaje7 = new Viaje(this.flota[2], "Concepción", "Santiago", tiempobus3);
        Viaje viaje8 = new Viaje(this.flota[2], "Santiago", "Concepción", tiempobus3.plusHours(6));
        Viaje viaje9 = new Viaje(this.flota[2], "Concepción", "Santiago", tiempobus3.plusHours(12));
        Viaje viaje10 = new Viaje(this.flota[3], "Concepción", "Santiago", tiempobus4);
        this.viajes = new Viaje[] {viaje1, viaje4, viaje7, viaje2, viaje3, viaje5, viaje6, viaje8, viaje9, viaje10};
    }

    /**
     * Constructor del panel por defecto, inicializa la flota y crea los viajes, al igual que organizar el cardlayout
     */
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
