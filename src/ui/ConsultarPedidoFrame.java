package ui;

import fachada.Fachada;
import modelo.Pedido;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarPedidoFrame extends JDialog {
    private JPanel contentPanel;
    private JLabel lblTelefone;
    private JTextField textFieldTelefone;
    private JButton btnConsultar;

    public ConsultarPedidoFrame () {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(600, 100);
        setTitle("Consultar Pedido");
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

        btnConsultar = new JButton("Pesquisar");
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if (textFieldTelefone.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Telefone do cliente é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else {
                        String telefone = textFieldTelefone.getText();

                        Pedido p = Fachada.consultarPedido(telefone);
                        if (p != null)
                        JOptionPane.showConfirmDialog(null,
                                "Há pedido aberto para o cliente: " + telefone + ".\nID do pedido: " +  p.getId() + ".",
                                "Alerta",
                                JOptionPane.DEFAULT_OPTION);
                        else
                            JOptionPane.showConfirmDialog(null,
                                    "Não há pedido aberto para o cliente: \" + telefone + \".\"" +  p.getId() + ".",
                                    "Alerta",
                                    JOptionPane.DEFAULT_OPTION);

                        textFieldTelefone.setText("");
                        textFieldTelefone.requestFocus();
                    }
                }
                catch(Exception erro){
                    JOptionPane.showConfirmDialog(null,erro.getMessage(), "Alerta", JOptionPane.DEFAULT_OPTION);
                }
            }
        });
        btnConsultar.setBounds(400, 20, 120, 24);
        contentPanel.add(btnConsultar);
    }
}
