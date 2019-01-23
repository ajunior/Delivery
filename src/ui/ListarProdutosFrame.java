package ui;

import fachada.Fachada;
import modelo.Produto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListarProdutosFrame extends JDialog {

    private JPanel contentPanel;
    private JLabel lblProduto;
    private JTextField textFieldProduto;
    private JButton btnConsultar;
    private JLabel lblQtdeProdutos;
    private JLabel lblQtde;
    private JTable tblListaProdutos;

    public ListarProdutosFrame() {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(600, 500);
        setTitle("Lista de Produtos");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        lblProduto = new JLabel("Telefone:");
        lblProduto.setBounds(10, 20, 80, 20);
        contentPanel.add(lblProduto);

        textFieldProduto = new JTextField("");
        textFieldProduto.setBounds(80, 20, 310, 26);
        contentPanel.add(textFieldProduto);
        textFieldProduto.setColumns(10);

        btnConsultar = new JButton("Pesquisar");
        btnConsultar.setBounds(400, 20, 120, 24);
        contentPanel.add(btnConsultar);

        String[] tblHeader = {"Código", "Produto", "Preço"};

        DefaultTableModel model = new DefaultTableModel(tblHeader, 0);
        tblListaProdutos = new JTable(model);
        contentPanel.add(tblListaProdutos);

        JScrollPane jsp = new JScrollPane(tblListaProdutos);
        jsp.setBounds(10, 60, 565, 360);
        contentPanel.add(jsp);
        jsp.setViewportView(tblListaProdutos);

        lblQtdeProdutos = new JLabel("Quantidade de Produtos:");
        lblQtdeProdutos.setBounds(10, 430, 150, 20);
        contentPanel.add(lblQtdeProdutos);

        lblQtde = new JLabel("");
        lblQtde.setBounds(155, 430, 80, 20);
        contentPanel.add(lblQtde);

        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    ArrayList<Produto> resultado = Fachada.listarProdutos(textFieldProduto.getText());
                    lblQtde.setText(Integer.toString(resultado.size()));
                    model.setRowCount(resultado.size());

                    int linha = 0;
                    for (Produto p : resultado) {
                        tblListaProdutos.setValueAt(p.getId(), linha, 0);
                        tblListaProdutos.setValueAt(p.getNome(), linha, 1);
                        tblListaProdutos.setValueAt(p.getPreco(), linha, 2);
                        linha++;
                    }
                }
                catch(Exception erro){
                    JOptionPane.showConfirmDialog(null,erro.getMessage(), "Alerta", JOptionPane.DEFAULT_OPTION);
                }
            }
        });
    }
}
