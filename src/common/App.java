package common;

import ui.MainFrame;

import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
