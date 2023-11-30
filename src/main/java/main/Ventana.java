package main;

import main.GUIs.*;
import main.ScaleLib.ScaleFrame;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public static int altura = 800;
    public static int anchura = 1000;
    private ScaleFrame PanelPrincipal;

    public Ventana() {
        super("Sistema de reserva de asientos de autobús");
        this.PanelPrincipal = new PanelPrincipal();
        this.add(PanelPrincipal);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Ventana.anchura, Ventana.altura);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public Component add(ScaleFrame comp) {
        Component local = super.add(comp);
        comp.refresh();
        return local;
    }
}
