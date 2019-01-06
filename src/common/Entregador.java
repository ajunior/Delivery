package common;

public class Entregador {
    private String nome;

    public Entregador () {
        //
    }

    public Entregador (String nome) {
        this.nome = nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getNome () {
        return this.nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
