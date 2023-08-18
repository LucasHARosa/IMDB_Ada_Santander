package projeto_IMDB.controller;

import projeto_IMDB.dominio.Ator;
import projeto_IMDB.dominio.Filme;
import projeto_IMDB.service.AtorService;
import projeto_IMDB.service.FilmeService;
import projeto_IMDB.utils.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class MenuController {

    private FilmeService filmeService;
    private AtorService atorService;

    public MenuController(FilmeService filmeService, AtorService atorService){
        this.filmeService = filmeService;
        this.atorService = atorService;
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
                            "7) Adicionar um filme ao ator\n" +
                            "8) Adicionar um ator ao filme\n" +
                            "9) Adicionar um diretor ao filme\n" +
                            "0) Encerrar aplicativo");
        System.out.println("____________________________________");
    }

    public void operacaoARealizar(int operacao){

        switch (operacao){
            case 1:
                cadastrarFilmes();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;

            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 0:
                break;
            default:
                System.out.println("Valor inválido");
                break;
        }
    }

    private void cadastrarFilmes() {
        System.out.println("---- Cadastro de Filmes ----");

        String nome = InputHandler.getStringInput("Digite o nome do filme: ");
        String data = InputHandler.getStringInput("Digite a data de lançamento de " + nome + ": ");
        Integer ator;
        List<Ator> atoresFilme = new ArrayList();
        System.out.println("Adição de atores ao elenco de " + nome + ": ");
        do {
            ator = InputHandler.getIntInput("Digite o código do ator: (Para finalizar, digite -1)\n");
            if (ator != -1) {
                Ator atorLista = atorService.buscarAtorId(ator);
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
        } while (ator != -1);
        double orcamento = InputHandler.getDoubleInput("Digite o orçamento gasto para a produção de " + nome + ": ");
        int tempoProducao = InputHandler.getIntInput("Digite o tempo gasto (em meses) para a produção de " + nome + ":");
        String descricao = InputHandler.getStringInput("Digite a descrição de " + nome + ": ");


        Filme filme = new Filme(nome, data, orcamento, descricao, tempoProducao);
        filmeService.cadastrarFilme(filme);
        if (filmeService.buscarFilme(nome) != null) {
            System.out.println("Cadastro realizado com sucesso!");
        }
    }
}
