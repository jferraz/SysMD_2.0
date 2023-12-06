package controller;

import model.*;
import util.MDNaoEncontradoException;

import java.util.List;
import java.util.Map;
import java.util.*;

public class RelatorioController implements Imprimivel {
    private List<Apostila> apostilas;
    private List<Livro> livros;
    private List<MaterialDidatico> materiaisDidaticos;
    private Map<String, List<MaterialDidatico>> livroPorISBN = new HashMap<>();
    private Map<String, List<MaterialDidatico>> apostilasPorSKU = new HashMap<>();

    RelatorioFinanceiro relatorios = new RelatorioFinanceiro();

    Scanner sc = new Scanner(System.in);

    public Livro imprimeLivros() throws MDNaoEncontradoException {
        for (Livro livro : livros) {
            return livro;
        }
        throw new MDNaoEncontradoException("Livros não cadastrados!");
    }

    public Apostila imprimeApostilas() throws MDNaoEncontradoException {
        for (Apostila apostila : apostilas) {
            return apostila;
        }
        throw new MDNaoEncontradoException("Apostilas não cadastradas!");
    }

    public MaterialDidatico buscaMDporId(int id) throws MDNaoEncontradoException {
        for (MaterialDidatico md : materiaisDidaticos) {
            if (md.getId() == id) {
                return md;
            }
        }
        throw new MDNaoEncontradoException("Material didático com o id " + id + " não cadastrado!");
    }

    public void listarMateriaisDidaticos() throws MDNaoEncontradoException {
        if(materiaisDidaticos.isEmpty()) {
            throw new MDNaoEncontradoException("Nenhum material didático cadastrado!");
        }
        for (MaterialDidatico material : materiaisDidaticos) {
            System.out.println(material.toString());
        }
    }
    //IMPLEMENTAÇÃO DE MAP
    public void imprimeRelatorioISBN() throws MDNaoEncontradoException {
        if(livroPorISBN.isEmpty()) {
            throw new MDNaoEncontradoException("Nenhum material didático cadastrado!");
        }
        for (Map.Entry<String, List<MaterialDidatico>> entrada : livroPorISBN.entrySet()) {
            System.out.println("ISBN: " + entrada.getKey());
            for (MaterialDidatico material : entrada.getValue()) {
                System.out.println("\nTítulo: " + material.getTitulo());
            }
        }
    }

    public void imprimeRelatorioSKU() throws MDNaoEncontradoException {
        if(apostilasPorSKU.isEmpty()) {
            throw new MDNaoEncontradoException("Nenhum material didático cadastrado!");
        }
        for (Map.Entry<String, List<MaterialDidatico>> entrada : apostilasPorSKU.entrySet()) {
            System.out.println("ISBN: " + entrada.getKey());
            for (MaterialDidatico material : entrada.getValue()) {
                System.out.println("\nTítulo: " + material.getTitulo());
            }
        }
    }

    public RelatorioFinanceiro imprimeRF(MaterialDidatico material) {
        return relatorios;
    }
    @Override
    public void imprimir() {

    }
}
