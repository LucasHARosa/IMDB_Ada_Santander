import projeto_IMDB.dominio.Ator;
import projeto_IMDB.dominio.Filme;

public class Main {
    public static void main(String[] args) {
        //Teste, desconsiderar
        System.out.println("Hello world!");
        Filme filme = new Filme("star wars");
        Filme filme2 = new Filme("star wars2");
        Ator ator = new Ator("jeorge","masculino",12,10,1500);
        ator.addFilme(filme);
        System.out.println(ator.toString());
        ator.addFilme(filme2);
        System.out.println(ator.toString());


    }
}