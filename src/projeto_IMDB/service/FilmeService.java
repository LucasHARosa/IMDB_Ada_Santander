package projeto_IMDB.service;

import projeto_IMDB.dominio.Filme;
import projeto_IMDB.repository.FilmeRepository;

public class FilmeService {
    private FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
    }

    public void cadastrarFilme(Filme filme){
        if (validarData(filme.getDataLancamento())) {
            filmeRepository.cadastrarFilme(filme);
        } else {
            System.out.println("Data de lançamento inválida!");
        }
    }

    public Filme buscarFilme(String nome){
        return filmeRepository.buscarFilme(nome);
    }

    public boolean validarData(String dataLancamento){
        String parteNumerica = dataLancamento.replaceAll("[^0-9]", "");

        int dia = Integer.parseInt(parteNumerica.substring(0, 2));
        int mes = Integer.parseInt(parteNumerica.substring(2, 4));
        int ano = Integer.parseInt(parteNumerica.substring(4));

        boolean bissexto = (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);

        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (bissexto && mes == 2) {
            diasPorMes[2] = 29;
        }

        return dia >= 1 && dia <= diasPorMes[mes] && mes >= 1 && mes <= 12;
    }

}
