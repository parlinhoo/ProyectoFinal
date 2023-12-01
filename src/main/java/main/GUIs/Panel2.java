package main.GUIs;

import javax.swing.*;
import java.awt.*;

public class Panel2 extends JPanel {

    public Panel2(JPanel panel, CardLayout cardLayout) {
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
                volverButton.addActionListener(e -> cardLayout.show(panel, "panelInicio"));
                add(volverButton, gbc);

                gbc.anchor = GridBagConstraints.CENTER;

                JLabel headline = new JLabel("Buses Disponibles");
                headline.setFont(new Font("IMPACT", Font.BOLD, 35));
                add(headline, gbc);
            }
        };

        JPanel contenedorBuses = new JPanel(){
            {
                setLayout(new GridLayout(0,1,0 ,10));
                int buses = 0;
                for (int i=1; i<3; i++){
                    add(new PanelBus(i));
                    buses++;
                    if(i == 2){
                        i = 0;
                    }
                    if (buses == 15){
                        break;
                    }
                }
            }
        };

        JScrollPane scrollPane = new JScrollPane(contenedorBuses);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(header,BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}
