package ui;

import fachada.Fachada;
import modelo.Cliente;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListarClientesFrame extends JDialog {

    private JPanel contentPanel;
    private JTable tblListaClientes;
    private JLabel lblQtdeClientes;
    private JLabel lblQtde;

    public ListarClientesFrame() {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(600, 500);
        setTitle("Lista de Clientes");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        String[] tblHeader = { "Telefone", "Nome", "Email", "Endereço", "Qtde Pedidos" };

        ArrayList<Cliente> resultado = Fachada.listarClientes();

        DefaultTableModel model = new DefaultTableModel(tblHeader, resultado.size());
        tblListaClientes = new JTable(model);
        contentPanel.add(tblListaClientes);

        int linha = 0;
        for (Cliente c : resultado) {
            tblListaClientes.setValueAt(c.getTelefone(), linha, 0);
            tblListaClientes.setValueAt(c.getNome(), linha, 1);
            tblListaClientes.setValueAt(c.getEmail(), linha, 2);
            tblListaClientes.setValueAt(c.getEndereco(), linha, 3);

            int qtdePedidos = c.getQtdePedidos();
            System.out.println(qtdePedidos);

            tblListaClientes.setValueAt(qtdePedidos, linha, 4);
            linha++;
        }

        JScrollPane jsp = new JScrollPane(tblListaClientes);
        jsp.setBounds(10, 10, 565, 415);
        contentPanel.add(jsp);
        jsp.setViewportView(tblListaClientes);

        lblQtdeClientes = new JLabel("Quantidade de Clientes:");
        lblQtdeClientes.setBounds(10, 430, 150, 20);
        contentPanel.add(lblQtdeClientes);

        lblQtde = new JLabel("");
        lblQtde.setBounds(155, 430, 80, 20);
        contentPanel.add(lblQtde);

        lblQtde.setText(Integer.toString(resultado.size()));
    }
}
