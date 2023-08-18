package projeto_IMDB.dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AudioVisual {
    private String nome;
    // private Date dataLancamento;
    private String dataLancamento;
    private double orcamento;
    private String descricao;
    private List<Ator> atores;
    private Diretor diretor;
    // protected SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    protected AudioVisual(
            String nome,
            // Date dataLancamento,
            String dataLancamento,
            double orcamento,
            String descricao
    ) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        // this.dataLancamento = converteStringParaDate(dataLancamento);
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.atores = new ArrayList<>();
        this.diretor = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /*public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }*/

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    /*private Date converteStringParaDate(String dataInformada){
        Date dataFormatada = null;

        try {
            dataFormatada = formatoData.parse(dataInformada);
        } catch (ParseException e) {
            System.out.println(e);
        }

        return dataFormatada;
    }*/

    //adicionar os metodos de calculo de nota e adicionar atores e diretores
    protected abstract double calcularNotaElenco();
    protected abstract double calcularNotaImdb();
}
