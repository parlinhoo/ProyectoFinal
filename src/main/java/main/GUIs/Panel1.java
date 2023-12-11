package main.GUIs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Primer panel de la interfaz, permite al usuario elegir desde y a donde se hará el viaje, asi como también la fecha del mismo
 */
public class Panel1 extends JPanel {
    static Color emebus = new Color(0x0071AE);
    /**
     * Constructor del panel, define la posición de los botones y los labels
     * @param panelPrincipal Panel contenedor asociado
     * @param cardLayout Cardlayout asociado
     */
    public Panel1(PanelPrincipal panelPrincipal, CardLayout cardLayout) {
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
        from.setForeground(emebus);
        this.add(from);
        JComboBox<String> comboBoxOrigen = new JComboBox<>(ciudades);
        comboBoxOrigen.setBackground(Color.WHITE);
        comboBoxOrigen.setBounds(100, y, comboBoxWidth, comboBoxHeight);
        this.add(comboBoxOrigen);


        JLabel to = new JLabel("Hasta:");
        to.setBounds(from.getX() + comboBoxWidth + gapX, y - comboBoxHeight  - gapY, labelWidth, labelHeight);
        to.setFont(new Font(fontName, Font.PLAIN, fontSize));
        to.setForeground(emebus);
        this.add(to);
        JComboBox<String> comboBoxDestino = new JComboBox<>(ciudades);
        comboBoxDestino.setBounds(comboBoxOrigen.getX() + comboBoxWidth + gapX, y, comboBoxWidth, comboBoxHeight);
        comboBoxDestino.setBackground(Color.WHITE);
        this.add(comboBoxDestino);

        JLabel day = new JLabel("Día:");
        day.setBounds(to.getX() + comboBoxWidth + gapX, y - comboBoxHeight  - gapY, labelWidth, labelHeight);
        day.setFont(new Font(fontName, Font.PLAIN, fontSize));
        day.setForeground(emebus);
        this.add(day);

        Date hoy = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date min = calendar.getTime();
        calendar.set(2024, Calendar.DECEMBER, 31);
        Date max = calendar.getTime();

        SpinnerDateModel dateModel = new SpinnerDateModel(hoy, min, max, Calendar.DAY_OF_MONTH);
        JSpinner datePicker = new JSpinner(dateModel);

        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(datePicker, "dd/MM/yyyy");
        datePicker.setEditor(dateEditor);
        datePicker.setBounds(comboBoxDestino.getX() + comboBoxWidth + gapX, y, comboBoxWidth, comboBoxHeight);
        this.add(datePicker);

        JButton BuscarBusesButton = new JButton("Buscar buses");
        BuscarBusesButton.setBounds(400, 450, 150, 50);
        BuscarBusesButton.setFont(new Font(fontName, Font.PLAIN, fontSize));
        BuscarBusesButton.setForeground(Color.WHITE);
        BuscarBusesButton.setBackground(emebus);
        BuscarBusesButton.addActionListener((e) -> {
            String origen = (String) comboBoxOrigen.getSelectedItem();
            String destino = (String) comboBoxDestino.getSelectedItem();
            Date hora = (Date) datePicker.getValue();
            LocalDate horaLocal = LocalDate.of(hora.getYear()+1900, hora.getMonth()+1, hora.getDate());
            panelPrincipal.updateBuses(origen, destino, horaLocal);
            cardLayout.show(panelPrincipal, "panelBuses");
        });
        this.add(BuscarBusesButton);
        try {
            BufferedImage myPicture = ImageIO.read(new File("src/main/resources/emebus.png"));
            JLabel fotito = new JLabel(new ImageIcon(myPicture));
            fotito.setBounds(10, -30, 300, 300);
            this.add(fotito);
        } catch (Exception e) {
            System.out.println("a");
        }
    }
}
