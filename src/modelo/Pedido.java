package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;

public class Pedido {
    private int id;
    private LocalDateTime data;
    private double total;
    private String entregador;
    private boolean fechado;
    private ArrayList<Produto> produtos;
    private Cliente cliente;

    public Pedido () {
        // Empty
    }

    public Pedido (int id, Cliente cliente) {
        this.id = id;
        this.data = LocalDateTime.now();
        this.fechado = false;
        this.cliente = cliente;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getId () {
        return this.id;
    }

    //public void setData (LocalDateTime data) {
    //    this.data = data;
    //}

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

    public void setFechado () {
        this.fechado = true;
    }

    public Boolean getFechado () {
        return this.fechado;
    }

    public void addProduto (Produto p) {
        this.produtos.add(p);
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
        return "" + this.id + ' ' + this.data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + ' ' + this.total + ' ' + this.entregador + ' ' + this.fechado;
    }
}
