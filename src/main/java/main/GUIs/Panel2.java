package main.GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel2 extends JPanel {
    private JPanel contenedor;
    private JPanel panelPrincipal;
    private JPanel contenedorBuses;
    private CardLayout cardLayout;

    public void updateBuses(PanelBus[] buses) {
        this.contenedorBuses.removeAll();
        for (PanelBus panel : buses) {
            if (panel != null) {
                panel.updateSeats();
            }
            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    JPanel panelAsientos = new Panel3(panel.getViaje(), panelPrincipal, cardLayout);
                    panelPrincipal.add(panelAsientos, "panelAsientos");
                    cardLayout.show(panelPrincipal, "panelAsientos");
                }
            });
            this.contenedorBuses.add(panel);
        }
        this.contenedorBuses.add(Box.createVerticalGlue());
    }

    public Panel2(JPanel panelPrincipal, CardLayout cardLayout) {
        this.panelPrincipal = panelPrincipal;
        this.cardLayout = cardLayout;
        this.setBackground(Color.WHITE);
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
                volverButton.addActionListener(e -> cardLayout.show(panelPrincipal, "panelInicio"));
                add(volverButton, gbc);

                gbc.anchor = GridBagConstraints.CENTER;

                JLabel headline = new JLabel("Buses Disponibles");
                headline.setFont(new Font("IMPACT", Font.BOLD, 35));
                add(headline, gbc);
            }
        };

        JPanel contenedorBuses = new JPanel();
        contenedorBuses.setLayout(new BoxLayout(contenedorBuses, BoxLayout.Y_AXIS));
        contenedorBuses.setBackground(Color.WHITE);
        this.contenedorBuses = contenedorBuses;

        JScrollPane scrollPane = new JScrollPane(contenedorBuses);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(header,BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}
