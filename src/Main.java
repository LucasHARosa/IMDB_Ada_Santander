import projeto_IMDB.dominio.Ator;
import projeto_IMDB.dominio.Diretor;
import projeto_IMDB.dominio.Filme;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Teste, desconsiderar
        System.out.println("Hello world!");
        Filme filme01 = new Filme(
                "star wars",
                "15/02/1971",
                79000,
                "Primeiro filme da trilogia.",
                3
        );
        System.out.println(filme01);
        Filme filme02 = new Filme(
                "star wars2",
                "29/05/1973",
                85600,
                "Segundo filme da trilogia.",
                2
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

        System.out.println(filme02);
    }
}