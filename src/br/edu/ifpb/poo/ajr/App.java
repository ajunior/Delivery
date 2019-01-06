package br.edu.ifpb.poo.ajr;

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
