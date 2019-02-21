package ui;

import fachada.Fachada;
import modelo.Produto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RetirarProdutoFrame extends JDialog {
    private JPanel contentPanel;
    private JLabel lblTelefone;
    private JLabel lblProduto;
    private JTextField textFieldTelefone;
    private JTextField textFieldProduto;
    private JButton btnAdicionar;

    public RetirarProdutoFrame() {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(420, 180);
        setTitle("Adicionar Produto");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(10, 20, 80, 20);
        contentPanel.add(lblTelefone);

        textFieldTelefone = new JTextField();
        textFieldTelefone.setBounds(80, 20, 310, 26);
        contentPanel.add(textFieldTelefone);
        textFieldTelefone.setColumns(10);

        lblProduto = new JLabel("Nome do Produto:");
        lblProduto.setBounds(10, 60, 80, 20);
        contentPanel.add(lblProduto);

        textFieldProduto = new JTextField();
        textFieldProduto.setBounds(80, 60, 310, 26);
        contentPanel.add(textFieldProduto);
        textFieldProduto.setColumns(10);

        btnAdicionar = new JButton("Retirar");
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textFieldTelefone.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null, "O Telefone do cliente é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    if (textFieldProduto.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null, "O nome do produto é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else {
                        String telefone = textFieldTelefone.getText();
                        String produto = textFieldProduto.getText();

                        ArrayList<Produto> produtos = Fachada.listarProdutos(produto);
                        if (produtos.size() != 1)
                            JOptionPane.showConfirmDialog(null,
                                    "Produto não existe ou não foi especificado corretamente.",
                                    "Alerta",
                                    JOptionPane.DEFAULT_OPTION);

                        else {


                            int id_produto = produtos.get(0).getId();
                            Produto p = Fachada.removerProdutoPedido(telefone, id_produto);
                            if (p != null)
                                JOptionPane.showConfirmDialog(null,
                                        "Produto retirado com sucesso.",
                                        "Alerta",
                                        JOptionPane.DEFAULT_OPTION);

                            textFieldTelefone.setText("");
                            textFieldProduto.setText("");
                            textFieldTelefone.requestFocus();
                        }
                    }
                } catch (Exception erro) {
                    JOptionPane.showConfirmDialog(null, erro.getMessage(), "Alerta", JOptionPane.DEFAULT_OPTION);
                }
            }
        });
        btnAdicionar.setBounds(10, 100, 120, 24);
        contentPanel.add(btnAdicionar);
    }
}