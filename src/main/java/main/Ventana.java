package main;

import main.GUIs.*;
import main.ScaleLib.ScaleFrame;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public static int ancho = 1000;
    public static int alto = 800;
    private ScaleFrame PanelPrincipal;
    public Ventana() {
        super("Sistema de reserva de asientos de autobús");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.PanelPrincipal = new PanelPrincipal();
        this.add(PanelPrincipal);
        this.setSize(ancho, alto);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public Component add(ScaleFrame comp) {
        Component local = super.add(comp);
        comp.refresh();
        return local;
    }
}
