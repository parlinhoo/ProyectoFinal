package main;

import main.GUIs.*;
import javax.swing.*;

public class Ventana extends JFrame {

    public static int altura = 800;
    public static int anchura = 1000;
    private JPanel PanelPrincipal;

    public Ventana() {
        super("Sistema de reserva de asientos de autobús");
        this.PanelPrincipal = new PanelPrincipal();
        this.add(PanelPrincipal);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Ventana.anchura, Ventana.altura);
        this.setVisible(true);
    }
}
