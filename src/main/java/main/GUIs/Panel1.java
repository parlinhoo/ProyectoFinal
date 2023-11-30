package main.GUIs;

import main.ScaleLib.Dim2;
import main.ScaleLib.ScaleFrame;

import javax.swing.*;
import java.awt.*;

public class Panel1 extends ScaleFrame {

    public Panel1() {
        this.setBackground(Color.GRAY);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 300));

        String[] ciudades = {"Santiago", "Valparaíso", "Concepción"};

        JComboBox<String> comboBoxOrigen = new JComboBox<>(ciudades);
        this.add(new JLabel("Desde:"));
        this.add(comboBoxOrigen);

        JComboBox<String> comboBoxDestino = new JComboBox<>(ciudades);
        this.add(new JLabel("Hasta:"));
        this.add(comboBoxDestino);

        String[] dias = new String[31];
        for (int i = 0; i < 31; i++) {
            dias[i] = String.valueOf(i + 1);
        }

        JComboBox<String> comboBoxDia = new JComboBox<>(dias);
        this.add(new JLabel("Día:"));
        this.add(comboBoxDia);

        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        JComboBox<String> comboBoxMes = new JComboBox<>(meses);
        this.add(new JLabel("Mes:"));
        this.add(comboBoxMes);

        JButton BuscarBusesButton = new JButton("Buscar buses");
        BuscarBusesButton.setPreferredSize(new Dimension(200,80));
        this.add(BuscarBusesButton);
    }
}
