package projeto_IMDB.controller.views;

import projeto_IMDB.controller.Entrada;
import projeto_IMDB.dominio.Ator;
import projeto_IMDB.dominio.Diretor;
import projeto_IMDB.dominio.Filme;
import projeto_IMDB.service.AtorService;
import projeto_IMDB.service.DiretorService;
import projeto_IMDB.service.FilmeService;

public class AtorView {
    public static void cadastrarAtor(AtorService atorService){
        System.out.println("---- Cadastro de Atores ----");
        System.out.print("Nome: ");
        String nome = Entrada.getStringNextLine();

        System.out.print("Sexo: ");
        String sexo = Entrada.getStringNextLine();

        System.out.print("Anos de Carreira: ");
        int anosCarreira = Entrada.getInt();

        System.out.print("Prestigio (0-10): ");
        double prestigio = Entrada.getDouble();
        if(prestigio < 0){
            prestigio = 0;
        } else if (prestigio > 10) {
            prestigio = 10;
        }

        System.out.print("Cache: R$ ");
        double cache = Entrada.getDouble();

        Ator atorNovo = new Ator(nome, sexo, anosCarreira, prestigio, cache);
        atorService.cadastrarAtor(atorNovo);

        System.out.println("Ator cadastrado com sucesso!");
    }

    public static void listarAtores(AtorService atorService){
        if (atorService.listarAtores().equals(null) || atorService.listarAtores().isEmpty()){
            System.out.println("Nenhum ator cadastrado!");
        } else {
            System.out.println("Atores cadastrados no sistema: \n");
            for (Ator ator:atorService.listarAtores()) {
                System.out.println(ator);
            }
        }
    }

    public static void adicionarFilmeAoAtor(AtorService atorService, FilmeService filmeService){
        if (atorService.listarAtores().isEmpty() || atorService.listarAtores().equals(null)){
            System.out.println("Nenhum ator cadastrado!");
        } else if (filmeService.listarFilmes().isEmpty() || filmeService.listarFilmes().equals(null)) {
            System.out.println("Nenhum filme cadastrado!");
        } else {
            System.out.println("---- Associação de Atores e Filmes ----");
            System.out.println("Lista de filmes: ");
            for (Filme filme:filmeService.listarFilmes()) {
                System.out.println(filme.getId() + ") " + filme.getNome());
            }
            System.out.println("Escolha o filme: ");
            int filmeId = Entrada.getInt();

            System.out.println("Lista de atores: ");
            for (Ator ator:atorService.listarAtores()) {
                System.out.println(ator.getId() + ") " + ator.getNome());
            }
            System.out.println("Escolha o ator: ");
            int atorId = Entrada.getInt();

            Ator ator = atorService.buscarAtorId(atorId);
            Filme filme = filmeService.buscarFilmeId(filmeId);

            if (!atorService.buscarFilme(ator, filme)) {
                atorService.adicionarFilmeAoAtor(ator, filme, filmeService);
                System.out.println(atorService.buscarAtorId(atorId).toString());
            } else {
                System.out.println("Filme já adicionado à lista do ator!");
            }
        }
    }
}
