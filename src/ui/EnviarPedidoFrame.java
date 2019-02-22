package ui;

import fachada.Fachada;
import modelo.Produto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EnviarPedidoFrame extends JDialog {
    private JPanel contentPanel;
    private JLabel lblTelefone;
    private JLabel lblSenha;
    private JTextField textFieldTelefone;
    private JTextField textFieldSenha;
    private JButton btnCadastrar;

    public EnviarPedidoFrame () {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(420, 180);
        setTitle("Enviar Pedido");
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

        lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(10, 60, 100, 20);
        contentPanel.add(lblSenha);

        textFieldSenha = new JTextField();
        textFieldSenha.setBounds(80, 60, 310, 26);
        contentPanel.add(textFieldSenha);
        textFieldSenha.setColumns(10);

        btnCadastrar = new JButton("Enviar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if (textFieldTelefone.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Telefone do produto é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else if (textFieldSenha.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Preço do produto é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else {
                        String telefone = textFieldTelefone.getText();
                        String senha = textFieldSenha.getText();

                        Fachada.enviarPedido(telefone, senha);

                    }
                }
                catch(Exception erro){
                    JOptionPane.showConfirmDialog(null,erro.getMessage(), "Alerta", JOptionPane.DEFAULT_OPTION);
                }

                textFieldTelefone.setText("");
                textFieldSenha.setText("");
                textFieldTelefone.requestFocus();
            }
        });
        btnCadastrar.setBounds(10, 100, 100, 24);
        contentPanel.add(btnCadastrar);
    }
}
