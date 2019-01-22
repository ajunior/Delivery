package ui;

import fachada.Fachada;
import modelo.Cliente;

import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListarClientesFrame extends JDialog {

    private JPanel contentPanel;
    private JLabel lblQtdeClientes;
    private JLabel lblQtde;
    private JTextArea textAreaListaClientes;

    public ListarClientesFrame() {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(600, 500);
        setTitle("Lista de Clientes");
        setResizable(false);
        setLocationRelativeTo(null);
        setBackground(MaterialColors.WHITE);
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        textAreaListaClientes = new JTextArea();
        textAreaListaClientes.setBounds(10, 10, 565, 400);
        contentPanel.add(textAreaListaClientes);

        lblQtdeClientes = new JLabel("Quantidade de Clientes:");
        lblQtdeClientes.setBounds(10, 430, 150, 20);
        contentPanel.add(lblQtdeClientes);

        lblQtde = new JLabel("");
        lblQtde.setBounds(155, 430, 80, 20);
        contentPanel.add(lblQtde);

        ArrayList<Cliente> resultado = Fachada.listarClientes();
        lblQtde.setText(Integer.toString(resultado.size()));

        String texto = "Listagem de Clientes: \n";

        if (resultado.isEmpty())
            texto += "Nenhum cliente cadastrado\n";
        else
            for (Cliente c : resultado)
                texto += c + "\n";

        textAreaListaClientes.setText(texto);
    }
}
