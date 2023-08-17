package projeto_IMDB.dominio;

import java.util.ArrayList;

public class Person {
    private String nome;
    private String sexo;
    private int anosDeCarreira;
    private double prestigio;
    private ArrayList<Filme> filmes;

    public Person(String nome, String sexo, int anosDeCarreira, double prestigio) {
        this.nome = nome;
        this.sexo = sexo;
        this.anosDeCarreira = anosDeCarreira;
        this.prestigio = prestigio;
        this.filmes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public int getAnosDeCarreira() {
        return anosDeCarreira;
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public double getPrestigio() {
        return prestigio;
    }

    public void addFilme(Filme filme){
        filmes.add(filme);
    }

}
