package ui;

import fachada.Fachada;
import modelo.Produto;
import modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

    public MainFrame () {
        super("Delivery");

        // Pré-cadastro
        preCadastro();

        //  Configuração da Janela principal da aplicação.
        setLayout(new FlowLayout());
        setSize(1080, 768);
        setMaximumSize(new Dimension( 1080, 768));
        setMinimumSize(new Dimension(1080, 768));
        setLocationRelativeTo(null);
        setResizable(false);
        setJMenuBar(criarMenu());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // -----------------------------------------------------
    // MENU
    // -----------------------------------------------------

    private JMenuBar criarMenu() {
        JMenuBar menuBar = new JMenuBar();

        // MENU APLICATIVO
        JMenu menuApp = new JMenu("Aplicativo");

        JMenuItem menuAppSair = new JMenuItem("Sair");
        menuApp.add(menuAppSair);
        menuBar.add(menuApp);
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

        // MENU CLIENTE
        JMenu menuCliente = new JMenu("Cliente");
        JMenuItem menuClienteCadastrar = new JMenuItem("Cadastrar");
        menuCliente.add(menuClienteCadastrar);
        menuClienteCadastrar.setMnemonic(KeyEvent.VK_C);
        menuClienteCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastrarClienteFrame().setVisible(true);
            }
        });

        JMenuItem menuClienteListar = new JMenuItem("Listar");
        menuCliente.add(menuClienteListar);
        menuBar.add(menuCliente);
        menuClienteListar.setMnemonic(KeyEvent.VK_L);
        menuClienteListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListarClientesFrame().setVisible(true);
            }
        });

        // MENU PRODUTO
        JMenu menuProduto = new JMenu("Produto");
        JMenuItem menuProdutoCadastrar = new JMenuItem("Cadastrar");
        menuProduto.add(menuProdutoCadastrar);
        menuProdutoCadastrar.setMnemonic(KeyEvent.VK_C);
        menuProdutoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastrarProdutoFrame().setVisible(true);
            }
        });

        JMenuItem menuProdutoListar = new JMenuItem("Listar");
        menuProduto.add(menuProdutoListar);
        menuBar.add(menuProduto);
        menuProdutoListar.setMnemonic(KeyEvent.VK_L);
        menuProdutoListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListarProdutosFrame().setVisible(true);
            }
        });

        // MENU PEDIDO
        JMenu menuPedido = new JMenu("Pedido");
        JMenuItem menuPedidoAbrir = new JMenuItem("Abrir Pedido");
        menuPedido.add(menuPedidoAbrir);
        menuPedidoAbrir.setMnemonic(KeyEvent.VK_A);
        menuPedidoAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AbrirPedidoFrame().setVisible(true);
            }
        });

        JMenuItem menuPedidoAdicionarProduto = new JMenuItem("Adcionar Produto");
        menuPedido.add(menuPedidoAdicionarProduto);

        JMenuItem menuPedidoRetirarProduto = new JMenuItem("Retirar Produto");
        menuPedido.add(menuPedidoRetirarProduto);

        JMenuItem menuPedidoListar = new JMenuItem("Listar Pedidos");
        menuPedido.add(menuPedidoListar);
        menuPedidoListar.setMnemonic(KeyEvent.VK_L);
        menuPedidoListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListarPedidosFrame().setVisible(true);
            }
        });

        JMenuItem menuPedidoListarPorCliente = new JMenuItem("Listar Pedidos por cliente");
        menuPedido.add(menuPedidoListarPorCliente);
        menuPedidoListarPorCliente.setMnemonic(KeyEvent.VK_E);
        menuPedidoListarPorCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListarPedidosPorClienteFrame().setVisible(true);
            }
        });

        JMenuItem menuPedidoConsultar = new JMenuItem("Consultar");
        menuPedido.add(menuPedidoConsultar);
        menuPedidoConsultar.setMnemonic(KeyEvent.VK_C);
        menuPedidoConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultarPedidoFrame().setVisible(true);
            }
        });

        JMenuItem menuPedidoCancelar = new JMenuItem("Cancelar");
        menuPedido.add(menuPedidoCancelar);
        menuPedidoCancelar.setMnemonic(KeyEvent.VK_R);
        menuPedidoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CancelarPedidoFrame().setVisible(true);
            }
        });

        JMenuItem menuPedidoFechar = new JMenuItem("Fechar");
        menuPedido.add(menuPedidoFechar);
        menuBar.add(menuPedido);
        menuPedidoFechar.setMnemonic(KeyEvent.VK_F);
        menuPedidoFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FecharPedidoFrame().setVisible(true);
            }
        });

        // MENU RELATÓRIO
        JMenu menuRelatorio = new JMenu("Relatório");
        JMenuItem menuRelatorioArrecadacao = new JMenuItem("Arrecadação");
        menuRelatorio.add(menuRelatorioArrecadacao);
        menuBar.add(menuRelatorio);
        menuRelatorioArrecadacao.setMnemonic(KeyEvent.VK_A);
        menuRelatorioArrecadacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ArrecadacaoFrame().setVisible(true);
            }
        });

        // MENU AJUDA
        JMenu menuAjuda = new JMenu("Ajuda");

        JMenuItem menuAjudaSobre = new JMenuItem("Sobre");
        menuAjuda.add(menuAjudaSobre);
        menuBar.add(menuAjuda);
        menuAjudaSobre.setMnemonic(KeyEvent.VK_S);
        menuAjudaSobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SobreFrame().setVisible(true);
            }
        });

        return menuBar;
    }

    // -----------------------------------------------------
    // PRÉ-CADASTRO
    // -----------------------------------------------------

    private static void preCadastro() {
        try {

            Produto p;
            p = Fachada.cadastrarProduto("Pepsi 2L", 6.00);
            p = Fachada.cadastrarProduto("Guaraná Antarctica 2L", 7.00);
            p = Fachada.cadastrarProduto("Coca-Cola 2L", 8.20);
            p = Fachada.cadastrarProduto("Coca-Cola Lata 300ml", 3.50);
            p = Fachada.cadastrarProduto("Pizza Grande - 4 Queijos", 27.90);
            Cliente c;
            c = Fachada.cadastrarCliente("999440111", "Adjamilton Junior", "jr@ieee.org", "Rua Pero Vaz de Caminha 455, 13 de Maio.");
            c = Fachada.cadastrarCliente("988756525", "Deborah Felix", "debh@gmail.com", "Av. Epitacio Pessoa 4096, Tambauzinho");
            Fachada.abrirPedido("999440111");
            System.out.println("pre-cadastro concluido");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
