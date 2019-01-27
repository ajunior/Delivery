package ui;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ListarPedidosPorClienteFrame extends JDialog {
    private JPanel contentPanel;
    private JLabel lblTelefone;
    private JTextField textFieldTelefone;
    private JLabel lblQtdePedidos;
    private JLabel lblQtde;
    private JTable tblListaPedidos;
    private JButton btnAbrirPedido;

    public ListarPedidosPorClienteFrame () {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(600, 500);
        setTitle("Lista de Pedidos por Cliente");
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

        btnAbrirPedido = new JButton("Pesquisar");
        btnAbrirPedido.setBounds(400, 20, 120, 24);
        contentPanel.add(btnAbrirPedido);

        String[] tblHeader = {"Nr", "Data", "Cliente", "Qtde. Produtos", "Status", "Entregador"};

        DefaultTableModel model = new DefaultTableModel(tblHeader, 0);
        tblListaPedidos = new JTable(model);
        contentPanel.add(tblListaPedidos);

        JScrollPane jsp = new JScrollPane(tblListaPedidos);
        jsp.setBounds(10, 60, 565, 360);
        contentPanel.add(jsp);
        jsp.setViewportView(tblListaPedidos);

        lblQtdePedidos = new JLabel("Quantidade de Pedidos do Cliente:");
        lblQtdePedidos.setBounds(10, 430, 200, 20);
        contentPanel.add(lblQtdePedidos);

        lblQtde = new JLabel("");
        lblQtde.setBounds(210, 430, 80, 20);
        contentPanel.add(lblQtde);

        btnAbrirPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if (textFieldTelefone.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Telefone do cliente é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else {
                        String telefone = textFieldTelefone.getText();

                        ArrayList<Pedido> resultado = Fachada.listarPedidos(telefone);

                        lblQtde.setText(Integer.toString(resultado.size()));
                        model.setRowCount(resultado.size());

                        int linha = 0;
                        for (Pedido p : resultado) {
                            tblListaPedidos.setValueAt(p.getId(), linha, 0);
                            tblListaPedidos.setValueAt(p.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), linha, 1);
                            tblListaPedidos.setValueAt(p.getCliente(), linha, 2);
                            ArrayList<Produto> pd = p.getProdutos();
                            //tblListaPedidos.setValueAt(pd.size(), linha, 3);
                            tblListaPedidos.setValueAt(p.getFechado() ? "Fechado" : "Aberto", linha, 4);
                            tblListaPedidos.setValueAt(p.getEntregador(), linha, 5);
                            linha++;
                        }

                        textFieldTelefone.setText("");
                        textFieldTelefone.requestFocus();
                    }
                }
                catch(Exception erro){
                    JOptionPane.showConfirmDialog(null,erro.getMessage(), "Alerta", JOptionPane.DEFAULT_OPTION);
                }
            }
        });
    }
}
