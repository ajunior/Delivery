package ui;

import fachada.Fachada;
import modelo.Pedido;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FecharPedidoFrame extends JDialog {
    private JPanel contentPanel;
    private JLabel lblTelefone;
    private JLabel lblEntregador;
    private JTextField textFieldTelefone;
    private JTextField textFieldEntregador;
    private JButton btnFecharPedido;

    public FecharPedidoFrame () {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(500, 180);
        setTitle("Fechar Pedido");
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

        lblEntregador = new JLabel("Entregador:");
        lblEntregador.setBounds(10, 60, 80, 20);
        contentPanel.add(lblEntregador);

        textFieldEntregador = new JTextField();
        textFieldEntregador.setBounds(80, 60, 310, 26);
        contentPanel.add(textFieldEntregador);
        textFieldEntregador.setColumns(10);

        btnFecharPedido = new JButton("Fechar");
        btnFecharPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if (textFieldTelefone.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Telefone do cliente é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else if (textFieldEntregador.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O nome de entregador é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else {
                        String telefone = textFieldTelefone.getText();
                        String entregador = textFieldEntregador.getText();

                        Pedido p = Fachada.fecharPedido(telefone, entregador);
                        if (p != null)
                            JOptionPane.showConfirmDialog(null,
                                    "Pedido fechado com sucesso.\nTelefone do Cliente: " + telefone + ".\nID do pedido: " +  p.getId() + ".\nValor do Pedido: R$ " + p.getTotal(),
                                    "Alerta",
                                    JOptionPane.DEFAULT_OPTION);

                        textFieldTelefone.setText("");
                        textFieldEntregador.setText("");
                        textFieldTelefone.requestFocus();
                    }
                }
                catch(Exception erro){
                    JOptionPane.showConfirmDialog(null,erro.getMessage(), "Alerta", JOptionPane.DEFAULT_OPTION);
                }
            }
        });
        btnFecharPedido.setBounds(10, 105, 110, 24);
        contentPanel.add(btnFecharPedido);
    }
}
