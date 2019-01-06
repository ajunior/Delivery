package fachada;

import common.Cliente;
import common.Pedido;
import common.Produto;
import common.Restaurante;

public class Fachada {
    private static Cliente     cliente     = new Cliente();
    private static Pedido      pedido      = new Pedido();
    private static Produto     produto     = new Produto();
    private static Restaurante restaurante = new Restaurante();

    public void iniciaRestaurante() {
        cliente = new Cliente();
        produto = new Produto();


    }
}
