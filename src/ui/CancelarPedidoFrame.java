package ui;

import fachada.Fachada;
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
    private JButton btnCancelar;

    public CancelarPedidoFrame () {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(550, 120);
        setTitle("Cancelar Pedido");
        setResizable(false);
        setLocationRelativeTo(null);
        //setBackground(MaterialColors.WHITE);
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

        btnCancelar = new JButton("Pesquisar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if (textFieldTelefone.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Telefone do cliente é obrigatório.",
                                "Alerta", JOptionPane.DEFAULT_OPTION);

                    else {
                        String telefone = textFieldTelefone.getText();

                        Pedido p = Fachada.consultarPedido(telefone);
                        if (p != null)
                            if (JOptionPane.showConfirmDialog(null,
                                    "Pedido encontrado.\nTem certeza que deseja cancelar este pedido?", "Close Window?",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                                p = Fachada.cancelarPedido(telefone);
                                if (p != null)
                                    JOptionPane.showConfirmDialog(null, "Pedido cancelado com sucesso. ",
                                            "Alerta", JOptionPane.DEFAULT_OPTION);
                                else
                                    JOptionPane.showConfirmDialog(null, "Não há pedido aberto para o cliente.",
                                            "Alerta", JOptionPane.DEFAULT_OPTION);
                            }
                        textFieldTelefone.setText("");
                        textFieldTelefone.requestFocus();
                    }
                }
                catch(Exception erro){
                    JOptionPane.showConfirmDialog(null,erro.getMessage(), "Alerta",
                            JOptionPane.DEFAULT_OPTION);
                }
            }
        });
        btnCancelar.setBounds(400, 20, 120, 24);
        contentPanel.add(btnCancelar);
    }
}
