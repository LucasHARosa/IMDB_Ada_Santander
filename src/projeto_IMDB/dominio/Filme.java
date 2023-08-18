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
    // Ligação para pegar dados das tabelas Diretor e Ator
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
        this.notaElenco = calcularNotaElenco();
        this.notaIMDB = calcularNotaImdb();
        this.tempoProducao = tempoProducao;
        this.atores = atores;
        this.diretores = diretores;
    }

    /*public Filme(
            String nome,
            String dataLancamento,
            double orcamento,
            String descricao,
            double tempoProducao
    ) {
        super(
                nome,
                dataLancamento,
                orcamento,
                descricao
        );
        this.id = ++contadorFilme;
        this.tempoProducao = tempoProducao;
        this.notaElenco = calcularNotaElenco();
        this.notaIMDB = calcularNotaImdb();
    }*/

    public void adicionarAtor(Ator ator) {
        atores.add(ator);
        calcularNotaElenco();
    }
    public void adicionarDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    // TODO media dos prestigios dos atores e diretor
    @Override
    public double calcularNotaElenco() {
        double nota;
        double soma = 0.0;

        if (!getAtores().isEmpty()) {
            for ( Ator ator : getAtores() ) {
                soma += ator.getPrestigio();
            }
        }

        if (getDiretor() != null) {
            soma += getDiretor().getPrestigio();
        }

        nota = soma / (getAtores().size() + 1);

        return nota;
    }
    // TODO alguma relação com a nota do elenco e o tempo de produção
    @Override
    protected double calcularNotaImdb() {
        double contribuicaoTempoProducao = calcularContribuicaoTempoProducao(tempoProducao);

        return notaElenco * contribuicaoTempoProducao;
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
        return "_____________________________\n"+
                "Filme { " +
                "id = " + getId() +
                ", nome = '" + getNome() + '\'' +
                ", dataLancamento = " + getDataLancamento() +
                ", atores = " + getAtores() +
                ", diretor = " + getDiretor() +
                ", tempoProducao = " + getTempoProducao() +
                ", notaElenco = " + getNotaElenco() +
                ", notaIMDB = " + getNotaIMDB() +
                " }";
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
}
