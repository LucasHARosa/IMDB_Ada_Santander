package projeto_IMDB.dominio;

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
        String listaDeFilmes = "Lista de filmes que dirigiu:\n";
        for(Filme filme : getFilmes()){
            listaDeFilmes += filme.toString() +"\n";
        }
        return listaDeFilmes;
    }

    @Override
    public String toString() {
        return
            "_____________________________\n"+
            "Nome: "+getNome() +
            ", Sexo: " + getSexo()  +
            ", Anos De Carreira: " + getAnosDeCarreira() +
            ", Especialidade: "+especialidade+
            ", Prestigio (0-10): " + getPrestigio() + "\n"+
            listaFilmes()
            ;
    }
}
