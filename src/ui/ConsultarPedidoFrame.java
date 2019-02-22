package ui;

import fachada.Fachada;
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

public class ConsultarPedidoFrame extends JDialog {
    private JPanel contentPanel;
    private JLabel lblTelefone;
    private JLabel lblCodPedido;
    private JLabel lblCodigo;
    private JLabel lblNome;
    private JLabel lblCliente;
    private JLabel lblDataPedido;
    private JLabel lblData;
    private JLabel lblProdutos;
    private JLabel lblQtdeProdutos;
    private JLabel lblQtde;
    private JTextField textFieldTelefone;
    private JButton btnConsultar;
    private JTable tblListaProdutos;

    public ConsultarPedidoFrame () {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(600, 600);
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
        btnConsultar.setBounds(400, 20, 120, 24);
        contentPanel.add(btnConsultar);

        lblCodPedido = new JLabel("Código do Pedido:");
        lblCodPedido.setBounds(10, 65, 150, 20);
        contentPanel.add(lblCodPedido);

        lblCodigo = new JLabel("");
        lblCodigo.setBounds(140, 65, 80, 20);
        contentPanel.add(lblCodigo);

        lblCliente = new JLabel("Nome do Cliente:");
        lblCliente.setBounds(10, 90, 150, 20);
        contentPanel.add(lblCliente);

        lblNome = new JLabel("");
        lblNome.setBounds(140, 90, 200, 20);
        contentPanel.add(lblNome);

        lblDataPedido = new JLabel("Data do Pedido:");
        lblDataPedido.setBounds(10, 115, 150, 20);
        contentPanel.add(lblDataPedido);

        lblData = new JLabel("");
        lblData.setBounds(140, 115, 200, 20);
        contentPanel.add(lblData);

        lblProdutos = new JLabel("Produtos:");
        lblProdutos.setBounds(10, 140, 80, 20);
        contentPanel.add(lblProdutos);

        String[] tblHeader = {"Código", "Nome", "Preço (R$)"};

        //ArrayList<Pedido> resultado = Fachada.listarPedidos();

        DefaultTableModel model = new DefaultTableModel(tblHeader, 0);
        tblListaProdutos = new JTable(model);
        contentPanel.add(tblListaProdutos);

        JScrollPane jsp = new JScrollPane(tblListaProdutos);
        jsp.setBounds(10, 175, 565, 340);
        contentPanel.add(jsp);
        jsp.setViewportView(tblListaProdutos);

        lblQtdeProdutos = new JLabel("Quantidade de Produtos:");
        lblQtdeProdutos.setBounds(10, 525, 180, 20);
        contentPanel.add(lblQtdeProdutos);

        lblQtde = new JLabel("Addd");
        lblQtde.setBounds(200, 525, 80, 20);
        contentPanel.add(lblQtde);

        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if (textFieldTelefone.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"O Telefone do cliente é obrigatório.", "Alerta", JOptionPane.DEFAULT_OPTION);

                    else {
                        String telefone = textFieldTelefone.getText();

                        Pedido p = Fachada.consultarPedido(telefone);

                        if (p == null)
                            JOptionPane.showConfirmDialog(null,
                                    "Não há pedido aberto para o cliente: \" + telefone + \".\"" +  p.getId() + ".",
                                    "Alerta",
                                    JOptionPane.DEFAULT_OPTION);
                        else {
                            lblCodigo.setText("" + p.getId());
                            lblNome.setText(p.getCliente().getNome());
                            lblData.setText("" + p.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

                            int linha = 0;

                            ArrayList<Produto> produtos = p.getProdutos();

//                            DefaultTableModel model = new DefaultTableModel(tblHeader, produtos.size());
//                            tblListaProdutos = new JTable(model);
//                            contentPanel.add(tblListaProdutos);

                            model.setRowCount(produtos.size());

                            for (Produto prod : produtos) {
                                tblListaProdutos.setValueAt(prod.getId(), linha, 0);
                                tblListaProdutos.setValueAt(prod.getNome(), linha, 1);
                                tblListaProdutos.setValueAt(prod.getPreco(), linha, 2);
                                linha++;
                            }

                            lblQtde.setText(Integer.toString(produtos.size()));
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
