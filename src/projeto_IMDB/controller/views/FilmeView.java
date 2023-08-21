package projeto_IMDB.controller.views;

import projeto_IMDB.controller.Entrada;
import projeto_IMDB.dominio.Ator;
import projeto_IMDB.dominio.Diretor;
import projeto_IMDB.dominio.Filme;
import projeto_IMDB.service.AtorService;
import projeto_IMDB.service.DiretorService;
import projeto_IMDB.service.FilmeService;
import projeto_IMDB.utils.InputHandler;
import projeto_IMDB.utils.ListaVaziaException;

import java.util.ArrayList;
import java.util.List;

public class FilmeView {

    public static void cadastrarFilmes(FilmeService filmeService, AtorService atorService, DiretorService diretorService) {
        System.out.println("---- Cadastro de Filmes ----");

        String nome = InputHandler.getStringInput("Digite o nome do filme: ");
        String data = InputHandler.getStringInput("Digite a data de lancamento de " + nome + ": ");

        List<Ator> listaAtores = atorService.listarAtores();
        List<Diretor> listaDiretores = diretorService.listarDiretores();

        Integer ator1, diretor1;
        List<Diretor> diretoresFilme = new ArrayList();
        List<Ator> atoresFilme = new ArrayList();

        List<Ator> adicaoDeAtores = new ArrayList<>();


        if (!listaAtores.isEmpty()) {
            System.out.println("Lista de atores cadastrados: ");
            for (Ator ator : listaAtores) {
                System.out.println(ator.getId() + ") " + ator.getNome());
            }

            System.out.println("Adicaoo de atores ao elenco de " + nome + ": ");

            do {
                ator1 = InputHandler.getIntInput("Digite o código do ator: (Para finalizar, digite 0)\n");
                if (ator1 != 0) {
                    Ator atorLista = atorService.buscarAtorId(ator1);
                    if (atorLista != null) {
                        if (!atoresFilme.contains(atorLista)) {
                            adicaoDeAtores.add(atorLista);
                        } else {
                            System.out.println("Ator já adicionado ao elenco do filme!");
                        }
                    } else {
                        System.out.println("Ator não encontrado no sistema!");
                    }
                }
            } while (ator1 != 0);
        }

        List<Diretor> adicaoDeDiretores = new ArrayList<>();
        if (!listaDiretores.isEmpty()) {
            System.out.println("\nLista de diretores cadastrados: ");
            for (Diretor diretor : listaDiretores) {
                System.out.println(diretor.getId() + ") " + diretor.getNome());
            }

            System.out.println("\nAdicao de diretores de " + nome + ": ");
            do {
                diretor1 = InputHandler.getIntInput("Digite o codigo do diretor: (Para finalizar, digite 0)\n");
                if (diretor1 != 0) {
                    Diretor diretorLista = diretorService.buscarDiretorId(diretor1);
                    if (diretorLista != null) {
                        if (!diretoresFilme.contains(diretorLista)) {
                            adicaoDeDiretores.add(diretorLista);
                        } else {
                            System.out.println("Diretor ja adicionado ao filme!");
                        }
                    } else {
                        System.out.println("Diretor nao encontrado no sistema!");
                    }
                }
            } while (diretor1 != 0);
        }

        double orcamento = InputHandler.getDoubleInput("Digite o orcamento gasto para a producao de " + nome + ": ");
        int tempoProducao = InputHandler.getIntInput("Digite o tempo gasto (em meses) para a producao de " + nome + ": ");
        String descricao = InputHandler.getStringInput("Digite a descricao de " + nome + ": ");


        Filme filme = new Filme(nome, data, orcamento, descricao, tempoProducao, atoresFilme, diretoresFilme);
        filmeService.cadastrarFilme(filme);

        for (Ator ator:adicaoDeAtores) {
            filmeService.adicionarAtor(filme, ator);
        }

        for (Diretor diretor:adicaoDeDiretores) {
            filmeService.adicionarDiretor(filme, diretor);
        }

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
        try{
            if(atorService.listarAtores().isEmpty()){
                throw new ListaVaziaException("Por favor cadastre atores, a lista de atores esta vazia");
            }
            if(filmeService.listarFilmes().isEmpty()){
                throw new ListaVaziaException("Por favor cadastre filmes, a lista de filmes esta vazia");
            }
            System.out.println("---- Associacao de Atores a Filmes ----");

            System.out.println("Lista de Filmes: ");
            for (Filme filme : filmeService.listarFilmes()) {
                System.out.println(filme.getId() + ") " + filme.getNome());
            }
            int filmeId = InputHandler.getIntInput("Digite o codigo do filme: ");
            Filme filme = filmeService.buscarFilmeId(filmeId);


            System.out.println("Lista de Atores: ");
            for (Ator ator : atorService.listarAtores()) {
                System.out.println(ator.getId() + ") " + ator.getNome());
            }
            int atorId = InputHandler.getIntInput("Digite o codigo do ator: ");

            Ator ator = atorService.buscarAtorId(atorId);

            if (ator != null && filme != null) {
                if (!filmeService.buscarAtor(ator, filme)) {
                    filmeService.adicionarAtor(filme, ator);
                    System.out.println(ator.getNome() + " associado a " + filme.getNome() + " com sucesso!");
                } else {
                    System.out.println("Ator ja adicionado ao elenco do filme!");
                }
            } else {
                if(ator == null){
                    System.out.println("Ator nao encontrado no sistema!");
                }
                if(filme == null){
                    System.out.println("Filme nao encontrado no sistema");
                }

            }
        }catch (ListaVaziaException e){
            System.out.println("Erro: " + e.getMessage());
        }

    }

