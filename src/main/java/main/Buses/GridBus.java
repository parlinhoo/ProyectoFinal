package main.Buses;

import main.Enums.EstadoAsiento;
import main.GUIs.Viaje;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GridBus extends JPanel {
    private final static int spacewidth = 55;
    private final static int spaceheight = 55;
    private final Viaje viaje;
    private final int piso;
    private JButton[][] grid;

    public void PagarAsientosSeleccionados() {
        Asiento[][] asientos = (this.piso == 2) ? this.viaje.getAsientosF2() : this.viaje.getAsientosF1();
        for (int j = this.grid[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < this.grid.length; i++) {
                Asiento asiento = asientos[i][j];
                if (asiento.estado() == EstadoAsiento.SELECCIONADO) {
                    viaje.cambiarEstadoAsiento(piso, i, j, EstadoAsiento.RESERVADO);
                }
            }
        }
    }

    public void updateGrid() {
        Asiento[][] asientos = (this.piso == 2) ? this.viaje.getAsientosF2() : this.viaje.getAsientosF1();
        for (int j = this.grid[0].length-1; j >= 0; j--) {
            for (int i = 0; i < this.grid.length; i++) {
                JButton frame = this.grid[i][j];
                try {
                    BufferedImage pic = ImageIO.read(new File(asientos[i][j].getimg()));
                    frame.setIcon(new ImageIcon(pic));
                } catch (Exception e) {
                    System.out.printf("AAAAAAAAAAAAAAAAAAAAAAAAA: %s\n", e.getMessage());
                }
                frame.setContentAreaFilled(asientos[i][j].tipo().IsASeat() && asientos[i][j].estado() != EstadoAsiento.RESERVADO);
            }
        }
    }
    public GridBus(Viaje viaje, int floor) {
        this.piso = floor;
        this.viaje = viaje;
        viaje.setGrid(this, floor);
        Asiento[][] asientos = (floor == 2) ? viaje.getAsientosF2() : viaje.getAsientosF1();
        int buswidth = asientos.length;
        int buslength = asientos[0].length;
        this.grid = new JButton[buswidth][buslength];
        this.setSize(buswidth*spacewidth, buslength*spaceheight);
        this.setLayout(new GridLayout(buslength, buswidth));

        Color bgcolor = new Color(0x9B9B9B);
        this.setBackground(bgcolor);
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK));
        for (int j = buslength-1; j >= 0; j--) {
            for (int i = 0; i < buswidth; i++) {
                JButton frame = new JButton();
                this.grid[i][j] = frame;
                try {
                    BufferedImage pic = ImageIO.read(new File(asientos[i][j].getimg()));
                    frame.setIcon(new ImageIcon(pic));
                } catch (Exception e) {
                    System.out.printf("AAAAAAAAAAAAAAAAAAAAAAAAA: %s\n", e.getMessage());
                }
                frame.setBackground(bgcolor);
                frame.setBorderPainted(false);
                frame.setFocusPainted(false);
                frame.setContentAreaFilled(asientos[i][j].tipo().IsASeat() && asientos[i][j].estado() != EstadoAsiento.RESERVADO);
                if (asientos[i][j].tipo().IsASeat()) {
                    int finalI = i; int finalJ = j;
                    frame.addActionListener((l) -> {
                        Asiento[][] asientoslocal = (floor == 2) ? viaje.getAsientosF2() : viaje.getAsientosF1();
                        if (asientoslocal[finalI][finalJ].estado() == EstadoAsiento.LIBRE) viaje.cambiarEstadoAsiento(floor, finalI, finalJ, EstadoAsiento.SELECCIONADO);
                        else if (asientoslocal[finalI][finalJ].estado() == EstadoAsiento.SELECCIONADO) viaje.cambiarEstadoAsiento(floor, finalI, finalJ, EstadoAsiento.LIBRE);
                    });
                }
                this.add(frame);
            }
        }
    }
}
