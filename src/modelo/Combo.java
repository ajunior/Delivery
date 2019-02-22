package modelo;

import java.util.ArrayList;

public class Combo extends Produto {
    private String nome;
    private ArrayList<Produto> componentes = new ArrayList<>();

    public Combo () {
        // Empty
    }

    public Combo (String nome) {
        this.nome = nome;
    }

    public Combo(String nome, ArrayList<Produto> p) {
        this.nome = nome;
        this.componentes = p;
    }

    public void adicionarComponente(Produto p) {
        componentes.add(p);
    }


    public ArrayList<Produto> getComponentes() {
        return componentes;
    }


    public Double getPreco() {
        Double valor =  super.getPreco();
        return valor - (valor * 0.10);
    }


    @Override
    public String toString() {
        return "Combo [componentes=" + componentes + " Preço= "+ getPreco() + "]";
    }
}