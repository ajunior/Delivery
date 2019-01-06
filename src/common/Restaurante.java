package common;

import java.util.ArrayList;

public class Restaurante {
    private ArrayList<Produto> produtos;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Cliente> clientes;

    public Restaurante () {
        // Empty
    }

    public Restaurante (ArrayList<Produto> produtos, ArrayList<Pedido> pedidos, ArrayList<Cliente> clientes) {
        this.produtos = produtos;
        this.pedidos = pedidos;
        this.clientes = clientes;
    }

    public void setProdutos (ArrayList<Produto> produtos) {

    }
}
