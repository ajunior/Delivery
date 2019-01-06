package common;

import ui.MainFrame;
import fachada.Fachada;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {

        // iniciaRestaurante();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
