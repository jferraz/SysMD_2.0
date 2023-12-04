package model;

import java.util.Date;
import java.util.List;

public class RelatorioMD extends Relatorio {
    private List<MaterialDidatico> materiaisDidaticos;
    public RelatorioMD(int id, Date dataGeracao) {
        super(id, dataGeracao);
    }
    public RelatorioMD(List<MaterialDidatico> materiaisDidaticos, int id, Date dataGeracao){
        super(id, dataGeracao);
        this.materiaisDidaticos = materiaisDidaticos;
    }
    @Override
    public void gerarRelatorio() {
        for(MaterialDidatico md : materiaisDidaticos) {
            System.out.println(md);
        }
    }
}
