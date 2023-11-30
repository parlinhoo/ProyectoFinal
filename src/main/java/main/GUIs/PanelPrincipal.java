package main.GUIs;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private CardLayout cardLayout;
    private JPanel panelInicio;
    private JPanel panelBuses;
    private JPanel panelAsientos;
    public PanelPrincipal() {
        this.cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.panelInicio = new Panel1(this, cardLayout);
        this.panelBuses = new Panel2(this, cardLayout);
        this.panelAsientos = new Panel3();
        this.add(panelInicio, "panelInicio");
        this.add(panelBuses, "panelBuses");
        this.add(panelAsientos, "panelAsientos");
    }
}
