package ui;

import fachada.Fachada;
import modelo.Produto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArrecadacaoFrame extends JDialog {
    private JPanel contentPanel;
    private JLabel lblNomePrograma;
    private JLabel lblResultado;
    private JLabel lblValorArrecadado;
    private JTextField textFieldDia;
    private JButton btnConsultar;

    public ArrecadacaoFrame() {
        setLayout(new FlowLayout());
        setModal(true);
        setSize(420, 160);
        setTitle("Arrecadação");
        setResizable(false);
        setLocationRelativeTo(null);
        //setBackground(MaterialColors.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        lblNomePrograma = new JLabel("Consultar arrecadação do dia:");
        lblNomePrograma.setBounds(10, 20, 180, 20);
        contentPanel.add(lblNomePrograma);

        textFieldDia = new JTextField();
        textFieldDia.setBounds(190, 20, 86, 26);
        contentPanel.add(textFieldDia);
        textFieldDia.setColumns(10);

        btnConsultar = new JButton("Consultar");
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if (textFieldDia.getText().isEmpty())
                        JOptionPane.showConfirmDialog(null,"Você não digitou o dia corretamente.", "Alerta", JOptionPane.DEFAULT_OPTION);
                    else {
                        String dia = textFieldDia.getText();
                        double valor = Fachada.calcularArrecadacao(Integer.parseInt(dia));
                        lblValorArrecadado.setText(Double.toString(valor));
                    }
                }
                catch(Exception erro){
                    JOptionPane.showConfirmDialog(null,erro.getMessage(), "Alerta", JOptionPane.DEFAULT_OPTION);
                }
            }
        });
        btnConsultar.setBounds(290, 20, 100, 24);
        contentPanel.add(btnConsultar);

        lblResultado = new JLabel("Valor arrecadado: R$");
        lblResultado.setBounds(10, 60, 130, 20);
        contentPanel.add(lblResultado);

        lblValorArrecadado = new JLabel("...");
        lblValorArrecadado.setBounds(lblResultado.getX() + lblResultado.getWidth() + 2, lblResultado.getY(), 30, 20);
        contentPanel.add(lblValorArrecadado);
    }
}
