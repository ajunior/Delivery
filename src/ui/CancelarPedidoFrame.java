package ui;

import fachada.Fachada;
import mdlaf.utils.MaterialColors;
import modelo.Cliente;
import modelo.Pedido;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CancelarPedidoFrame extends JDialog {
    private JPanel contentPanel;
    private JLabel lblTelefone;
    private JTextField textFieldTelefone;
    private JLabel lblPedidoAberto;
    private JButton btnConsultar;

    public CancelarPedidoFrame () {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(550, 160);
        setTitle("Cancelar Pedido");
        setResizable(false);
        setLocationRelativeTo(null);
        setBackground(MaterialColors.WHITE);
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
                            lblPedidoAberto.setText("Há pedido aberto para o cliente: " + telefone + ". ID do pedido: " +  p.getId() + ".");
                        else
                            lblPedidoAberto.setText("Não há pedido aberto para o cliente: " + telefone + ".");

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

        lblPedidoAberto = new JLabel("");
        lblPedidoAberto.setBounds(10, 80, 400, 20);
        contentPanel.add(lblPedidoAberto);
    }
}
