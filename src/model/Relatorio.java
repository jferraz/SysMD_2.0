package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return agora.format(formato);
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
