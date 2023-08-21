package projeto_IMDB.repository;

import projeto_IMDB.dominio.Ator;
import projeto_IMDB.dominio.Diretor;
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

    public List<Filme> listarFilmes(){
        return filmeBanco;
    }

    public void deletarFilme(long id){
        Filme filme = buscarFilmeId(id);

        if (filme != null) {
            filmeBanco.remove(filme);
            System.out.println("Filme removido com sucesso!");
        } else {
            System.out.println("Filme não encontrado, a remoção não pôde ser concluída!");
        }
    }

    public Filme buscarFilmeId(long id) {
        for (Filme filme : filmeBanco){
            if (filme.getId() == id){
                return filme;
            }
        }

        return null;
    }

    public Filme buscarFilme(String nome) {
        for (Filme filme : filmeBanco){
            if (filme.getNome().equalsIgnoreCase(nome)){
                return filme;
            }
        }

        return null;
    }

    public boolean buscarAtor(Ator ator, Filme filme) {
        return filme.getAtores().contains(ator);
    }

    public boolean buscarDiretor(Diretor diretor, Filme filme){
        return filme.getDiretores().contains(diretor);
    }
}
