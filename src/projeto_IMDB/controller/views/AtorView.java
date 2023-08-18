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

        System.out.print("Prestígio: ");
        double prestigio = Entrada.getDouble();

        System.out.print("Cache: ");
        double cache = Entrada.getDouble();

        Ator atorNovo = new Ator(nome, sexo, anosCarreira, prestigio, cache);
        atorService.cadastrarAtor(atorNovo);

        System.out.println("Ator cadastrado com sucesso!");
    }

    public static void listarAtores(AtorService atorService){
        for (Ator ator:atorService.listarAtores()) {
            System.out.println(ator);
            System.out.println(ator.getId());
        }
    }

    public static void adicionarFilmeAoAtor(AtorService atorService, FilmeService filmeService){
        System.out.println("---- Associação de Atores e Filmes ----");
        System.out.println("Lista de filmes: ");
        for (int i = 1; i < filmeService.listarFilmes().size(); i++) {
            String nome = filmeService.buscarFilmeId(i).getNome();
            System.out.println(i + ") " + nome);
        }
        System.out.println("Escolha o filme: ");
        int filmeId = Entrada.getInt();

        System.out.println("Lista de atores: ");
        for (int i = 1; i < atorService.listarAtores().size(); i++) {
            System.out.println(i + ") " + atorService.buscarAtorId(i).getNome());
        }
        System.out.println("Escolha o ator: ");
        int atorId = Entrada.getInt();

        atorService.adicionarFilmeAoAtor(atorService.buscarAtorId(atorId),
                filmeService.buscarFilmeId(filmeId),
                filmeService);

        System.out.println(atorService.buscarAtorId(atorId).toString());
    }
}
