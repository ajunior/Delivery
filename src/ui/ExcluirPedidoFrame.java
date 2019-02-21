package ui;

import fachada.Fachada;
import modelo.Pedido;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExcluirPedidoFrame extends JDialog {
    private JPanel contentPanel;
    private JLabel lblIdPedido;
    private JTextField textFieldIdPedido;
    private JButton btnExcluirPedido;

    public ExcluirPedidoFrame () {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(600, 100);
        setTitle("Excluir Pedido");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        lblIdPedido = new JLabel("ID do Pedido:");
        lblIdPedido.setBounds(10, 20, 80, 20);
        contentPanel.add(lblIdPedido);

        textFieldIdPedido = new JTextField();
        textFieldIdPedido.setBounds(80, 20, 310, 26);
        contentPanel.add(textFieldIdPedido);
        textFieldIdPedido.setColumns(10);

        btnExcluirPedido = new JButton("Excluir");
        btnExcluirPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if (textFieldIdPedido.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Código (ID) do Pedido do cliente é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else {
                        String pedido = textFieldIdPedido.getText();

                        Pedido p = Fachada.excluirPedido(Integer.parseInt(pedido));
                        if (p != null)
                            JOptionPane.showConfirmDialog(null,
                                    "O Pedido " + pedido + "não existe.",
                                    "Alerta",
                                    JOptionPane.DEFAULT_OPTION);
                        else
                            JOptionPane.showConfirmDialog(null,
                                    "Não há pedido aberto para o cliente: \" + telefone + \".\"" +  p.getId() + ".",
                                    "Alerta",
                                    JOptionPane.DEFAULT_OPTION);

                        textFieldIdPedido.setText("");
                        textFieldIdPedido.requestFocus();
                    }
                }
                catch(Exception erro){
                    JOptionPane.showConfirmDialog(null,erro.getMessage(), "Alerta", JOptionPane.DEFAULT_OPTION);
                }
            }
        });
        btnExcluirPedido.setBounds(400, 20, 120, 24);
        contentPanel.add(btnExcluirPedido);
    }
}
