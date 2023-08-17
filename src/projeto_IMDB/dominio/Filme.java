package projeto_IMDB.dominio;

public class Filme extends FilmeAbstract{
    private String nome;

    public Filme(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome;
    }
}
