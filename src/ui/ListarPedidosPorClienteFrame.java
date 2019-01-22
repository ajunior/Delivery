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

public class ListarPedidosPorClienteFrame extends JDialog {
    private JPanel contentPanel;
    private JLabel lblTelefone;
    private JTextField textFieldTelefone;
    private JLabel lblQtdePedidos;
    private JLabel lblQtde;
    private JTextArea textAreaListaPedidos;
    private JButton btnAbrirPedido;

    public ListarPedidosPorClienteFrame () {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(600, 500);
        setTitle("Lista de Pedidos por Cliente");
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

        btnAbrirPedido = new JButton("Pesquisar");
        btnAbrirPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if (textFieldTelefone.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Telefone do cliente é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else {
                        String telefone = textFieldTelefone.getText();

                        ArrayList<Pedido> resultado = Fachada.listarPedidos(telefone);

                        lblQtde.setText(Integer.toString(resultado.size()));

                        String texto = "Listagem de Pedidos: \n";

                        if (resultado.isEmpty())
                            texto += "Nenhum pedido cadastrado para este cliente\n";
                        else
                            for (Pedido p : resultado)
                                texto += p + "\n";

                        textAreaListaPedidos.setText(texto);

                        textFieldTelefone.setText("");
                        textFieldTelefone.requestFocus();
                    }
                }
                catch(Exception erro){
                    JOptionPane.showConfirmDialog(null,erro.getMessage(), "Alerta", JOptionPane.DEFAULT_OPTION);
                }
            }
        });
        btnAbrirPedido.setBounds(400, 20, 120, 24);
        contentPanel.add(btnAbrirPedido);

        textAreaListaPedidos = new JTextArea();
        textAreaListaPedidos.setBounds(10, 60, 565, 360);
        contentPanel.add(textAreaListaPedidos);

        lblQtdePedidos = new JLabel("Quantidade de Pedidos do Cliente:");
        lblQtdePedidos.setBounds(10, 430, 200, 20);
        contentPanel.add(lblQtdePedidos);

        lblQtde = new JLabel("");
        lblQtde.setBounds(210, 430, 80, 20);
        contentPanel.add(lblQtde);
    }
}
