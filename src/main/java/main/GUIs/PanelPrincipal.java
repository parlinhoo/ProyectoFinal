package main.GUIs;

import main.ScaleLib.Dim2;
import main.ScaleLib.ScaleFrame;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends ScaleFrame {
    private CardLayout cardLayout;
    private ScaleFrame panelInicio;
    private ScaleFrame panelBuses;
    private ScaleFrame panelAsientos;
    public PanelPrincipal() {
        this.setSize(Dim2.getSizeFromScale(1, 1));
        this.cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.panelInicio = new Panel1();
        this.panelBuses = new Panel2();
        this.panelAsientos = new Panel3();
        this.add(panelInicio);
        this.add(panelBuses);
    }
}
