package ui;

import mdlaf.*;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

    public MainFrame () {
        super("Delivery");

        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e){
            e.printStackTrace();
        }

        //  Configuração da Janela principal da aplicação.
        setLayout(new FlowLayout());
        setSize(1080, 768);
        setMaximumSize(new Dimension( 1080, 768));
        setMinimumSize(new Dimension(1080, 768));
        setBackground(MaterialColors.WHITE);
        setJMenuBar(criarMenu());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar criarMenu() {
        JMenuBar menuBar = new JMenuBar();

        // MENU APLICATIVO
        JMenu menuApp = new JMenu("Aplicativo");
        JMenuItem menuAppConfig = new JMenuItem("Configurações");
        menuApp.add(menuAppConfig);

        JMenuItem menuAppSair = new JMenuItem("Sair");
        menuAppSair.setMnemonic(KeyEvent.VK_S);
        menuAppSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(MainFrame.this,
                        "Tem certeza que deseja sair da aplicação?",
                        "Confirmação",
                        JOptionPane.OK_CANCEL_OPTION);

                if (action == JOptionPane.OK_OPTION)
                    System.exit(0);
            }
        });
        menuApp.add(menuAppSair);

        menuBar.add(menuApp);

        // MENU CLIENTE
        JMenu menuCliente = new JMenu("Cliente");
        JMenuItem menuClienteCadastrar = new JMenuItem("Cadastrar");
        menuCliente.add(menuClienteCadastrar);
        JMenuItem menuClienteListar = new JMenuItem("Listar");
        menuCliente.add(menuClienteListar);
        menuBar.add(menuCliente);

        // MENU PRODUTO
        JMenu menuProduto = new JMenu("Produto");
        JMenuItem menuProdutoCadastrar = new JMenuItem("Cadastrar");
        menuProduto.add(menuProdutoCadastrar);
        JMenuItem menuProdutoListar = new JMenuItem("Listar");
        menuProduto.add(menuProdutoListar);
        menuBar.add(menuProduto);

        // MENU PEDIDO
        JMenu menuPedido = new JMenu("Pedido");
        JMenuItem menuPedidoCadastrar = new JMenuItem("Cadastrar Pedido");
        menuPedido.add(menuPedidoCadastrar);
        JMenuItem menuPedidoListar = new JMenuItem("Listar");
        menuPedido.add(menuPedidoListar);
        JMenuItem menuPedidoListarPorCliente = new JMenuItem("Listar por cliente");
        menuPedido.add(menuPedidoListarPorCliente);
        JMenuItem menuPedidoConsultar = new JMenuItem("Consultar");
        menuPedido.add(menuPedidoConsultar);
        JMenuItem menuPedidoCancelar = new JMenuItem("Cancelar");
        menuPedido.add(menuPedidoCancelar);
        JMenuItem menuPedidoFechar = new JMenuItem("Fechar");
        menuPedido.add(menuPedidoFechar);
        menuBar.add(menuPedido);

        // MENU RELATÓRIO
        JMenu menuRelatorio = new JMenu("Relatório");
        JMenuItem menuRelatorioArrecadacao = new JMenuItem("Arrecadação");
        menuRelatorio.add(menuRelatorioArrecadacao);
        menuBar.add(menuRelatorio);

        // MENU AJUDA
        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem menuAjudaAjuda = new JMenuItem("Ajuda");
        menuAjuda.add(menuAjudaAjuda);
        JMenuItem menuAjudaSobre = new JMenuItem("Sobre");
        menuAjuda.add(menuAjudaSobre);
        menuBar.add(menuAjuda);

        return menuBar;
    }
}
