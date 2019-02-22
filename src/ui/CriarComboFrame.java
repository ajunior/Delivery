package ui;

import javax.swing.*;
import java.awt.*;

public class CriarComboFrame extends JDialog {

    public CriarComboFrame () {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(420, 180);
        setTitle("Criar Combo");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
