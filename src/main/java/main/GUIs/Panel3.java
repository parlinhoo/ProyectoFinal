package main.GUIs;

import main.Buses.GridBus;
import main.Ventana;

import javax.swing.*;
import java.awt.*;

public class Panel3 extends JPanel {

    public Panel3(Viaje viaje, JPanel panel, CardLayout cardLayout) {
        this.setLayout(new BorderLayout());

        JPanel header = new JPanel(new GridBagLayout()) {
            {
                setPreferredSize(new Dimension(800, 75));
                setBackground(Color.WHITE);

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 1;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.insets = new Insets(0, 10, 0, 0);

                JButton volverButton = new JButton();
                volverButton.setPreferredSize(new Dimension(50, 30));
                volverButton.setIcon(new ImageIcon("src/main/resources/return.png"));
                volverButton.addActionListener(e -> cardLayout.show(panel, "panelBuses"));
                add(volverButton, gbc);

                gbc.anchor = GridBagConstraints.CENTER;

                JLabel headline = new JLabel("Elige los asientos");
                headline.setFont(new Font("IMPACT", Font.BOLD, 35));
                add(headline, gbc);
            }
        };
        this.add(header,BorderLayout.NORTH);

        int tipo = (viaje.getBus().get_2F_structure() != null) ? 2 : 1;

        JPanel menuCompra = new JPanel(){
            {
                int x = 550;
                int vgap = 30;
                int fontSize = 20;
                int labelWidth = 300;
                int labelHeight = 100;
                setBackground(Color.WHITE);
                setLayout(null);
                GridBus gridBus = new GridBus(viaje, tipo);
                gridBus.setLocation((int) (Ventana.anchura*0.25) - (int) (gridBus.getWidth()*0.5), (int) (Ventana.altura*0.5) - (int) (gridBus.getHeight()*0.6));

                JLabel resumen = new JLabel("Resumen del Pedido");
                resumen.setFont(new Font("IMPACT", Font.BOLD, 30));
                resumen.setBounds(x, 150, 300, 100);
                add(resumen);

                String busname = null;
                switch (tipo){
                    case(1):
                        busname = "Bus Tradicional";
                        break;
                    case(2):
                        busname = "Bus de 2 pisos";
                        break;
                }

                JLabel bus = new JLabel(String.format("<html><b>Tipo de bus:</b> %s<html>", busname));
                bus.setFont(new Font("Lucida Sans", Font.PLAIN, fontSize));
                bus.setBounds(x, resumen.getY() + vgap*2, labelWidth, labelHeight);
                add(bus);

                JLabel origen = new JLabel(String.format("<html><b>Desde:</b> %s", viaje.getOrigen()));
                origen.setFont(new Font("Lucida Sans", Font.PLAIN, fontSize));
                origen.setBounds(x, bus.getY() + vgap, labelWidth, labelHeight);
                add(origen);

                JLabel destino = new JLabel(String.format("<html><b>Hasta:</b> %s", viaje.getDestino()));
                destino.setFont(new Font("Lucida Sans", Font.PLAIN, fontSize));
                destino.setBounds(x, origen.getY() + vgap, labelWidth, labelHeight);
                add(destino);

                JLabel hora = new JLabel("Parte a las " + String.valueOf(viaje.getFechaInicio().getHour()) + "hrs");
                hora.setFont(new Font("Lucida Sans", Font.PLAIN, fontSize));
                hora.setBounds(x, destino.getY() + vgap, labelWidth, labelHeight);
                this.add(hora);

                JLabel cuantosAsientos = new JLabel("Asientos seleccionados: ");
                cuantosAsientos.setFont(new Font("Lucida Sans", Font.PLAIN, fontSize));
                cuantosAsientos.setBounds(x, hora.getY() + vgap, labelWidth, labelHeight);
                this.add(cuantosAsientos);

                JButton comprar = new JButton("Confirmar Pago");
                comprar.setFont(new Font("IMPACT", Font.PLAIN, 20));
                comprar.setForeground(Color.WHITE);
                comprar.setBackground(Color.BLACK);
                comprar.addActionListener(e -> gridBus.PagarAsientosSeleccionados());
                comprar.setBounds(550, cuantosAsientos.getY() + vgap*3, 300, 50);

                add(comprar);
                add(gridBus);
            }
        };

        this.add(menuCompra, BorderLayout.CENTER);
    }
}
