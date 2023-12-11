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
    /** Flota de buses disponibles en el programa */
    private Bus[][] flota;
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
        int AAAAAA = 15;
        this.flota = new Bus[4][AAAAAA];
        for (int i = 0; i < AAAAAA; i++) {
            flota[0][i] = director.semicama_comun1F();
            flota[1][i] = director.semicama_2F();
            flota[2][i] = director.mixto_premium_2F();
            flota[3][i] = director.saloncama_premium1F();
        }
    }
    //variables auxiliares para asignar buses mas rapido
    private int flota0 = 0;
    private int flota1 = 0;
    private int flota2 = 0;
    private int flota3 = 0;

    private Bus obtenerSigFlota(int bus){
        switch (bus) {
            case 0 -> {
                this.flota0++;
                return this.flota[0][flota0-1];
            }
            case 1 -> {
                this.flota1++;
                return this.flota[1][flota1-1];
            }
            case 2 -> {
                this.flota2++;
                return this.flota[2][flota2-1];
            }
            case 3 -> {
                this.flota3++;
                return this.flota[3][flota3-1];
            }
            default -> {
                this.flota0 = 0;
                this.flota1 = 0;
                this.flota2 = 0;
                this.flota3 = 0;
                return null;
            }
        }
    }

    /** Permite inicializar los viajes
     * @see Viaje
     */
    private void crearViajes() {
        LocalDateTime tiempoCCP_STGO1 = LocalDateTime.of(2023, 12, 10, 6, 0, 0);
        LocalDateTime tiempoCCP_STGO2 = LocalDateTime.of(2023, 12, 10, 9, 0, 0);
        LocalDateTime tiempoCCP_STGO3 = LocalDateTime.of(2023, 12, 10, 12, 0, 0);
        LocalDateTime tiempoCCP_STGO4 = LocalDateTime.of(2023, 12, 10, 15, 0, 0);
        LocalDateTime tiempoCCP_STGO5 = LocalDateTime.of(2023, 12, 10, 18, 0, 0);

        LocalDateTime tiempoCCP_VALPO1 = LocalDateTime.of(2023, 12, 10, 8, 0, 0);
        LocalDateTime tiempoCCP_VALPO2 = LocalDateTime.of(2023, 12, 10, 12, 0, 0);
        LocalDateTime tiempoCCP_VALPO3 = LocalDateTime.of(2023, 12, 10, 16, 0, 0);

        LocalDateTime tiempoSTGO_VALPO1 = LocalDateTime.of(2023, 12, 10, 6, 0, 0);
        LocalDateTime tiempoSTGO_VALPO2 = LocalDateTime.of(2023, 12, 10, 10, 0, 0);
        LocalDateTime tiempoSTGO_VALPO3 = LocalDateTime.of(2023, 12, 10, 12, 0, 0);
        LocalDateTime tiempoSTGO_VALPO4 = LocalDateTime.of(2023, 12, 10, 16, 0, 0);

        String CCP = "Concepción";
        String STGO = "Santiago";
        String VALPO = "Valparaíso";
        ArrayList<Viaje> viajestemp = new ArrayList<>();
        System.out.println("Cargando viajes....");
        int dias = 60;
        for (int i = 0; i <= dias; i++) {
            if (i == dias/2) System.out.println("50%");
            obtenerSigFlota(-1);
            // CONCEPCION A SANTIAGO
            viajestemp.add(new Viaje(obtenerSigFlota(3), CCP, STGO, tiempoCCP_STGO1.plusDays(i)));

            viajestemp.add(new Viaje(obtenerSigFlota(1), CCP, STGO, tiempoCCP_STGO3.plusDays(i)));

            viajestemp.add(new Viaje(obtenerSigFlota(0), CCP, STGO, tiempoCCP_STGO4.plusDays(i)));

            viajestemp.add(new Viaje(obtenerSigFlota(2), CCP, STGO, tiempoCCP_STGO5.plusDays(i)));
            // SANTIAGO A CONCEPCION
            viajestemp.add(new Viaje(obtenerSigFlota(3), STGO, CCP, tiempoCCP_STGO1.plusDays(i)));

            viajestemp.add(new Viaje(obtenerSigFlota(1), STGO, CCP, tiempoCCP_STGO3.plusDays(i)));

            viajestemp.add(new Viaje(obtenerSigFlota(0), STGO, CCP, tiempoCCP_STGO4.plusDays(i)));

            viajestemp.add(new Viaje(obtenerSigFlota(2), STGO, CCP, tiempoCCP_STGO5.plusDays(i)));
            // CONCEPCION A VALPARAISO
            viajestemp.add(new Viaje(obtenerSigFlota(0), CCP, VALPO, tiempoCCP_VALPO1.plusDays(i)));
            viajestemp.add(new Viaje(obtenerSigFlota(2), CCP, VALPO, tiempoCCP_VALPO1.plusDays(i)));

            viajestemp.add(new Viaje(obtenerSigFlota(0), CCP, VALPO, tiempoCCP_VALPO2.plusDays(i)));

            viajestemp.add(new Viaje(obtenerSigFlota(1), CCP, VALPO, tiempoCCP_VALPO3.plusDays(i)));
            // VALPARAISO A CONCEPCION
            viajestemp.add(new Viaje(obtenerSigFlota(0), VALPO, CCP, tiempoCCP_VALPO1.plusDays(i)));
            viajestemp.add(new Viaje(obtenerSigFlota(2), VALPO, CCP, tiempoCCP_VALPO1.plusDays(i)));

            viajestemp.add(new Viaje(obtenerSigFlota(0), VALPO, CCP, tiempoCCP_VALPO2.plusDays(i)));

            viajestemp.add(new Viaje(obtenerSigFlota(1), VALPO, CCP, tiempoCCP_VALPO3.plusDays(i)));
            // SANTIAGO A VALPARAISO
            viajestemp.add(new Viaje(obtenerSigFlota(3), STGO, VALPO, tiempoSTGO_VALPO1.plusDays(i)));

            viajestemp.add(new Viaje(obtenerSigFlota(1), STGO, VALPO, tiempoSTGO_VALPO3.plusDays(i)));

            viajestemp.add(new Viaje(obtenerSigFlota(2), STGO, VALPO, tiempoSTGO_VALPO4.plusDays(i)));
            // VALPARAISO A SANTIAGO
            viajestemp.add(new Viaje(obtenerSigFlota(3), VALPO, STGO, tiempoSTGO_VALPO1.plusDays(i)));

            viajestemp.add(new Viaje(obtenerSigFlota(1), VALPO, STGO, tiempoSTGO_VALPO3.plusDays(i)));

            viajestemp.add(new Viaje(obtenerSigFlota(1), VALPO, STGO, tiempoSTGO_VALPO4.plusDays(i)));
            viajestemp.add(new Viaje(obtenerSigFlota(2), VALPO, STGO, tiempoSTGO_VALPO4.plusDays(i)));
        }
        this.viajes = viajestemp.toArray(new Viaje[]{});
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
