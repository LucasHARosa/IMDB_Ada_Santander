package projeto_IMDB.controller.views;

import projeto_IMDB.controller.Entrada;
import projeto_IMDB.dominio.Ator;
import projeto_IMDB.dominio.Diretor;
import projeto_IMDB.dominio.Filme;
import projeto_IMDB.service.AtorService;
import projeto_IMDB.service.DiretorService;
import projeto_IMDB.service.FilmeService;

public class DiretorView {
    public static void cadastrarDiretor(DiretorService diretorService){
        System.out.println("---- Cadastro de Diretor ----");
        System.out.print("Nome: ");
        String nome = Entrada.getStringNextLine();

        System.out.print("Sexo: ");
        String sexo = Entrada.getStringNextLine();

        System.out.print("Anos de Carreira: ");
        int anosCarreira = Entrada.getInt();

        System.out.print("Prestígio: ");
        double prestigio = Entrada.getDouble();

        System.out.print("Especialidade: ");
        String especialidade = Entrada.getStringNextLine();

        Diretor diretorNovo = new Diretor(nome, sexo, anosCarreira, prestigio, especialidade);
        diretorService.cadastrarDiretor(diretorNovo);

        System.out.println("Diretor cadastrado com sucesso!");
    }

    public static void listarDiretores(DiretorService diretorService){
        if (diretorService.listarDiretores().isEmpty() || diretorService.listarDiretores().equals(null)){
            System.out.println("Nenhum diretor cadastrado!");
        } else {
            for (Diretor diretor:diretorService.listarDiretores()) {
                System.out.println(diretor);
            }
        }
    }

    public static void adicionarFilmeAoDiretor(DiretorService diretorService, FilmeService filmeService){
        if (diretorService.listarDiretores().isEmpty() || diretorService.listarDiretores().equals(null)){
            System.out.println("Nenhum diretor cadastrado!");
        } else if (filmeService.listarFilmes().isEmpty() || filmeService.listarFilmes().equals(null)) {
            System.out.println("Nenhum filme cadastrado!");
        } else {
            System.out.println("---- Associação de Diretores e Filmes ----");
            System.out.println("Lista de filmes: ");
            for (Filme filme:filmeService.listarFilmes()) {
                System.out.println(filme.getId() + ") " + filme.getNome());
            }
            System.out.println("Escolha o filme: ");
            int filmeId = Entrada.getInt();

            System.out.println("Lista de diretores: ");
            for (Diretor diretor:diretorService.listarDiretores()) {
                System.out.println(diretor.getId() + ") " + diretor.getNome());
            }
            System.out.println("Escolha o diretor: ");
            int diretorId = Entrada.getInt();

            Diretor diretor = diretorService.buscarDiretorId(diretorId);
            Filme filme = filmeService.buscarFilmeId(filmeId);

            if (!diretorService.buscarFilme(diretor, filme)) {
                diretorService.adicionarFilmeAoDiretor(diretor, filme, filmeService);
                System.out.println(diretorService.buscarDiretorId(diretorId).toString());
            } else {
                System.out.println("Filme já adicionado à lista do diretor!");
            }
        }
    }
}
