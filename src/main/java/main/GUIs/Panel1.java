package main.GUIs;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class Panel1 extends JPanel {

    public Panel1(JPanel panel, CardLayout cardLayout) {
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        int y = 350;
        int fontSize = 20;
        String fontName = "IMPACT";
        int labelWidth = 70;
        int labelHeight = 40;
        int comboBoxWidth = 200;
        int comboBoxHeight = 30;
        int gapX = 60;
        int gapY = 10;

        String[] ciudades = {"", "Santiago", "Valparaíso", "Concepción"};
        JLabel from = new JLabel("Desde:");
        from.setBounds(100, y - comboBoxHeight  - gapY, labelWidth, labelHeight);
        from.setFont(new Font(fontName, Font.PLAIN, fontSize));
        this.add(from);
        JComboBox<String> comboBoxOrigen = new JComboBox<>(ciudades);
        comboBoxOrigen.setBackground(Color.WHITE);
        comboBoxOrigen.setBounds(100, y, comboBoxWidth, comboBoxHeight);
        this.add(comboBoxOrigen);

        JLabel to = new JLabel("Hasta:");
        to.setBounds(from.getX() + comboBoxWidth + gapX, y - comboBoxHeight  - gapY, labelWidth, labelHeight);
        to.setFont(new Font(fontName, Font.PLAIN, fontSize));
        this.add(to);
        JComboBox<String> comboBoxDestino = new JComboBox<>(ciudades);
        comboBoxDestino.setBounds(comboBoxOrigen.getX() + comboBoxWidth + gapX, y, comboBoxWidth, comboBoxHeight);
        comboBoxDestino.setBackground(Color.WHITE);
        this.add(comboBoxDestino);

        JLabel day = new JLabel("Día:");
        day.setBounds(to.getX() + comboBoxWidth + gapX, y - comboBoxHeight  - gapY, labelWidth, labelHeight);
        day.setFont(new Font(fontName, Font.PLAIN, fontSize));
        this.add(day);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.NOVEMBER, 29);
        Date min = calendar.getTime();
        calendar.set(2024, Calendar.DECEMBER, 30);
        Date max = calendar.getTime();
        Date hoy = new Date();
        SpinnerDateModel dateModel = new SpinnerDateModel(hoy, min, max, Calendar.DAY_OF_MONTH);
        JSpinner dateSpinner = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setBounds(comboBoxDestino.getX() + comboBoxWidth + gapX, y, comboBoxWidth, comboBoxHeight);
        this.add(dateSpinner);

        JButton BuscarBusesButton = new JButton("Buscar buses");
        BuscarBusesButton.setBounds(400, 450, 150, 50);
        BuscarBusesButton.setFont(new Font(fontName, Font.PLAIN, fontSize));
        BuscarBusesButton.setForeground(Color.WHITE);
        BuscarBusesButton.setBackground(Color.BLACK);
        BuscarBusesButton.addActionListener(e -> cardLayout.show(panel, "panelBuses"));
        this.add(BuscarBusesButton);
    }
}
