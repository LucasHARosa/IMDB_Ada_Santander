package projeto_IMDB.repository;

import projeto_IMDB.dominio.Ator;

import java.util.List;

public class AtorRepository {

    private List<Ator> atoresBanco;

    public Ator buscarAtorId(long id) {
        for (Ator ator : atoresBanco){
            if (ator.getId() == id){
                return ator;
            }
        }

        return null;
    }
}
