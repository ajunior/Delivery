package ui;

import fachada.Fachada;
import modelo.Cliente;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarClienteFrame extends JDialog {

    private JPanel contentPanel;
    private JLabel lblTelefone;
    private JLabel lblNome;
    private JLabel lblEmail;
    private JLabel lblEndereco;
    private JTextField textFieldTelefone;
    private JTextField textFieldNome;
    private JTextField textFieldEmail;
    private JTextField textFieldEndereco;
    private JButton btnCadastrar;

    public CadastrarClienteFrame() {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(420, 265);
        setTitle("Cadastrar Cliente");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(10, 20, 100, 20);
        contentPanel.add(lblTelefone);

        textFieldTelefone = new JTextField();
        textFieldTelefone.setBounds(80, 20, 310, 26);
        contentPanel.add(textFieldTelefone);
        textFieldTelefone.setColumns(10);

        lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 60, 80, 20);
        contentPanel.add(lblNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(80, 60, 310, 26);
        contentPanel.add(textFieldNome);
        textFieldNome.setColumns(10);

        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 100, 100, 20);
        contentPanel.add(lblEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(80, 100, 310, 26);
        contentPanel.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(10, 140, 80, 20);
        contentPanel.add(lblEndereco);

        textFieldEndereco = new JTextField();
        textFieldEndereco.setBounds(80, 140, 310, 26);
        contentPanel.add(textFieldEndereco);
        textFieldEndereco.setColumns(10);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if (textFieldTelefone.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Telefone do cliente é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else if (textFieldTelefone.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Nome do cliente é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else if (textFieldTelefone.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Email do cliente é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else if (textFieldTelefone.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Endereço do cliente é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);
                    else {
                        String telefone = textFieldTelefone.getText();
                        String nome = textFieldNome.getText();
                        String email = textFieldEmail.getText();
                        String endereco = textFieldEndereco.getText();
                        Cliente c = Fachada.cadastrarCliente(telefone, nome, email, endereco);
                        if (c != null)
                            JOptionPane.showConfirmDialog(null,"Cliente cadastrado com sucesso.", "Confirmação", JOptionPane.DEFAULT_OPTION);
                    }
                }
                catch(Exception erro){
                    JOptionPane.showConfirmDialog(null,erro.getMessage(), "Alerta", JOptionPane.DEFAULT_OPTION);
                }

                textFieldTelefone.setText("");
                textFieldNome.setText("");
                textFieldEmail.setText("");
                textFieldEndereco.setText("");
            }
        });
        btnCadastrar.setBounds(10, 185, 100, 24);
        contentPanel.add(btnCadastrar);
    }
}
