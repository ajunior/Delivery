package modelo;

import fachada.Fachada;
import repositorio.Restaurante;
import ui.MainFrame;

import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        new Fachada();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
