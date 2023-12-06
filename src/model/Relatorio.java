package model;

import java.util.Date;

public abstract class Relatorio {
    private int id;
    private Date dataGeracao;

    public Relatorio(int id, Date dataGeracao) {
        this.id = id;
        this.dataGeracao = dataGeracao;
    }

    public Relatorio() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataGeracao() {
        System.out.println("Relatório gerado em: ");
        return "Relatório gerado em: " + dataGeracao;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public abstract void gerarRelatorio();

    @Override
    public String toString() {
        return "Relatorio{" +
                "id=" + id +
                ", dataGeracao=" + dataGeracao +
                '}';
    }
}
