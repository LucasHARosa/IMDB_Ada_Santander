package projeto_IMDB.controller;

public class Main {
    public static void main(String[] args) {
        System.out.println("BEM VINDO AO IMDB DO GRUPO 5");
        int opcao;

        do {
            menu();
            opcao = Entrada.getInt();
            operacaoARealizar(opcao);
        } while (opcao != 0);
    }
    public static void menu(){
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
        System.out.println("O que deseja realizar?");
    }

    public static void operacaoARealizar(int operacao){

        switch (operacao){
            case 1:

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
}
