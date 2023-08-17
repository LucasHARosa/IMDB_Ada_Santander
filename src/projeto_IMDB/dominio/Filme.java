package projeto_IMDB.dominio;

import java.util.ArrayList;

public class Filme extends FilmeAbstract{
    private String nome;
    private double notaElenco;
    private double notaIMDB;
    private double tempoProducao;
    private ArrayList<Ator> atores;
    private ArrayList<Diretor> diretores;

    public Filme(String nome, double tempoProducao) {
        this.nome = nome;
        this.tempoProducao = tempoProducao;
        this.notaElenco=0;
        this.notaIMDB=0;
        this.diretores = new ArrayList<>();
        this.atores = new ArrayList<>();
    }


    // arumar isso para listar todas as informações
    @Override
    public String toString() {
        return "Nome: " + nome;
    }
}
