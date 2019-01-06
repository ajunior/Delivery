package common;

public class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;

    public Cliente () {
        // Empty
    }

    public Cliente (String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
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

    @Override
    public String toString () {
        return this.nome + ' ' + this.telefone + ' ' + this.email + ' ' + this.endereco;
    }
}
