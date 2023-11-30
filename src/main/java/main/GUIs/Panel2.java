package main.GUIs;

import main.ScaleLib.ScaleFrame;

import javax.swing.*;
import java.awt.*;

public class Panel2 extends ScaleFrame {

    public Panel2() {
        this.setBackground(Color.darkGray);
        this.setLayout(new FlowLayout());
        JButton volverButton = new JButton("Volver");
        volverButton.setPreferredSize(new Dimension(200,80));
        this.add(volverButton, BorderLayout.CENTER);
    }
}
