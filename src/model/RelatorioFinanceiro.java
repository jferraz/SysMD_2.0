package model;

import controller.MaterialDidaticoController;
import util.MDNaoEncontradoException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelatorioFinanceiro extends Relatorio implements Imprimivel, Vendavel{
    private double percentualDesconto;
    private List<Livro> livros;
    private List<Apostila> apostilas;

    public RelatorioFinanceiro() {
        this.livros = MaterialDidaticoController.getLivros();
        this.apostilas = MaterialDidaticoController.getApostilas();
    }

//    public RelatorioFinanceiro(List<Livro> livros, List<Apostila> apostilas) {
//        this.livros = livros;
//        this.apostilas = apostilas;
//    }

    public RelatorioFinanceiro(int id, Date dataGeracao) {
        super();
        this.livros = new ArrayList<>();
        this.apostilas = new ArrayList<>();
    }
    @Override
    public void gerarRelatorio() {
    }

    @Override
    public void imprimir() throws MDNaoEncontradoException {
        System.out.println("Relatório Financeiro:");
        System.out.println("Data de Geração: " + getDataGeracao());
        System.out.println("\nLivros:");
        for (Livro livro : livros) {
            System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor() +
                    ", Valor: " + livro.getValor() + ", Quantidade: " + livro.getQuantidade());
        }

        System.out.println("\nApostilas:");
        for (Apostila apostila : apostilas) {
            System.out.println("Título: " + apostila.getTitulo() + ", Valor: " + apostila.getValor() +
                    ", Quantidade: " + apostila.getQuantidade());
        }

        float valorTotal = calcularPrecoTotal();
        System.out.println("\nValor total em estoque: " + valorTotal);
    }

    @Override
    public float calcularPrecoTotal() {
        float valorTotal = 0;
        for (Livro livro : livros) {
            valorTotal += livro.getValor() * livro.getQuantidade();
        }
        for (Apostila apostila : apostilas) {
            valorTotal += apostila.getValor() * apostila.getQuantidade();
        }
        return valorTotal;
    }

    @Override
    public void aplicarDesconto(float percentualDesconto) {
        float valorTotalDesconto = 0;
        float valorTotal = 0;
        valorTotalDesconto = valorTotal * percentualDesconto;
    }

    @Override
    public String toString() {
        return "RelatorioFinanceiro{" +
                "percentualDesconto=" + percentualDesconto +
                ", livros=" + livros +
                ", apostilas=" + apostilas +
                "} " + super.toString();
    }
}
