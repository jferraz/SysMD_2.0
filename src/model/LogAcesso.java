package model;

import java.util.Date;

public class LogAcesso implements Autenticavel{
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
        return "Dados do log de acesso: " +
                "\nUsuário: " + usuario + '\'' +
                "\nData e hora: " + dataHora +
                "\nConseguiu acessar? " + sucesso;
    }

    @Override
    public boolean autenticar(String nome, String senha) {
        return false;
    }
}
