package projeto_IMDB.dominio;

import java.util.ArrayList;
import java.util.List;

public class Diretor  extends Person{
    private String especialidade;

    public Diretor(String nome, String sexo, int anosDeCarreira, double prestigio, String especialidade) {
        super(nome, sexo, anosDeCarreira, prestigio);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
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
    public String toString() {
        return
            "Nome: "+getNome() +
            ", Sexo: " + getSexo()  +
            ", Anos De Carreira: " + getAnosDeCarreira() +
            ", Especialidade: "+ especialidade+
            ", Prestigio (0-10): " + getPrestigio() + "\n"+
            listaFilmes()+
            "\n"
            ;
    }

    public String infoBasica(){
        return
            "--\n"+
            "Nome: "+getNome() +
            ", Sexo: " + getSexo()  +
            ", Anos De Carreira: " + getAnosDeCarreira() +
            ", Especialidade: "+especialidade+
            ", Prestigio (0-10): " + getPrestigio() + "\n"
            ;
    }
}
