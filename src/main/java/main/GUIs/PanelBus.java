package main.GUIs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PanelBus extends JPanel {

    public PanelBus(int tipo) {
        this.setLayout(null);
        this.setBackground(new Color(0xD9D9D9));
        this.setPreferredSize(new Dimension(800,110));
        int x = 50;
        int y = 20;
        Color colorPrecio = new Color(0x079439);
        Color colorDisponible = new Color(0x9B0606);

        int tipoBus = tipo;

        try{
            BufferedImage myPicture = ImageIO.read(new File(String.format("src/main/resources/bus%d.png", tipoBus)));
            JLabel fotito = new JLabel(new ImageIcon(myPicture));
            fotito.setBounds(x, 10, 100, 100);
            this.add(fotito);
        } catch (Exception e){
            System.out.println("?");
        }

        String bus = null;
        int capacidad = 0;
        int precioPasaje = 15000;
        int asientosDisponibles = 10;

        switch (tipoBus){
            case(1):
                bus = "Bus Tradicional";
                capacidad = 50;
                break;
            case(2):
                bus = "Bus de 2 pisos";
                capacidad = 70;
                break;
        }

        JLabel busInfo = new JLabel(String.format("%s (Capacidad para %d personas)", bus, capacidad));
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

        JLabel disponibles = new JLabel(String.valueOf(asientosDisponibles));
        disponibles.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        disponibles.setForeground(colorDisponible);
        disponibles.setBounds(asientos.getX() + 63, y + 25, 100, 40);
        this.add(disponibles);
    }

}

class test {
    public static void main(String[] args) {
        JFrame v = new JFrame();
        v.add(new PanelBus(1));
        v.setDefaultCloseOperation(3);
        v.setSize(1000, 800);
        v.setVisible(true);
    }
}