 public void adicionarDiretorEmFilme(DiretorService diretorService, FilmeService filmeService) {
        try{
            if(diretorService.listarDiretores().isEmpty()){
                throw new ListaVaziaException("Por favor cadastre diretores, a lista de diretores esta vazia");
            }
            if(filmeService.listarFilmes().isEmpty()){
                throw new ListaVaziaException("Por favor cadastre filmes, a lista de filmes esta vazia");
            }
            System.out.println("---- Associacao de Diretores a Filmes ----");

            System.out.println("Lista de Filmes: ");
            for (Filme filme : filmeService.listarFilmes()) {
                System.out.println(filme.getId() + ") " + filme.getNome());
            }
            int filmeId = InputHandler.getIntInput("Digite o codigo do filme: ");
            Filme filme = filmeService.buscarFilmeId(filmeId);


            System.out.println("Lista de Atores: ");
            for (Diretor diretor : diretorService.listarDiretores()) {
                System.out.println(diretor.getId() + ") " + diretor.getNome());
            }
            int diretorId = InputHandler.getIntInput("Digite o codigo do diretor: ");

            Diretor diretor = diretorService.buscarDiretorId(diretorId);

            if (diretor != null && filme != null) {
                if (!filmeService.buscarDiretor(diretor, filme)) {
                    filmeService.adicionarDiretor(filme, diretor);
                    System.out.println(diretor.getNome() + " associado a " + filme.getNome() + " com sucesso!");
                } else {
                    System.out.println("Diretor ja adicionado ao elenco do filme!");
                }
            } else {
                if(diretor == null){
                    System.out.println("Diretor nao encontrado no sistema!");
                }
                if(filme == null){
                    System.out.println("Filme nao encontrado no sistema");
                }
            }
        }catch(ListaVaziaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    public static void pesquisarFilmePorNome(FilmeService filmeService) {
        String nome = InputHandler.getStringInput("Digite o nome do filme: ");
        Filme filme = filmeService.buscarFilme(nome);
        if (filme != null){
            System.out.println(filme.toString());
        }else{
            System.out.println("Nenhum filme cadastrado com esse nome");
        }
    }
}
