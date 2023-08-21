package projeto_IMDB.dominio;

import java.util.ArrayList;
import java.util.List;

public class Filme extends AudioVisual {
    private static long contadorFilme = 0;
    private long id;
    // TODO media dos prestigios dos atores e diretor
    private double notaElenco;
    // TODO alguma relação com a nota do elenco e o tempo de produção
    private double notaIMDB;
    // TODO quanto mais tempo de produção melhor a nota do filme
    private double tempoProducao;
    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();

    public Filme(
            String nome,
            String dataLancamento,
            double orcamento,
            String descricao,
            double tempoProducao,
            List<Ator> atores,
            List<Diretor> diretores
    ) {
        super(
                nome,
                dataLancamento,
                orcamento,
                descricao
        );
        this.id = ++contadorFilme;
        this.tempoProducao = tempoProducao;
        this.atores = atores;
        this.diretores = diretores;
    }

    public void adicionarAtor(Ator ator) {
        getAtores().add(ator);
        calcularNotaElenco();
    }
    public void adicionarDiretor(Diretor diretor) {
        getDiretores().add(diretor);
        calcularNotaElenco();
    }

    // TODO media dos prestigios dos atores e diretor
    @Override
    public void calcularNotaElenco() {
        double nota;
        double soma = 0.0;

        if (!getAtores().isEmpty()) {
            for ( Ator ator : getAtores() ) {
                soma += ator.getPrestigio();
            }
        }

        if (!getDiretores().isEmpty()) {
            for (Diretor diretor : getDiretores() ) {
                soma += diretor.getPrestigio();
            }
        }

        nota = soma / (getAtores().size() + getDiretores().size());

        setNotaElenco(nota);
    }
    // TODO alguma relação com a nota do elenco e o tempo de produção
    @Override
    protected void calcularNotaImdb() {
        double contribuicaoTempoProducao = calcularContribuicaoTempoProducao(tempoProducao);

        setNotaIMDB(notaElenco * contribuicaoTempoProducao);
    }

    private double calcularContribuicaoTempoProducao(double tempoDeProducao){
        if (tempoDeProducao >= 12) {
            return 1.75;
        } else if (tempoDeProducao >= 10) {
            return 1.5;
        } else if (tempoDeProducao >= 6) {
            return 1.25;
        }

        return 1.10;
    }

    @Override
    public String toString() {
        List<String> nomesAtores = new ArrayList<>();
        for (Ator ator : getAtores()) {
            nomesAtores.add(ator.getNome());
        }

        List<String> nomesDiretores = new ArrayList<>();
        for (Diretor diretor : getDiretores()) {
            nomesDiretores.add(diretor.getNome());
        }
        StringBuilder result = new StringBuilder("_____________________________\n" +
                "Nome: " + getNome() +
                "\nData de lancamento: " + getDataLancamento() +
                "\nTempo de producao: " + getTempoProducao() + " meses"+
                "\nDescricao: "+ getDescricao());

        if (!nomesDiretores.isEmpty()) {
            result.append("\nDiretores: ").append(nomesDiretores);
        }
        if (!nomesAtores.isEmpty()) {
            result.append("\nAtores: ").append(nomesAtores);
        }
        if (!nomesDiretores.isEmpty() && !nomesAtores.isEmpty() ) {
            result.append("\nNota do elenco: ").append(getNotaElenco()).append("\nNota IMDB: ").append(getNotaIMDB());
        }

        return result.toString();
    }

    public long getId() {
        return id;
    }

    public double getNotaElenco() {
        return notaElenco;
    }

    public void setNotaElenco(double notaElenco) {
        this.notaElenco = notaElenco;
    }

    public double getNotaIMDB() {
        return notaIMDB;
    }

    public void setNotaIMDB(double notaIMDB) {
        this.notaIMDB = notaIMDB;
    }

    public double getTempoProducao() {
        return tempoProducao;
    }

    public void setTempoProducao(double tempoProducao) {
        this.tempoProducao = tempoProducao;
    }

    @Override
    public List<Ator> getAtores() {
        return atores;
    }

    public List<Diretor> getDiretores() {
        return diretores;
    }
}
