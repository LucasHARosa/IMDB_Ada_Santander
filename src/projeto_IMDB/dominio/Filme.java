package projeto_IMDB.dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// import static projeto_IMDB.utils.Formatadores.converteStringParaDate;
// import static projeto_IMDB.utils.Formatadores.converterDateParaString;

public class Filme extends AudioVisual {
    private static long contadorFilme = 0;
    private long id;
    // TODO media dos prestigios dos atores e diretor
    private double notaElenco;
    // TODO alguma relação com a nota do elenco e o tempo de produção
    private double notaIMDB;
    // TODO quanto mais tempo de produção melhor a nota do filme
    private double tempoProducao;
    // private SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    /*private Date converteStringParaDate(String dataInformada){
        Date dataFormatada = null;

        try {
            dataFormatada = formatoData.parse(dataInformada);
        } catch (ParseException e) {
            System.out.println(e);
        }

        return dataFormatada;
    }*/

    /*private String converterDateParaString(Date dataInformada) {
        return formatoData.format(dataInformada);
    }*/

    public Filme(
            String nome,
            // Date dataLancamento,
            String dataLancamento,
            double orcamento,
            String descricao,
            double tempoProducao
    ) {
        super(
                nome,
                // converteStringParaDate(dataLancamento),
                dataLancamento,
                orcamento,
                descricao
        );
        this.id = ++contadorFilme;
        this.tempoProducao = tempoProducao;
        this.notaElenco = calcularNotaElenco();
        this.notaIMDB = calcularNotaImdb();
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

    // TODO media dos prestigios dos atores e diretor
    @Override
    protected double calcularNotaElenco() {
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

    private double calcularContribuicaoTempoProducao(double tempoDeProducao) {
        if (tempoDeProducao >= 12) {
            return 1.75;
        } else if (tempoDeProducao >= 10) {
            return 1.5;
        } else if (tempoDeProducao >= 6) {
            return 1.25;
        }

        return 1.10;
    }

    // arrumar isso para listar todas as informações
    @Override
    public String toString() {
        return "_____________________________\n"+
                "Filme { " +
                "id = " + getId() +
                ", nome = '" + getNome() + '\'' +
                // ", dataLancamento = " + converterDateParaString(getDataLancamento()) +
                ", dataLancamento = " + getDataLancamento() +
                ", atores = " + getAtores() +
                ", diretor = " + getDiretor() +
                ", tempoProducao = " + getTempoProducao() +
                ", notaElenco = " + getNotaElenco() +
                ", notaIMDB = " + getNotaIMDB() +
                " }";
    }
}
