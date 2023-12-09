package main.GUIs;

import main.Buses.Asiento;
import main.Buses.Bus;
import main.Enums.EstadoAsiento;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PanelBus extends JPanel {
    private JLabel busInfoLabel;
    private JLabel pasajesLabel;
    private JLabel precioLabel;
    private JLabel asientosLabel;
    private JLabel disponiblesLabel;
    private Viaje viaje;

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
        disponiblesLabel.setText((viaje.getAsientosF2() != null) ? String.format("%d (1F: %d | 2F: %d)", asientosDisponibles, asientosDisponibles-asientos2doPiso, asientos2doPiso) : String.valueOf(asientosDisponibles));
    }

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

        this.setLayout(null);
        this.setBackground(new Color(0xD9D9D9));
        this.setPreferredSize(new Dimension(800,110));
        int x = 50;
        int y = 20;
        Color colorPrecio = new Color(0x079439);
        Color colorDisponible = new Color(0x9B0606);

        try {
            BufferedImage myPicture = ImageIO.read(new File(String.format("src/main/resources/bus%d.png", tipo)));
            JLabel fotito = new JLabel(new ImageIcon(myPicture));
            fotito.setBounds(x, 10, 100, 100);
            this.add(fotito);
        } catch (Exception e){
            System.out.println("?");
        }

        String busname = null;
        int precioPasaje = 15000;

        switch (tipo){
            case(1):
                busname = "Bus Tradicional";
                break;
            case(2):
                busname = "Bus de 2 pisos";
                break;
        }

        JLabel busInfo = new JLabel(String.format("%s (Capacidad para %d personas)", busname, capacidad));
        this.busInfoLabel = busInfo;
        busInfo.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
        busInfo.setBounds(x + 100, y, 360, 40);
        this.add(busInfo);

        JLabel pasajes = new JLabel("Pasajes desde");
        this.pasajesLabel = pasajes;
        pasajes.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        pasajes.setBounds(busInfo.getX() + 360, y, 200, 40);
        this.add(pasajes);

        JLabel precio = new JLabel(String.format("$%d", precioPasaje));
        this.precioLabel = precio;
        precio.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        precio.setForeground(colorPrecio);
        precio.setBounds(pasajes.getX() + 25, y + 25, 100, 40);
        this.add(precio);

        JLabel asientos = new JLabel("Asientos Disponibles");
        this.asientosLabel = asientos;
        asientos.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        asientos.setBounds(precio.getX() + 125, y, 200, 40);
        this.add(asientos);

        JLabel disponibles = new JLabel((tipo == 2) ? String.format("%d (1F: %d | 2F: %d)", asientosDisponibles, asientosDisponibles-asientos2doPiso, asientos2doPiso) : String.valueOf(asientosDisponibles));
        this.disponiblesLabel = disponibles;
        disponibles.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        disponibles.setForeground(colorDisponible);
        disponibles.setBounds(asientos.getX() + 63, y + 25, 100, 40);
        this.add(disponibles);
    }

}