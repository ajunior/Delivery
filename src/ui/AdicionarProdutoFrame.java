package ui;

import fachada.Fachada;
import modelo.Produto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarProdutoFrame extends JDialog {
    private JPanel contentPanel;
    private JLabel lblTelefone;
    private JLabel lblProduto;
    private JTextField textFieldTelefone;
    private JTextField textFieldProduto;
    private JButton btnAdicionar;

    public AdicionarProdutoFrame() {
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

        lblProduto = new JLabel("Produto:");
        lblProduto.setBounds(10, 60, 80, 20);
        contentPanel.add(lblProduto);

        textFieldProduto = new JTextField();
        textFieldProduto.setBounds(80, 60, 310, 26);
        contentPanel.add(textFieldProduto);
        textFieldProduto.setColumns(10);

        btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textFieldTelefone.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null, "O Telefone do cliente é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else {
                        String telefone = textFieldTelefone.getText();
                        String produto = textFieldProduto.getText();

                        Produto p = Fachada.adicionarProdutoPedido(telefone, Integer.parseInt(produto));
                        if (p != null)
                            JOptionPane.showConfirmDialog(null,
                                    "Produto adicionado com sucesso.",
                                    "Alerta",
                                    JOptionPane.DEFAULT_OPTION);

                        textFieldTelefone.setText("");
                        textFieldTelefone.requestFocus();
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