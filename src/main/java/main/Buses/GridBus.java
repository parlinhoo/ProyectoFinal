package main.Buses;

import main.Enums.Asiento;
import main.Enums.Espacio;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.jar.JarEntry;

public class GridBus extends JPanel {
    private final static int spacewidth = 50;
    private final static int spaceheight = 50;
    public GridBus(Bus bus, int floor) {
        Espacio[][] structure;
        switch (floor) {
            case 1 -> structure = bus.get_1F_structure();
            case 2 -> structure = bus.get_2F_structure();
            default -> {return;}
        }
        int buswidth = structure.length;
        int buslength = structure[0].length;
        this.setSize(buswidth*spacewidth, buslength*spaceheight);
        this.setLayout(new GridLayout(buslength, buswidth));
        for (int i = buslength-1; i >= 0; i--) {
            for (int j = 0; j < buswidth; j++) {
                JLabel frame = new JLabel();
                try {
                    BufferedImage pic = ImageIO.read(new File(Espacio.SEMICAMA.getImgpath()));
                    frame.setIcon(new ImageIcon(pic));
                } catch (Exception e) {
                    System.out.printf("AAAAAAAAAAAAAAAAAAAAAAAAA: %s\n", e.getMessage());
                }
                this.add(frame);
            }
        }
    }
}
