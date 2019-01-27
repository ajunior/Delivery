package ui;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ListarPedidosFrame extends JDialog {
    private JPanel contentPanel;
    private JLabel lblQtdePedidos;
    private JLabel lblQtde;
    private JTable tblListaPedidos;

    public ListarPedidosFrame () {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(600, 500);
        setTitle("Lista de Pedidos");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        String[] tblHeader = {"Nr", "Data", "Cliente", "Qtde. Produtos", "Status", "Entregador"};

        ArrayList<Pedido> resultado = Fachada.listarPedidos();

        DefaultTableModel model = new DefaultTableModel(tblHeader, resultado.size());
        tblListaPedidos = new JTable(model);
        contentPanel.add(tblListaPedidos);

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

        JScrollPane jsp = new JScrollPane(tblListaPedidos);
        jsp.setBounds(10, 10, 565, 415);
        contentPanel.add(jsp);
        jsp.setViewportView(tblListaPedidos);

        tblListaPedidos = new JTable(model);
        tblListaPedidos.setBounds(10, 30, 565, 390);
        contentPanel.add(tblListaPedidos);

        lblQtdePedidos = new JLabel("Quantidade de Pedidos:");
        lblQtdePedidos.setBounds(10, 430, 150, 20);
        contentPanel.add(lblQtdePedidos);

        lblQtde = new JLabel("");
        lblQtde.setBounds(155, 430, 80, 20);
        contentPanel.add(lblQtde);

        lblQtde.setText(Integer.toString(resultado.size()));
    }
}
