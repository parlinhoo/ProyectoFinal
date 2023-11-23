package main.Buses;

import main.Enums.Espacio;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
                JLabel pic;
                try {
                    BufferedImage myPicture = ImageIO.read(new File("src/main/resources/semicamalibre.png"));
                    pic = new JLabel(new ImageIcon(myPicture));
                } catch (IOException e) {
                    pic = new JLabel("error");
                    e.printStackTrace();
                }
                this.add(pic);
            }
        }
    }
}
