package ui;

import fachada.Fachada;
import modelo.Produto;

import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListarProdutosFrame extends JDialog {

    private JPanel contentPanel;
    private JLabel lblQtdeProdutos;
    private JLabel lblQtde;
    private JTextArea textAreaListaProdutos;

    public ListarProdutosFrame() {
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

        textAreaListaProdutos = new JTextArea();
        textAreaListaProdutos.setBounds(10, 10, 565, 400);
        contentPanel.add(textAreaListaProdutos);

        lblQtdeProdutos = new JLabel("Quantidade de Clientes:");
        lblQtdeProdutos.setBounds(10, 430, 150, 20);
        contentPanel.add(lblQtdeProdutos);

        lblQtde = new JLabel("");
        lblQtde.setBounds(155, 430, 80, 20);
        contentPanel.add(lblQtde);

        ArrayList<Produto> resultado = Fachada.listarProdutos("");
        lblQtde.setText(Integer.toString(resultado.size()));

        String texto = "Listagem de Produtos: \n";

        if (resultado.isEmpty())
            texto += "Nenhum cliente cadastrado\n";
        else
            for (Produto p : resultado)
                texto += p + "\n";

        textAreaListaProdutos.setText(texto);
    }
}
