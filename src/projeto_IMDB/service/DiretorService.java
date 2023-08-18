package projeto_IMDB.service;

import projeto_IMDB.dominio.Ator;
import projeto_IMDB.dominio.Diretor;
import projeto_IMDB.dominio.Filme;
import projeto_IMDB.repository.AtorRepository;
import projeto_IMDB.repository.DiretorRepository;

import java.util.List;

public class DiretorService {
    private DiretorRepository diretorRepository;

    public DiretorService(DiretorRepository diretorRepository){
        this.diretorRepository = diretorRepository;
    }

    public Diretor buscarDiretorId(long id){
        return diretorRepository.buscarDiretorId(id);
    }

    public void cadastrarDiretor(Diretor diretor){
        try {
            diretorRepository.cadastrarDiretor(diretor);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Informação inválida!");
        }
    }

    public List<Diretor> listarDiretores(){
        return diretorRepository.listarDiretores();
    }

    public boolean deletarDiretor(long id){
        try {
            diretorRepository.deletarDiretor(id);
            return true;
        } catch (RuntimeException e){
            return false;
        }
    }

    /*public void adicionarFilmeAoDiretor(Diretor diretor, Filme filme, FilmeService filmeService){
        boolean adicionar = false;
        for (Filme filmeLista: filmeService.listarFilmes()) {
                if (diretor.equals(filmeLista.getDiretor())){
                    adicionar = false;
                } else {
                    adicionar = true;
                }

        }
        if (adicionar){
            //diretorRepository.adicionarFilmeAoAtor(ator, filme);
        }
    }*/

    public List<Filme> listarFilmesDoDiretor(long diretorId){
        return buscarDiretorId(diretorId).getFilmes();
    }
}
