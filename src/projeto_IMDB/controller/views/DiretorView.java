package projeto_IMDB.controller.views;

import projeto_IMDB.controller.Entrada;
import projeto_IMDB.dominio.Diretor;
import projeto_IMDB.service.DiretorService;

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
        for (Diretor diretor:diretorService.listarDiretores()) {
            System.out.println(diretor);
        }
    }
}
