package projeto_IMDB.dominio;

import java.util.ArrayList;
import java.util.List;

public class Ator extends Person {
    private double cache;

    public Ator(String nome, String sexo, int anosDeCarreira, double prestigio, double cache) {
        super(nome, sexo, anosDeCarreira, prestigio);
        this.cache = cache;
    }

    public double getCache() {
        return cache;
    }

    private String listaFilmes(){
        if(getFilmes().size() != 0){
            List<String> nomesFilmes = new ArrayList<>();;

            for(Filme filme : getFilmes()){
                nomesFilmes.add(filme.getNome());
            }

            return nomesFilmes.toString();
        }
        return "Não participou de nenhum filme!";


    }

    @Override
    public String toString(){
        return
            "Nome: "+getNome() +
            ", Sexo: " + getSexo()  +
            ", Anos De Carreira: " + getAnosDeCarreira() +
            ", Cache: R$"+cache+
            ", Prestigio (0-10): " + getPrestigio() + "\n"+
            listaFilmes()+
            "\n"
            ;
    }

    public String infoBasica(){
        return
            "_____________________________\n"+
            "Nome: "+getNome() +
            ", Sexo: " + getSexo()  +
            ", Anos De Carreira: " + getAnosDeCarreira() +
            ", Cache: R$"+cache+
            ", Prestigio (0-10): " + getPrestigio() + "\n"
            ;
    }



}
