package ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JButton btn;

    public MainFrame () {
        super("Delivery");

        setLayout(new FlowLayout());
        setSize(1080, 768);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        btn = new JButton("Ok");
        add(btn, FlowLayout.LEFT);
    }
}
