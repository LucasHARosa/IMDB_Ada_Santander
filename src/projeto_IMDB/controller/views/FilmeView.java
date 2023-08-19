package projeto_IMDB.controller.views;

import projeto_IMDB.controller.Entrada;
import projeto_IMDB.dominio.Ator;
import projeto_IMDB.dominio.Diretor;
import projeto_IMDB.dominio.Filme;
import projeto_IMDB.service.AtorService;
import projeto_IMDB.service.DiretorService;
import projeto_IMDB.service.FilmeService;
import projeto_IMDB.utils.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class FilmeView {

    public static void cadastrarFilmes(FilmeService filmeService, AtorService atorService, DiretorService diretorService) {
        System.out.println("---- Cadastro de Filmes ----");

        String nome = InputHandler.getStringInput("Digite o nome do filme: ");
        String data = InputHandler.getStringInput("Digite a data de lançamento de " + nome + ": ");
        Integer ator1, diretor1;
        List<Ator> atoresFilme = new ArrayList();
        List<Diretor> diretoresFilme = new ArrayList();

        System.out.println("Lista de atores cadastrados: ");
        for (Ator ator : atorService.listarAtores()) {
            System.out.println(ator.getId() + ") " + ator.getNome());
        }

        System.out.println("Adição de atores ao elenco de " + nome + ": ");
        do {
            ator1 = InputHandler.getIntInput("Digite o código do ator: (Para finalizar, digite -1)\n");
            if (ator1 != -1) {
                Ator atorLista = atorService.buscarAtorId(ator1);
                if (atorLista != null) {
                    if (!atoresFilme.contains(atorLista)) {
                        atoresFilme.add(atorLista);
                    } else {
                        System.out.println("Ator já adicionado ao elenco do filme!");
                    }
                } else {
                    System.out.println("Ator não encontrado no sistema!");
                }
            }
        } while (ator1 != -1);

        System.out.println("\nLista de diretores cadastrados: ");
        for (Diretor diretor : diretorService.listarDiretores()) {
            System.out.println(diretor.getId() + ") " + diretor.getNome());
        }

        System.out.println("\nAdição de diretores de " + nome + ": ");
        do {
            diretor1 = InputHandler.getIntInput("Digite o código do diretor: (Para finalizar, digite -1)\n");
            if (diretor1 != -1) {
                Diretor diretorLista = diretorService.buscarDiretorId(diretor1);
                if (diretorLista != null) {
                    if (!diretoresFilme.contains(diretorLista)) {
                        diretoresFilme.add(diretorLista);
                    } else {
                        System.out.println("Diretor já adicionado ao filme!");
                    }
                } else {
                    System.out.println("Diretor não encontrado no sistema!");
                }
            }
        } while (diretor1 != -1);

        double orcamento = InputHandler.getDoubleInput("Digite o orçamento gasto para a produção de " + nome + ": ");
        int tempoProducao = InputHandler.getIntInput("Digite o tempo gasto (em meses) para a produção de " + nome + ": ");
        String descricao = InputHandler.getStringInput("Digite a descrição de " + nome + ": ");


        Filme filme = new Filme(nome, data, orcamento, descricao, tempoProducao, atoresFilme, diretoresFilme);
        filmeService.cadastrarFilme(filme);
        if (filmeService.buscarFilme(nome) != null) {
            System.out.println("Cadastro realizado com sucesso!");
        }
    }

    public static void listarFilmes(FilmeService filmeService) {
        System.out.println("\n---- Listar Filmes ----");
        List<Filme> filmes = filmeService.listarFilmes();
        if (filmes.isEmpty()){
            System.out.println("Nenhum filme cadastrado!");
        } else {
            System.out.println("Lista de filmes cadastrados:");
            for (Filme filme : filmes) {
                System.out.println(filme);
            }
        }
    }

    public static void adicionarAtorAoFilme(AtorService atorService, FilmeService filmeService){
        System.out.println("---- Associação de Atores a Filmes ----");
        System.out.println("Lista de Atores: ");

        for (Ator ator : atorService.listarAtores()) {
            System.out.println(ator.getId() + ") " + ator.getNome());
        }
        int atorId = InputHandler.getIntInput("Digite o código do ator: ");

        System.out.println("Lista de Filmes: ");
        for (Filme filme : filmeService.listarFilmes()) {
            System.out.println(filme.getId() + ") " + filme.getNome());
        }
        int filmeId = InputHandler.getIntInput("Digite o código do filme: ");

        Filme filme = filmeService.buscarFilmeId(filmeId);
        Ator ator = atorService.buscarAtorId(atorId);

        if (ator != null) {
            if (!filmeService.buscarAtor(ator, filme)) {
                filmeService.adicionarAtor(filme, ator);
            } else {
                System.out.println("Ator já adicionado ao elenco do filme!");
            }
        } else {
            System.out.println("Ator não encontrado no sistema!");
        }

        if (ator != null && filme != null) {
            filmeService.adicionarAtor(filme, ator);
            System.out.println(ator.getNome() + " associado a " + filme.getNome() + " com sucesso!");
        } else {
            System.out.println("Ação inválida!");
        }
    }

 /*public void adicionarDiretorEmFilme() {
        int filmeId = InputHandler.getIntInput("Digite o código do filme: ");
        Filme filme = filmeService.buscarFilmeId(filmeId);
        int diretorId = InputHandler.getIntInput("Digite o código do diretor: \n");
        Diretor diretor = diretorService.buscarDiretorId(diretorId);
        if (diretor != null && filme != null) {
            filmeService.adicionarDiretor(filme, diretor);
        } else {
            System.out.println("Ação inválida!");
        }
    }*/

    public static void pesquisarFilmePorNome(FilmeService filmeService) {
        String nome = InputHandler.getStringInput("Digite o nome do filme: ");
        Filme filme = filmeService.buscarFilme(nome);
        if (filme != null){
            System.out.println(filme.toString());
        }
    }
}
