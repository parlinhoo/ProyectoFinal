package main.GUIs;

import main.Buses.Asiento;
import main.Buses.Bus;
import main.Enums.EstadoAsiento;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Panel que resume la información de un viaje, con el tipo de bus y los asientos disponibles
 */
public class PanelBus extends JPanel {
    /** Label asociado al número de asientos disponibles */
    private JLabel disponiblesLabel;
    /** Viaje asociado, seleccionado previamente */
    private Viaje viaje;
    /** Capacidad total del bus asociado */
    private int capacidad;

    /** Permite actualizar la cantidad de los asientos y las características del label asociado */
    public void updateSeats() {
        int asientosDisponibles = 0;
        int asientos2doPiso = 0;
        for (Asiento[] row : viaje.getAsientosF1()) {
            for (Asiento espacio : row) {
                if (espacio.tipo().IsASeat() && espacio.estado() != EstadoAsiento.RESERVADO) asientosDisponibles++;
            }
        }
        if (viaje.getAsientosF2() != null) {
            for (Asiento[] row : viaje.getAsientosF2()) {
                for (Asiento espacio : row) {
                    if (espacio.tipo().IsASeat() && espacio.estado() != EstadoAsiento.RESERVADO) {
                        asientosDisponibles++;
                        asientos2doPiso++;
                    }
                }
            }
        }
        Color colorLabel = new Color(0x079439);
        if (asientosDisponibles>10 && asientosDisponibles<=(capacidad/2)){
            colorLabel = new Color(0xD9BB02);
        } else if (asientosDisponibles<=10) {
            colorLabel = new Color(0x9B0606);
        }
        disponiblesLabel.setForeground(colorLabel);
        disponiblesLabel.setText((viaje.getAsientosF2() != null) ? String.format("%d (1F: %d | 2F: %d)", asientosDisponibles, asientosDisponibles-asientos2doPiso, asientos2doPiso) : String.valueOf(asientosDisponibles));
    }

    /**
     * Getter del viaje asociado
     * @return viaje asociado al panel
     */
    public Viaje getViaje() {return viaje;}

    /**
     * Constructor del panel, define las características de los labels y el icono del bus asociado
     * @param viaje Viaje del cual se muestran los asientos
     */
    public PanelBus(Viaje viaje) {
        this.viaje = viaje;
        Bus bus = viaje.getBus();
        int tipo = (bus.get_2F_structure() != null) ? 2 : 1;
        int capacidad = 0;
        int asientosDisponibles = 0;
        int asientos2doPiso = 0;

        for (Asiento[] row : viaje.getAsientosF1()) {
            for (Asiento espacio : row) {
                if (espacio.tipo().IsASeat()) {
                    capacidad++;
                    if (espacio.estado() != EstadoAsiento.RESERVADO) asientosDisponibles++;
                }
            }
        }

        if (viaje.getAsientosF2() != null) {
            for (Asiento[] row : viaje.getAsientosF2()) {
                for (Asiento espacio : row) {
                    if (espacio.tipo().IsASeat()) {
                        capacidad++;
                        if (espacio.estado() != EstadoAsiento.RESERVADO) {
                            asientosDisponibles++;
                            asientos2doPiso++;
                        }
                    }
                }
            }
        }

        this.capacidad = capacidad;
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(800,110));
        int x = 50;
        int y = 20;
        Color colorPrecio = new Color(0x079439);
        Color colorDisponible = new Color(0x079439);

        try {
            BufferedImage myPicture = ImageIO.read(new File(String.format("src/main/resources/bus%d.png", tipo)));
            JLabel fotito = new JLabel(new ImageIcon(myPicture));
            fotito.setBounds(x, this.getY()/2, 100, 100);
            this.add(fotito);
        } catch (Exception e){
            System.out.println("?");
        }

        String busname = null;
        int precioPasaje = 15000;
        int xDisponibles = 0;

        switch (tipo){
            case(1):
                busname = "Bus Tradicional";
                xDisponibles = 63;
                precioPasaje = 12999;
                break;
            case(2):
                busname = "Bus de 2 pisos";
                xDisponibles = 10;
                precioPasaje = 15999;
                break;
        }

        JLabel busInfo = new JLabel(String.format("%s (Capacidad para %d personas)", busname, capacidad));
        busInfo.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
        busInfo.setBounds(x + 100, y, 360, 40);
        this.add(busInfo);

        JLabel pasajes = new JLabel("Pasajes desde");
        pasajes.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        pasajes.setBounds(busInfo.getX() + 360, y, 200, 40);
        this.add(pasajes);

        JLabel precio = new JLabel(String.format("$%d", precioPasaje));
        precio.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        precio.setForeground(colorPrecio);
        precio.setBounds(pasajes.getX() + 25, y + 25, 100, 40);
        this.add(precio);

        JLabel asientos = new JLabel("Asientos Disponibles");
        asientos.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        asientos.setBounds(precio.getX() + 125, y, 200, 40);
        this.add(asientos);

        JLabel disponibles = new JLabel((tipo == 2) ? String.format("%d (1F: %d | 2F: %d)", asientosDisponibles, asientosDisponibles-asientos2doPiso, asientos2doPiso) : String.valueOf(asientosDisponibles));
        this.disponiblesLabel = disponibles;
        disponibles.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        disponibles.setForeground(colorDisponible);
        disponibles.setBounds(asientos.getX() + xDisponibles, y + 25, 200, 40);
        this.add(disponibles);

        JLabel hora = new JLabel("Parte a las " + String.valueOf(viaje.getFechaInicio().getHour()) + "hrs");
        hora.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
        hora.setBounds(busInfo.getX(), y + 25, 200, 40);
        this.add(hora);
    }

}