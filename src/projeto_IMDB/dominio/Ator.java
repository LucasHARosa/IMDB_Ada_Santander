package projeto_IMDB.dominio;

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
        String listaDeFilmes = "Lista de filmes que participou:\n";
        for(Filme filme : getFilmes()){
            listaDeFilmes += filme.toString() +"\n";
        }
        return listaDeFilmes;
    }

    @Override
    public String toString(){
        return
            "_____________________________\n"+
            "Nome: "+getNome() +
            ", Sexo: " + getSexo()  +
            ", Anos De Carreira: " + getAnosDeCarreira() +
            ", Cache: R$"+cache+
            ", Prestigio (0-10): " + getPrestigio() + "\n"+
            listaFilmes()
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
