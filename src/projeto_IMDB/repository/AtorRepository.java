package projeto_IMDB.repository;

import projeto_IMDB.dominio.Ator;

import java.util.ArrayList;
import java.util.List;

public class AtorRepository {

    private List<Ator> atoresBanco;

    public AtorRepository() {
        this.atoresBanco = new ArrayList<>();
    }

    public Ator buscarAtorId(long id) {
        for (Ator ator : atoresBanco){
            if (ator.getId() == id){
                return ator;
            }
        }

        return null;
    }

    public void cadastrarAtor(Ator ator){
        this.atoresBanco.add(ator);
    }

    public boolean deletarAtor(long id){
        if(atoresBanco.get((int)id) != null){
            atoresBanco.remove(buscarAtorId(id));
            return true;
        }

        return false;
    }

    public List<Ator> listarAtores(){
        return atoresBanco;
    }

}
