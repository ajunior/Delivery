package ui;

import fachada.Fachada;
import modelo.Produto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarComboFrame extends JDialog {
    private JPanel contentPanel;
    private JLabel lblNome;
    private JTextField textFieldNome;
    private JButton btnCadastrar;

    public CriarComboFrame () {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(420, 180);
        setTitle("Cadastrar Produto");
        setResizable(false);
        setLocationRelativeTo(null);
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

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if (textFieldNome.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Nome do produto é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else {
                        String nome = textFieldNome.getText();



                    }
                }
                catch(Exception erro){
                    JOptionPane.showConfirmDialog(null,erro.getMessage(), "Alerta", JOptionPane.DEFAULT_OPTION);
                }

                textFieldNome.setText("");
                textFieldNome.requestFocus();
            }
        });
        btnCadastrar.setBounds(10, 100, 100, 24);
        contentPanel.add(btnCadastrar);
    }
}
