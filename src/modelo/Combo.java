package modelo;

import java.util.ArrayList;

public class Combo extends Produto {
    private String nome;
    private ArrayList<Produto> componentes;

    public Combo () {
        // Empty
    }

    //@Override
    public Double getPreco(Double descontoCombo) {
        Double soma = 0.0;

        for(Produto p : componentes)
            soma += p.getPreco();

        return soma - (soma * descontoCombo);
    }
}
