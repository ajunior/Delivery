package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SobreFrame extends JDialog {
    private JLabel lblInstituicao;
    private JLabel lblDisciplina;
    private JLabel lblPeriodo;
    private JLabel lblProfessor;
    private JLabel lblAluno;
    private JPanel contentPanel;

    public SobreFrame() {
        setLayout(new FlowLayout());
        setTitle("Sobre...");
        setModal(true);
        setSize(400, 160);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        lblInstituicao = new JLabel("Instituto Federal da Paraíba");
        lblInstituicao.setBounds(10, 10, 380, 20);
        contentPanel.add(lblInstituicao);

        lblDisciplina = new JLabel("Disciplina: Programação Orientada a Objetos");
        lblDisciplina.setBounds(10, 30, 380, 20);
        contentPanel.add(lblDisciplina);

        lblPeriodo = new JLabel("Período: 2018.2");
        lblPeriodo.setBounds(10, 50, 380, 20);
        contentPanel.add(lblPeriodo);

        lblProfessor = new JLabel("Profesor: Fausto Aires");
        lblProfessor.setBounds(10, 70, 380, 20);
        contentPanel.add(lblProfessor);

        lblAluno = new JLabel("Estudante: Adjamilton Junior (jr@ieee.org)");
        lblAluno.setBounds(10, 90, 380, 20);
        contentPanel.add(lblAluno);
    }
}
