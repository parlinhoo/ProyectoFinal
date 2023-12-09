package main.GUIs;

import main.Buses.GridBus;

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
                setBackground(Color.WHITE);
                setLayout(null);
                GridBus gridBus = new GridBus(viaje, tipo);
                gridBus.setBounds(30, 30, 400, 600);
                JButton comprar = new JButton("Confirmar Pago");
                comprar.addActionListener(e -> gridBus.PagarAsientosSeleccionados());
                comprar.setBounds(550, 500, 300, 50);
                add(comprar);
                add(gridBus);
            }
        };

        this.add(menuCompra, BorderLayout.CENTER);
    }
}
