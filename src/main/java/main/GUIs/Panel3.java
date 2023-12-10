package main.GUIs;

import main.Buses.GridBus;
import main.Ventana;

import javax.swing.*;
import java.awt.*;

public class Panel3 extends JPanel {

    public JLabel asientosSeleccionadosp1;
    public JLabel asientosSeleccionadosp2;

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
                volverButton.setBackground(Color.BLACK);
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

        Panel3 ref = this;

        JPanel menuCompra = new JPanel(){
            {
                int x = 550;
                int vgap = 30;
                int fontSize = 20;
                int labelWidth = 300;
                int labelHeight = 100;
                String busname = null;
                setBackground(Color.WHITE);
                setLayout(null);

                GridBus gridBus_1F = new GridBus(viaje, 1);
                GridBus gridBus_2F;
                gridBus_1F.linkPanel(ref);
                switch (tipo) {
                    case 2:
                        gridBus_2F = new GridBus(viaje, 2);
                        gridBus_2F.linkPanel(ref);
                        gridBus_1F.floor = 1;
                        gridBus_2F.floor = 2;
                        gridBus_1F.setLocation((int) (Ventana.anchura * 0.16) - (int) (gridBus_1F.getWidth() * 0.5), (int) (Ventana.altura * 0.47) - (int) (gridBus_1F.getHeight() * 0.6));
                        gridBus_2F.setLocation((int) (Ventana.anchura * 0.46) - (int) (gridBus_2F.getWidth() * 0.5), (int) (Ventana.altura * 0.47) - (int) (gridBus_2F.getHeight() * 0.6));
                        busname = "Bus de 2 pisos";
                        x = 640;
                        break;
                    default:
                        gridBus_2F = null;
                        gridBus_1F.setLocation((int) (Ventana.anchura * 0.25) - (int) (gridBus_1F.getWidth() * 0.5), (int) (Ventana.altura * 0.5) - (int) (gridBus_1F.getHeight() * 0.6));
                        busname = "Bus Tradicional";
                        break;
                }

                JLabel piso1 = new JLabel("Piso 1");
                piso1.setFont(new Font("IMPACT", Font.BOLD, 30));
                piso1.setBounds(gridBus_1F.getX() + 100, gridBus_1F.getY() + (int) (gridBus_1F.getHeight() * 0.95), 300, 100);
                add(piso1);

                if (gridBus_2F != null){
                    add(gridBus_2F);
                    JLabel piso2 = new JLabel("Piso 2");
                    piso2.setFont(new Font("IMPACT", Font.BOLD, 30));
                    piso2.setBounds(gridBus_2F.getX() + 100, gridBus_2F.getY() + (int) (gridBus_2F.getHeight() * 0.95), 300, 100);
                    add(piso2);
                }

                JLabel resumen = new JLabel("Resumen del Pedido");
                resumen.setFont(new Font("IMPACT", Font.BOLD, 30));
                resumen.setBounds(x, 150, 300, 100);
                add(resumen);

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

                JLabel asientosSel = new JLabel();
                asientosSel.setFont(new Font("Lucida Sans", Font.PLAIN, fontSize/2));
                asientosSel.setBounds(x, cuantosAsientos.getY() + vgap, labelWidth, labelHeight);
                this.add(asientosSel);
                asientosSeleccionadosp1 = asientosSel;

                JLabel asientosSel2 = null;
                if (tipo == 2) {
                    asientosSel.setText("Piso 1:");
                    asientosSel2 = new JLabel("Piso 2:");
                    asientosSel2.setFont(new Font("Lucida Sans", Font.PLAIN, fontSize/2));
                    asientosSel2.setBounds(x, asientosSel.getY() + vgap, labelWidth, labelHeight);
                    asientosSeleccionadosp2 = asientosSel2;
                    this.add(asientosSel2);
                }

                JButton comprar = new JButton("Confirmar Pago");
                comprar.setFont(new Font("IMPACT", Font.PLAIN, 20));
                comprar.setForeground(Color.WHITE);
                comprar.setBackground(Color.BLACK);
                comprar.addActionListener(e -> {
                    gridBus_1F.PagarAsientosSeleccionados();
                    if (gridBus_2F != null){
                        gridBus_2F.PagarAsientosSeleccionados();
                    }
                });
                comprar.setBounds(x, asientosSel.getY() + vgap*4, 300, 50);

                add(comprar);
                add(gridBus_1F);

            }
        };
        this.add(menuCompra, BorderLayout.CENTER);
    }
}
