package ui;

import fachada.Fachada;
import mdlaf.utils.MaterialColors;
import modelo.Cliente;
import modelo.Pedido;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ListarPedidosFrame extends JDialog {
    private JPanel contentPanel;
    private JLabel lblQtdePedidos;
    private JLabel lblQtde;
    private JTextArea textAreaListaPedidos;

    public ListarPedidosFrame () {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(600, 500);
        setTitle("Lista de Pedidos");
        setResizable(false);
        setLocationRelativeTo(null);
        setBackground(MaterialColors.WHITE);
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        textAreaListaPedidos = new JTextArea();
        textAreaListaPedidos.setBounds(10, 10, 565, 400);
        contentPanel.add(textAreaListaPedidos);

        lblQtdePedidos = new JLabel("Quantidade de Pedidos:");
        lblQtdePedidos.setBounds(10, 430, 150, 20);
        contentPanel.add(lblQtdePedidos);

        lblQtde = new JLabel("");
        lblQtde.setBounds(155, 430, 80, 20);
        contentPanel.add(lblQtde);

        ArrayList<Pedido> resultado = Fachada.listarPedidos();
        lblQtde.setText(Integer.toString(resultado.size()));

        String texto = "Listagem de Pedidos: \n";

        if (resultado.isEmpty())
            texto += "Nenhum pedido cadastrado\n";
        else
            for (Pedido p : resultado)
                texto += p + "\n";

        textAreaListaPedidos.setText(texto);
    }
}
