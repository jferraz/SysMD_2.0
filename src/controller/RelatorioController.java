package controller;

import model.*;
import util.MDNaoEncontradoException;

import java.util.List;
import java.util.Map;
import java.util.*;

public class RelatorioController implements Imprimivel {
    private static List<Apostila> apostilas;
    private static List<Livro> livros;
    private static List<MaterialDidatico> materiaisDidaticos;
    private Map<String, List<MaterialDidatico>> livroPorISBN = new HashMap<>();
    private Map<String, List<MaterialDidatico>> apostilasPorSKU = new HashMap<>();
    RelatorioMD relatorioMD = new RelatorioMD();

    Scanner sc = new Scanner(System.in);

    public RelatorioController() {
        this.materiaisDidaticos = MaterialDidaticoController.materiaisDidaticos;
        this.livros = MaterialDidaticoController.livros;
        this.apostilas = MaterialDidaticoController.apostilas;
        this.livroPorISBN = MaterialDidaticoController.livroPorISBN;
        this.apostilasPorSKU = MaterialDidaticoController.apostilasPorSKU;
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
            System.out.println("SKU: " + entrada.getKey());
            for (MaterialDidatico material : entrada.getValue()) {
                System.out.println("\nTítulo: " + material.getTitulo());
            }
        }
    }

//    public void relatorios() throws MDNaoEncontradoException {
//        System.out.println("Selecione o tipo de relatório desejado:\n");
//        System.out.println("1 - Relatório de Materiais Didáticos \n2 - Relatório de Acessos \n3 - Relatório Financeiro");
//        int opcao = sc.nextInt();
//
//        if(opcao == 1){
//            relatorioMD.gerarRelatorio();
//        }
//        if(opcao == 2){
//
//        }
//        if(opcao == 3){
//            relatorios.imprimir();
//        }
//    }
    @Override
    public void imprimir() throws MDNaoEncontradoException {
        System.out.println("Selecione o material didático a imprimir:\n");
        System.out.println("1 - Livros \n2 - Apostilas");
        int opcao = sc.nextInt();

        if(opcao == 1){
            if(livros.isEmpty()){
                throw new MDNaoEncontradoException("Livros não cadastrados!");
            }
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
        if(opcao == 2){
            if(apostilas.isEmpty()){
                throw new MDNaoEncontradoException("Livros não cadastrados!");
            }
            for (Apostila apostila : apostilas) {
                System.out.println(apostila);
            }
        }
    }
}
