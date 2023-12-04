package model;

import java.util.Date;

public abstract class Relatorio {
    private int id;
    private Date dataGeracao;

    public Relatorio(int id, Date dataGeracao) {
        this.id = id;
        this.dataGeracao = dataGeracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public abstract void gerarRelatorio();
}
