package projeto_IMDB.controller;

import projeto_IMDB.controller.views.AtorView;
import projeto_IMDB.controller.views.DiretorView;
import projeto_IMDB.controller.views.FilmeView;
import projeto_IMDB.dominio.Ator;
import projeto_IMDB.dominio.Diretor;
import projeto_IMDB.dominio.Filme;
import projeto_IMDB.service.AtorService;
import projeto_IMDB.service.DiretorService;
import projeto_IMDB.service.FilmeService;
import projeto_IMDB.utils.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class MenuController {

    private FilmeService filmeService;
    private AtorService atorService;
    private DiretorService diretorService;

    public MenuController(FilmeService filmeService, AtorService atorService, DiretorService diretorService){
        this.filmeService = filmeService;
        this.atorService = atorService;
        this.diretorService = diretorService;
    }

    public void menu(){
        System.out.println("Menu de operações");
        System.out.println("____________________________________");
        System.out.println( "1) Cadastro de Filmes\n" +
                            "2) Cadastro de atores\n" +
                            "3) Cadastro de diretores\n" +
                            "4) Listar Filmes\n" +
                            "5) Listar Atores\n" +
                            "6) Listar Diretores\n" +
                            "7) Adicionar um ator ao filme\n" +
                            "8) Adicionar um filme ao ator\n" +
                            "9) Adicionar um filme ao diretor\n" +
                           "10) Pesquisar filme pelo nome\n" +
                            "0) Encerrar aplicativo");
        System.out.println("____________________________________");
    }

    public void operacaoARealizar(int operacao){

        switch (operacao){
            case 1:
                FilmeView.cadastrarFilmes(filmeService, atorService, diretorService);
                break;
            case 2:
                AtorView.cadastrarAtor(atorService);
                break;
            case 3:
                DiretorView.cadastrarDiretor(diretorService);
                break;
            case 4:
                FilmeView.listarFilmes(filmeService);
                break;
            case 5:
                AtorView.listarAtores(atorService);
                break;
            case 6:
                DiretorView.listarDiretores(diretorService);
                break;

            case 7:
                FilmeView.adicionarAtorAoFilme(atorService, filmeService);
                break;
            case 8:
                //adicionarAtorEmFilme();
                AtorView.adicionarFilmeAoAtor(atorService, filmeService);
                break;
            case 9:
                //adicionarDiretorEmFilme();
                break;
            case 10:
                FilmeView.pesquisarFilmePorNome(filmeService);
                break;
            case 0:
                break;
            default:
                System.out.println("Valor inválido");
                break;
        }
    }
}
