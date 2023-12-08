package model;

import util.MDNaoEncontradoException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelatorioFinanceiro extends Relatorio implements Imprimivel{
    private List<Livro> livros = new ArrayList<>();
    private List<Apostila> apostilas = new ArrayList<>();
    public RelatorioFinanceiro(List<Livro> livros, List<Apostila> apostilas, int id, Date dataGeracao) {
        super(id, dataGeracao);
        this.livros = livros;
        this.apostilas = apostilas;
    }

    public RelatorioFinanceiro(List<Livro> livros, List<Apostila> apostilas) {
        this.livros = livros;
        this.apostilas = apostilas;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Apostila> getApostilas() {
        return apostilas;
    }

    public void setApostilas(List<Apostila> apostilas) {
        this.apostilas = apostilas;
    }

    public RelatorioFinanceiro() {
        super();
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

        float valorTotal = 0;
        for (Livro livro : livros) {
            valorTotal += livro.getValor() * livro.getQuantidade();
        }
        for (Apostila apostila : apostilas) {
            valorTotal += apostila.getValor() * apostila.getQuantidade();
        }
        System.out.println("\nValor total em estoque: " + valorTotal);
    }
}
