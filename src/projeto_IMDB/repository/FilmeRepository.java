package projeto_IMDB.repository;

import projeto_IMDB.dominio.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeRepository {
    private List<Filme> filmeBanco;

    public FilmeRepository() {
        this.filmeBanco = new ArrayList<>();
    }

    public void cadastrarFilme(Filme filme){
        this.filmeBanco.add(filme);
    }

    private List<Filme> listarFilmes(){
        return filmeBanco;
    }

    private void deletarFilme(){}

    public Filme buscarFilme(String nome) {
        for (Filme filme : filmeBanco){
            if (filme.getNome().equals(nome)){
                return filme;
            }
        }

        return null;
    }
}
