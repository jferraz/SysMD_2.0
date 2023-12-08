package model;

import java.util.Date;
import java.util.List;

public class RelatorioLogAcesso extends Relatorio{
    private static List<LogAcesso> logDeAcesso;

    public RelatorioLogAcesso(int id, Date dataGeracao, List<LogAcesso> logDeAcesso){
        super(id, dataGeracao);
        this.logDeAcesso = logDeAcesso;
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Log de Acessos: ");
        for(LogAcesso log : logDeAcesso) {
            System.out.println(log);
        }
    }
}
