package repositorio;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;
import modelo.SortByProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Restaurante {
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    //private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private TreeMap<String, Cliente> clientes = new TreeMap<String, Cliente>();

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
        Collections.sort(produtos, new SortByProduct());
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
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    public ArrayList<Produto> localizarProdutos(String nome){
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        for(Produto p : this.produtos){
            if(p.getNome().toLowerCase().contains(nome.toLowerCase()))
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

    public Cliente adicionar(Cliente c) {
        return clientes.put(c.getTelefone(), c);
    }

    public TreeMap<String, Cliente> getClientes() {
        return clientes;
    }

    public Cliente localizarCliente(String telefone){
        for (Cliente c : clientes.values()) {
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

    public Pedido remover(Pedido p) {
        if (!p.getFechado()) {
            this.produtos.remove(p);
            return p;
        }

        return null;
    }

    public Pedido localizarPedido(int id) {
        for (Pedido p : pedidos) {
            if(p.getId() == id && p.getFechado())
                return p;
        }
        return null;
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
        double valor = txEntrega;

        for (Pedido p: pedidos)
            if (p.getId() == id) {
                p.setFechado();
                p.setEntregador(entregador);
                p.setTotal(valor);
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
