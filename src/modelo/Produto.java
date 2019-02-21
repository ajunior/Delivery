package modelo;

import java.util.ArrayList;

public class Produto {
    private int id;
    private String nome;
    private Double preco;
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public Produto () {
        // Empty
    }

    public Produto (int id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getId () {
        return this.id;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getNome () {
        return this.nome;
    }

    public void setPreco (Double preco) {
        this.preco = preco;
    }

    public Double getPreco () {
        return this.preco;
    }

    public void addPedido (Pedido p) {
        pedidos.add(p);
    }

    public void delPedido (Pedido p) {
        pedidos.remove(p);
    }

    public int getQtdePedidos() {
        return pedidos.size();
    }

    @Override
    public String toString () {
        return this.id + " " + this.nome + " " + this.preco;
    }
}
