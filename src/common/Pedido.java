package common;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido {
    private int id;
    private LocalDateTime data;
    private Double total;
    private String entregador;
    private Boolean fechado;
    private ArrayList<Produto> produtos;
    private Cliente cliente;

    public Pedido () {
        // Empty
    }

    public Pedido (int id, LocalDateTime data, Double total, String entregador, Boolean fechado,
                   ArrayList<Produto> produtos, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.total = total;
        this.entregador = entregador;
        this.fechado = fechado;
        this.produtos = produtos;
        this.cliente = cliente;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getId () {
        return this.id;
    }

    public void setData (LocalDateTime data) {
        this.data = data;
    }

    public LocalDateTime getData () {
        return this.data;
    }

    public void setTotal (Double total) {
        this.total = total;
    }

    public Double getTotal () {
        return this.total;
    }

    public void setEntregador (String entregador) {
        this.entregador = entregador;
    }

    public String getEntregador () {
        return this.entregador;
    }

    public void setFechado (Boolean fechado) {
        this.fechado = fechado;
    }

    public Boolean getFechado () {
        return this.fechado;
    }

    public void setProdutos (ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<Produto> getProdutos () {
        return this.produtos;
    }

    public void setCliente (Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente () {
        return this.cliente;
    }

    @Override
    public String toString () {
        //return this.id + ' ' + this.data + ' ' + this.total + ' ' + this.entregador + ' ' + this.fechado;
        return "teste";
    }
}
