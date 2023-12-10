package main.Buses;

import main.Enums.EstadoAsiento;
import main.GUIs.Panel3;
import main.GUIs.Viaje;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class GridBus extends JPanel {
    private final static int spacewidth = 40;
    private final static int spaceheight = 40;
    private final Viaje viaje;
    private final int piso;
    private JButton[][] grid;
    private String[] selectedSeats;
    private Panel3 linkedPanel;
    public int floor = 0;

    public String[] getSelectedSeats() {
        return this.selectedSeats;
    }
    public void linkPanel(Panel3 panel) {
        this.linkedPanel = panel;
    }

    private static String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

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
        ArrayList<String> sel = new ArrayList<>();
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
                if (asientos[i][j].estado() == EstadoAsiento.SELECCIONADO) {
                    String letter = letters[i];
                    String number = String.valueOf(this.grid[0].length - j);
                    String seat = letter+number;
                    sel.add(seat);
                }
                this.selectedSeats = sel.toArray(new String[]{});
            }
        }
        String seats = "";
        for (int i = 0; i < this.selectedSeats.length; i++) {
            if (i < this.selectedSeats.length-2) {
                seats += String.format("%s, ", this.selectedSeats[i]);
            } else if (i == this.selectedSeats.length-2) {
                seats += String.format("%s y ", this.selectedSeats[i]);
            } else {
                seats += this.selectedSeats[i];
            }
        }
        //xd tuve que hardcodearlo
        if (this.linkedPanel != null) {
            switch (this.floor) {
                case 0 -> {
                    this.linkedPanel.asientosSeleccionadosp1.setText(seats);
                }
                case 1 -> {
                    this.linkedPanel.asientosSeleccionadosp1.setText("Piso 1: "+seats);
                }
                case 2 -> {
                    this.linkedPanel.asientosSeleccionadosp2.setText("Piso 2: "+seats);
                }
            }
        }
    }
    public GridBus(Viaje viaje, int floor) {
        this.selectedSeats = new String[]{};
        this.piso = floor;
        this.viaje = viaje;
        viaje.setGrid(this, floor);
        Asiento[][] asientos = (floor == 2) ? viaje.getAsientosF2() : viaje.getAsientosF1();
        int buswidth = asientos.length + 1;
        int buslength = asientos[0].length + 1;
        this.grid = new JButton[buswidth-1][buslength-1];
        this.setSize((buswidth+1)*spacewidth, (buslength+1)*spaceheight);
        this.setLayout(new GridLayout(buslength, buswidth));

        Color bgcolor = new Color(0x9B9B9B);
        this.setBackground(bgcolor);
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK));
        for (int j = buslength-2; j >= -1; j--) {
            for (int i = 0; i < buswidth; i++) {
                if (j == -1 && i != buswidth-1) {
                    JLabel letter = new JLabel(letters[i]);
                    letter.setHorizontalAlignment(SwingConstants.CENTER);
                    letter.setVerticalAlignment(SwingConstants.CENTER);
                    this.add(letter);
                } else if (i == buswidth-1 && j != -1) {
                    JLabel number = new JLabel(String.valueOf(buslength-1 - j));
                    number.setHorizontalAlignment(SwingConstants.CENTER);
                    number.setVerticalAlignment(SwingConstants.CENTER);
                    this.add(number);
                } else if (j != -1) {
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
                        int finalI = i;
                        int finalJ = j;
                        frame.addActionListener((l) -> {
                            Asiento[][] asientoslocal = (floor == 2) ? viaje.getAsientosF2() : viaje.getAsientosF1();
                            if (asientoslocal[finalI][finalJ].estado() == EstadoAsiento.LIBRE)
                                viaje.cambiarEstadoAsiento(floor, finalI, finalJ, EstadoAsiento.SELECCIONADO);
                            else if (asientoslocal[finalI][finalJ].estado() == EstadoAsiento.SELECCIONADO)
                                viaje.cambiarEstadoAsiento(floor, finalI, finalJ, EstadoAsiento.LIBRE);
                        });
                    }
                    this.add(frame);
                }
            }
        }
    }
}
