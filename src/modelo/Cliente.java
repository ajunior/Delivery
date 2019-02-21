package modelo;

import java.util.ArrayList;

public class Cliente {
    private String telefone;
    private String nome;
    private String email;
    private String endereco;
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public Cliente () {
        // Empty
    }

    public Cliente (String telefone, String nome, String email, String endereco) {
        this.telefone = telefone;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getNome () {
        return this.nome;
    }

    public void setTelefone (String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone () {
        return this.telefone;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getEmail () {
        return this.email;
    }

    public void setEndereco (String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco () {
        return this.endereco;
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
        return this.nome + ' ' + this.telefone + ' ' + this.email + ' ' + this.endereco + ' ' + this.pedidos.size();
    }
}
