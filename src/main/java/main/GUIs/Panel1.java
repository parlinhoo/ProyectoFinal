package main.GUIs;

import javax.swing.*;
import java.awt.*;

public class Panel1 extends JPanel {

    public Panel1(JPanel panel, CardLayout cardLayout) {
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        int y = 350;
        int fontSize = 20;
        String fontName = "IMPACT";
        int labelWidth = 70;
        int labelHeight = 40;
        int comboBoxWidth = 120;
        int comboBoxHeight = 30;
        int gapX = 60;
        int gapY = 10;

        String[] ciudades = {"", "Santiago", "Valparaíso", "Concepción"};
        JLabel from = new JLabel("Desde:");
        from.setBounds(150, y - comboBoxHeight  - gapY, labelWidth, labelHeight);
        from.setFont(new Font(fontName, Font.PLAIN, fontSize));
        this.add(from);
        JComboBox<String> comboBoxOrigen = new JComboBox<>(ciudades);
        comboBoxOrigen.setBounds(150, y, comboBoxWidth, comboBoxHeight);
        this.add(comboBoxOrigen);

        JLabel to = new JLabel("Hasta:");
        to.setBounds(from.getX() + comboBoxWidth + gapX, y - comboBoxHeight  - gapY, labelWidth, labelHeight);
        to.setFont(new Font(fontName, Font.PLAIN, fontSize));
        this.add(to);
        JComboBox<String> comboBoxDestino = new JComboBox<>(ciudades);
        comboBoxDestino.setBounds(comboBoxOrigen.getX() + comboBoxWidth + gapX, y, comboBoxWidth, comboBoxHeight);
        this.add(comboBoxDestino);

        String[] dias = new String[32];
        dias[0] = "";
        for (int i = 1; i < 32; i++) {
            dias[i] = String.valueOf(i);
        }

        JLabel day = new JLabel("Día:");
        day.setBounds(to.getX() + comboBoxWidth + gapX, y - comboBoxHeight  - gapY, labelWidth, labelHeight);
        day.setFont(new Font(fontName, Font.PLAIN, fontSize));
        this.add(day);
        JComboBox<String> comboBoxDia = new JComboBox<>(dias);
        comboBoxDia.setBounds(comboBoxDestino.getX() + comboBoxWidth + gapX, y, comboBoxWidth, comboBoxHeight);
        this.add(comboBoxDia);

        String[] meses = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        JLabel month = new JLabel("Mes:");
        month.setBounds(day.getX() + comboBoxWidth + gapX, y - comboBoxHeight  - gapY, labelWidth, labelHeight);
        month.setFont(new Font(fontName, Font.PLAIN, fontSize));
        this.add(month);
        JComboBox<String> comboBoxMes = new JComboBox<>(meses);
        comboBoxMes.setBounds(comboBoxDia.getX() + comboBoxWidth + gapX, y, comboBoxWidth, comboBoxHeight);
        this.add(comboBoxMes);

        JButton BuscarBusesButton = new JButton("Buscar buses");
        BuscarBusesButton.setBounds(400, 450, 150, 50);
        BuscarBusesButton.setFont(new Font(fontName, Font.PLAIN, fontSize));
        BuscarBusesButton.addActionListener(e -> cardLayout.show(panel, "panelBuses"));
        this.add(BuscarBusesButton);
    }
}
