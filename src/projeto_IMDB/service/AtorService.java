package projeto_IMDB.service;

import projeto_IMDB.dominio.Ator;
import projeto_IMDB.repository.AtorRepository;

import java.util.List;

public class AtorService {
    private AtorRepository atorRepository;

    public AtorService(AtorRepository atorRepository){
        this.atorRepository = atorRepository;
    }

    public Ator buscarAtorId(long id){
        return atorRepository.buscarAtorId(id);
    }

    public void cadastrarAtor(Ator ator){
        try {
            atorRepository.cadastrarAtor(ator);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Informação inválida!");
        }
    }

    public List<Ator> listarAtores(){
        return atorRepository.listarAtores();
    }

    public boolean deletarAtor(long id){
        try {
            atorRepository.deletarAtor(id);
            return true;
        } catch (RuntimeException e){

        }
        return false;
    }
}
