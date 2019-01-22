package fachada;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;
import repositorio.Restaurante;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Fachada {
    private static Restaurante restaurante = new Restaurante();
    private static int nrPedido = 1;
    private static int nrProduto = 1;
    private static Double txEntrega = 10.00;

    // -------------------------------------
    //  LISTAR TODOS OS PRODUTOS OU PRODUTO ESPECIFICO POR NOME
    // -------------------------------------

    public static ArrayList<Produto> listarProdutos(String nome) {
        if (nome.isEmpty())
            return restaurante.getProdutos();

        return restaurante.localizarProdutos(nome);
    }

    // -------------------------------------
    //  LISTAR TODOS OS CLIENTES
    // -------------------------------------

    public static ArrayList<Cliente> listarClientes() {
        return restaurante.getClientes();
    }

    // -------------------------------------
    //  LISTAR TODOS OS PEDIDOS
    // -------------------------------------

    public static ArrayList<Pedido> listarPedidos() {
        return restaurante.getPedidos();
    }

    // -------------------------------------
    //  LISTAR PEDIDOS POR CLIENTE
    // -------------------------------------

    public static ArrayList<Pedido> listarPedidos(String telefone) throws Exception {
        Cliente c = restaurante.localizarCliente(telefone);
        if (c == null)
            throw new Exception("Cadastrar Cliente: Cliente não cadastrado.");

        ArrayList<Pedido> pedidos = restaurante.getPedidos();
        ArrayList<Pedido> ped = new ArrayList<Pedido>();

        if (!pedidos.isEmpty()) {
            for (Pedido p : pedidos)
                if (p.getCliente().getTelefone().equals(telefone))
                    ped.add(p);
        }
        return ped;
    }

    // -------------------------------------
    //  CADASTRAR PRODUTOS
    // -------------------------------------

    public static Produto cadastrarProduto(String nome, double preco) throws Exception{
        Produto p = restaurante.localizarProduto(nome);
        if (p != null) {
            throw new Exception("Cadastrar Produto: Produto já cadastrado: " + nome);
        }

        p = new Produto(nrProduto, nome, preco);
        if (restaurante.adicionar(p))
            nrProduto++;

        return p;
    }

    // -------------------------------------
    //  CADASTRAR CLIENTE
    // -------------------------------------

    public static Cliente cadastrarCliente(String telefone, String nome, String email, String endereco) throws Exception {
        Cliente c = restaurante.localizarCliente(telefone);
        if (c != null)
            throw new Exception("Cadastrar Cliente: Cliente já cadastrado.");

        c = new Cliente(telefone, nome, email, endereco);
        restaurante.adicionar(c);
        return c;
    }

    // -------------------------------------
    //  ABRIR PEDIDO
    // -------------------------------------

    public static Pedido abrirPedido(String telefone) throws Exception {
        Cliente c = restaurante.localizarCliente(telefone);
        if (c == null)
            throw new Exception("Abrir Pedido: Cliente não cadastrado.");

        Pedido p = restaurante.localizarPedidoAberto(telefone);
        if (p != null)
            throw new Exception("Abrir Pedido: O cliente já tem um pedido aberto.");

        p = new Pedido(nrPedido, c);
        if (restaurante.adicionar(p) != null) {
            nrPedido++;
            return p;
        }

        return null;
    }

    // -------------------------------------
    //  ADICIONAR PRODUTO AO PEDIDO
    // -------------------------------------

    public static void adicionarProdutoPedido(String telefone, int id_produto) throws Exception {
        Cliente c = restaurante.localizarCliente(telefone);
        if (c == null)
            throw new Exception("Adicionar Produto Pedido: Cliente não cadastrado.");

        Pedido p = restaurante.localizarPedidoAberto(telefone);
        if (p == null)
            throw new Exception("Adicionar Produto Pedido: Nenhum pedido aberto para este cliente.");

        Produto prod = restaurante.localizarProduto(id_produto);
        if (prod == null)
            throw new Exception("Adicionar Produto Pedido: Produto não cadastrado.");

        restaurante.adicionarProduto(p.getId(), prod);
    }

    public static void removerProdutoPedido(String telefone, int id) {
        //
    }

    // -------------------------------------
    //  CONSULTAR PEDIDO
    // -------------------------------------

    public static Pedido consultarPedido(String telefone) throws Exception {
        Cliente c = restaurante.localizarCliente(telefone);
        if (c == null) {
            throw new Exception("Cliente não cadastrado.");
        }

        return restaurante.localizarPedidoAberto(telefone);
    }

    // -------------------------------------
    //  CANCELAR PEDIDO
    // -------------------------------------

    public static Pedido cancelarPedido(String telefone) throws Exception {
        Cliente c = restaurante.localizarCliente(telefone);
        if (c == null)
            throw new Exception("Cancelar Pedido: Cliente não cadastrado.");

        Pedido p = restaurante.localizarPedidoAberto(telefone);
        if (p == null)
            throw new Exception("Cancelar Pedido: Não há pedido aberto para este cliente.");

        return restaurante.remover(p);
    }

    // -------------------------------------
    //  FECHAR PEDIDO
    // -------------------------------------

    public static void fecharPedido(String telefone, String entregador) throws Exception {
        Cliente c = restaurante.localizarCliente(telefone);
        if (c == null)
            throw new Exception("Fechar Pedido: Cliente não cadastrado.");

        Pedido p = restaurante.localizarPedidoAberto(telefone);
        if (p != null)
            restaurante.fecharPedido(p.getId(), entregador, txEntrega);
        else
            System.out.println("Fechar Pedido: Não há pedido aberto para o cliente " + telefone);
    }

    public static void enviarPedido(String telefone, String email) {
        //
    }

    // -------------------------------------
    //  CALCULAR ARRECADAÇÃO
    // -------------------------------------

    public static double calcularArrecadacao(int dia) {
        double arrecadacao = 0.0;

        ArrayList<Pedido> pedidos = restaurante.getPedidos();
        for (Pedido p : pedidos)
            if (p.getData().getDayOfMonth() == dia)
                arrecadacao += p.getTotal();

        return arrecadacao;
    }
}
