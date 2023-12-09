package main.GUIs;

import main.Buses.GridBus;

import javax.swing.*;
import java.awt.*;

public class Panel3 extends JPanel {
    public final JPanel gridPanel;
    public final JPanel infoPanel;

    public Panel3() {
        this.setLayout(new GridLayout(1, 2));
        this.gridPanel = new JPanel() {
            {
                setLayout(null);
                setBackground(Color.WHITE);
            }
        };
        this.infoPanel = new JPanel() {
            {
                setBackground(Color.WHITE);
            }
        };
        this.add(this.gridPanel);
        this.add(this.infoPanel);
    }
}
