package model;

import java.util.Date;

public class LogAcesso {
    private String usuario;
    private Date dataHora;
    private boolean sucesso;

    public LogAcesso(String usuario, Date dataHora, boolean sucesso){
        this.usuario = usuario;
        this.dataHora = dataHora;
        this.sucesso = sucesso;
    }

    @Override
    public String toString() {
        return "LogAcesso{" +
                "usuario='" + usuario + '\'' +
                ", dataHora=" + dataHora +
                ", sucesso=" + sucesso +
                '}';
    }
}
