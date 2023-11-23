package main;

import main.GUIs.*;
import javax.swing.*;

public class Ventana extends JFrame {
    private JPanel PanelPrincipal;
    public Ventana() {
        super("Sistema de reserva de asientos de autobús");
        this.PanelPrincipal = new PanelPrincipal();
        this.add(PanelPrincipal);

    }
}
