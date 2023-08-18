package projeto_IMDB.service;

import projeto_IMDB.dominio.Ator;
import projeto_IMDB.repository.AtorRepository;

public class AtorService {
    private AtorRepository atorRepository;

    public AtorService(AtorRepository atorRepository){
        this.atorRepository = atorRepository;
    }

    public Ator buscarAtorId(long id){
        return atorRepository.buscarAtorId(id);
    }
}
