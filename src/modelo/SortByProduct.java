package modelo;

import java.util.Comparator;

public class SortByProduct implements Comparator<Produto> {
    public int compare (Produto p1, Produto p2) {
        return p1.getNome().compareToIgnoreCase(p2.getNome());
    }
}
