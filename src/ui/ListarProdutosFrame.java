package ui;

import fachada.Fachada;
import modelo.Pedido;
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
    private JLabel lblProduto;
    private JTextField textFieldProduto;
    private JLabel lblListagem;
    private JButton btnConsultar;
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

        lblProduto = new JLabel("Telefone:");
        lblProduto.setBounds(10, 20, 80, 20);
        contentPanel.add(lblProduto);

        textFieldProduto = new JTextField();
        textFieldProduto.setBounds(80, 20, 310, 26);
        contentPanel.add(textFieldProduto);
        textFieldProduto.setColumns(10);

        btnConsultar = new JButton("Pesquisar");
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    ArrayList<Produto> resultado = Fachada.listarProdutos(textFieldProduto.getText());
                    lblQtde.setText(Integer.toString(resultado.size()));

                    String texto = "";

                    if (resultado.isEmpty())
                        texto += "Nenhum produto encontrado ou cadastrado.\n";
                    else
                        for (Produto p : resultado)
                            texto += p + "\n";

                    textAreaListaProdutos.setText(texto);
                }
                catch(Exception erro){
                    JOptionPane.showConfirmDialog(null,erro.getMessage(), "Alerta", JOptionPane.DEFAULT_OPTION);
                }
            }
        });
        btnConsultar.setBounds(400, 20, 120, 24);
        contentPanel.add(btnConsultar);

        lblListagem = new JLabel("Listagem de Produtos:");
        lblListagem.setBounds(10, 60, 150, 20);
        contentPanel.add(lblListagem);

        textAreaListaProdutos = new JTextArea();
        textAreaListaProdutos.setBounds(10, 85, 565, 340);
        contentPanel.add(textAreaListaProdutos);

        lblQtdeProdutos = new JLabel("Quantidade de Produtos:");
        lblQtdeProdutos.setBounds(10, 430, 150, 20);
        contentPanel.add(lblQtdeProdutos);

        lblQtde = new JLabel("");
        lblQtde.setBounds(155, 430, 80, 20);
        contentPanel.add(lblQtde);
    }
}
