import projeto_IMDB.controller.Entrada;
import projeto_IMDB.controller.MenuController;
import projeto_IMDB.controller.views.FilmeView;
import projeto_IMDB.dominio.Ator;
import projeto_IMDB.dominio.Diretor;
import projeto_IMDB.dominio.Filme;
import projeto_IMDB.repository.AtorRepository;
import projeto_IMDB.repository.DiretorRepository;
import projeto_IMDB.repository.FilmeRepository;
import projeto_IMDB.service.AtorService;
import projeto_IMDB.service.DiretorService;
import projeto_IMDB.service.FilmeService;
import projeto_IMDB.utils.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private MenuController menuController;
    public static void main(String[] args) {
        FilmeRepository filmeRepository = new FilmeRepository();
        AtorRepository atorRepository = new AtorRepository();
        DiretorRepository diretorRepository = new DiretorRepository();

        FilmeService filmeService = new FilmeService(filmeRepository);
        AtorService atorService = new AtorService(atorRepository);
        DiretorService diretorService = new DiretorService(diretorRepository);

        MenuController menuController = new MenuController(filmeService, atorService, diretorService);

        System.out.println("BEM VINDO AO IMDB DO GRUPO 5");
        int opcao;

        do {
            System.out.println("");
            menuController.menu();
            opcao = InputHandler.getIntInput("Qual a opcao desejada? ");
            System.out.println("");
            menuController.operacaoARealizar(opcao);
        } while (opcao != 0);
    }

    /*public void teste(){
        //Teste, desconsiderar
        System.out.println("Hello world!");
        Filme filme01 = new Filme(
                "star wars",
                "15/02/1971",
                79000,
                "Primeiro filme da trilogia.",
                3, new ArrayList<>()
        );
        System.out.println(filme01);
        Filme filme02 = new Filme(
                "star wars2",
                "29/05/1973",
                85600,
                "Segundo filme da trilogia.",
                2, new ArrayList<>()
        );
        Ator ator01 = new Ator("jeorge","masculino",12,10,1500);
        ator01.addFilme(filme01);
        System.out.println(ator01.toString());
        ator01.addFilme(filme02);
        System.out.println(ator01.toString());

        Ator ator02 = new Ator("Carla", "feminino", 11, 9.75, 1975);
        ator02.addFilme(filme02);
        System.out.println(ator02.toString());

        Diretor diretor01 = new Diretor(
                "Raimundo", "" +
                "masculino",
                17,
                9.75,
                "Filmografia"
        );
        diretor01.addFilme(filme02);
        System.out.println(diretor01.toString());

        List<Ator> listaAtoresFilme02 = new ArrayList<>();
        listaAtoresFilme02.add(ator01);
        listaAtoresFilme02.add(ator02);

        filme02.setAtores(listaAtoresFilme02);

        filme02.setDiretor(diretor01);
        // TODO resolver: Exception in thread "main" java.lang.StackOverflowError
        // Esse último println está dando esse erro que parece ser por causa de recursividade.
        // Acredito que teria que mexer nas estidades Ator e Filme para guardarem apenas os IDs.
        System.out.println(filme02);
    }*/
}