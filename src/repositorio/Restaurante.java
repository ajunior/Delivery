package repositorio;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;
import fachada.Fachada;

import java.util.ArrayList;

public class Restaurante {
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Restaurante() {
        // Empty
    }

    // -------------------------------------
    // PRODUTOS
    // -------------------------------------

    public boolean adicionar(Produto p) {
        return this.produtos.add(p);
    }

    public void remover(Produto p) {
        this.produtos.remove(p);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public Produto localizarProduto(String nome){
        for(Produto p : produtos){
            if(p.getNome().equals(nome))
                return p;
        }
        return null;
    }

    public Produto localizarProduto(int id){
        for(Produto p : produtos) {
            if (p.getId() == id) {
                System.out.println("---" + p);
                return p;
            }
        }
        return null;
    }

    public ArrayList<Produto> localizarProdutos(String nome){
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        for(Produto p : this.produtos){
            if(p.getNome().contains(nome))
                produtos.add(p);
        }
        return produtos;
    }

    public int qtdeProdutos() {
        return this.produtos.size();
    }

    // -------------------------------------
    // CLIENTES
    // -------------------------------------

    public void adicionar(Cliente c) {
        this.clientes.add(c);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente localizarCliente(String telefone){
        for (Cliente c : clientes) {
            if(c.getTelefone().equals(telefone))
                return c;
        }
        return null;
    }

    public int qtdeClientes() {
        return this.clientes.size();
    }

    // -------------------------------------
    // PEDIDOS
    // -------------------------------------

    public Pedido adicionar(Pedido p) {
        this.pedidos.add(p);
        return p;
    }

    public boolean remover(Pedido p) {
        if (!p.getFechado())
            return this.produtos.remove(p);

        return false;
    }

    public Pedido localizarPedidoAberto(String telefone) {
        for (Pedido p : pedidos) {
            if(p.getCliente().getTelefone().equals(telefone) && !p.getFechado())
                return p;
        }
        return null;
    }

    public Produto adicionarProduto(int id_pedido, Produto produto) {
        for (Pedido p: pedidos) {
            if (p.getId() == id_pedido) {
                p.addProduto(produto);
                return produto;
            }
        }

        return null;
    }

    public Pedido fecharPedido(int id, String entregador, double txEntrega) {
        double valor = 0.0;

        for (Pedido p: pedidos)
            if (p.getId() == id) {
                p.setFechado();
                p.setEntregador(entregador);
                p.setTotal(valor + txEntrega);
                return p;
            }
        return null;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public int qtdePedidos() {
        return this.pedidos.size();
    }
}