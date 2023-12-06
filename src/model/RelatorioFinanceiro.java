package model;

import java.util.Date;
import java.util.List;

public class RelatorioFinanceiro extends Relatorio{
    private List<Livro> livros;
    private List<Apostila> apostilas;
    public RelatorioFinanceiro(List<Livro> livros, List<Apostila> apostilas, int id, Date dataGeracao) {
        super(id, dataGeracao);
        this.livros = livros;
        this.apostilas = apostilas;
    }

    public RelatorioFinanceiro() {
        super();
    }

    @Override
    public void gerarRelatorio() {
        float valorTotal = 0;

        for(Livro livro : livros) {
            valorTotal += livro.getValor() + livro.getQuantidade();
        }

        for(Apostila apostila : apostilas) {
            valorTotal += apostila.getValor() + apostila.getQuantidade();
        }
        System.out.println("Valor total em estoque: " + valorTotal);
    }
}
