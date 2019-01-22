package ui;

import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;

public class SobreFrame extends JDialog {
    JLabel lblNomePrograma = new JLabel("Delivery v.0.1");
    JLabel lblCopyright = new JLabel("Estudante: Adjamilton Junior (jr@ieee.org)");

    public SobreFrame() {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(400, 100);
        setResizable(false);
        setLocationRelativeTo(null);
        setBackground(MaterialColors.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(lblNomePrograma, BorderLayout.NORTH);
        add(lblCopyright, BorderLayout.SOUTH);
    }
}
