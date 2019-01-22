package ui;

import fachada.Fachada;
import modelo.Produto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarProdutoFrame extends JDialog {

    private JPanel contentPanel;
    private JLabel lblNome;
    private JLabel lblPreco;
    private JTextField textFieldNome;
    private JTextField textFieldPreco;
    private JButton btnCadastrar;

    public CadastrarProdutoFrame() {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(420, 180);
        setTitle("Cadastrar Produto");
        setResizable(false);
        setLocationRelativeTo(null);
        //setBackground(MaterialColors.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 20, 80, 20);
        contentPanel.add(lblNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(80, 20, 310, 26);
        contentPanel.add(textFieldNome);
        textFieldNome.setColumns(10);

        lblPreco = new JLabel("Preço:");
        lblPreco.setBounds(10, 60, 100, 20);
        contentPanel.add(lblPreco);

        textFieldPreco = new JTextField();
        textFieldPreco.setBounds(80, 60, 310, 26);
        contentPanel.add(textFieldPreco);
        textFieldPreco.setColumns(10);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if (textFieldNome.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Nome do produto é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else if (textFieldPreco.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Preço do produto é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else {
                        String nome = textFieldNome.getText();
                        String preco = textFieldPreco.getText();

                        Produto p = Fachada.cadastrarProduto(nome, Double.parseDouble(preco));
                        if (p != null)
                            JOptionPane.showConfirmDialog(null,"Produto cadastrado com sucesso.", "Confirmação", JOptionPane.DEFAULT_OPTION);
                    }

                    textFieldNome.setText("");
                    textFieldPreco.setText("");
                    textFieldNome.requestFocus();
                }
                catch(Exception erro){
                    JOptionPane.showConfirmDialog(null,erro.getMessage(), "Alerta", JOptionPane.DEFAULT_OPTION);
                }
            }
        });
        btnCadastrar.setBounds(10, 100, 100, 24);
        contentPanel.add(btnCadastrar);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                textFieldNome.setText("");
                textFieldPreco.setText("");
            }
        });
    }
}
