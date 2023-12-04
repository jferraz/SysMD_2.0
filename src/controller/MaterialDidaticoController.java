package controller;

import model.*;
import util.MDNaoEncontradoException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class MaterialDidaticoController implements Imprimivel {
    private List<Livro> livros;
    private List<Apostila> apostilas;
    private List<MaterialDidatico> materiaisDidaticos;
    private Map<String, List<Livro>> livrosPorISBN = new HashMap<>();


    public MaterialDidaticoController() {
        this.materiaisDidaticos = new ArrayList<>();
        this.livros = new ArrayList<>();
        this.apostilas = new ArrayList<>();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Apostila> getApostilas() {
        return apostilas;
    }

    public List<MaterialDidatico> getMateriaisDidaticos() {
        List<MaterialDidatico> todosMateriais = new ArrayList<>();
        todosMateriais.addAll(livros);
        todosMateriais.addAll(apostilas);
        return todosMateriais;
    }

    public void adicionaLivro(Livro livro){
        this.livros.add(livro);
    }
    public void adicionaApostila(Apostila apostila){
        this.apostilas.add(apostila);
    }
    public void adicionarMD(MaterialDidatico material) {
        this.materiaisDidaticos.add(material);
        System.out.println("MD adicionado: " + material);
    }
    public void buscaLivroPorId(){

    }
    // MÉTODO COM THROWS
    public MaterialDidatico buscaMDporId(int id) throws MDNaoEncontradoException {
        for (MaterialDidatico md : materiaisDidaticos) {
            if (md.getId() == id) {
                return md;
            }
        }
        throw new MDNaoEncontradoException("Material didático com o id " + id + " não cadastrado!");
    }

    public void atualizarMD(MaterialDidatico materialAtualizado) {
        for (int i = 0; i < materiaisDidaticos.size(); i++) {
            if (materiaisDidaticos.get(i).getId() == materialAtualizado.getId()) {
                materiaisDidaticos.set(i, materialAtualizado);
                return;
            }
        }
    }

    // MÉTODO COM THROWS
    public void removerMD(int id) throws MDNaoEncontradoException {
        boolean removeu = materiaisDidaticos.removeIf(material -> material.getId() == id);
        if (!removeu) {
        }
        throw new MDNaoEncontradoException("Material didático com o id " + id + " não cadastrado!");
    }

    // MÉTODO COM THROWS
//    public void listarLivros() throws MDNaoEncontradoException {
//        if(livros.isEmpty()) {
//            throw new MDNaoEncontradoException("Nenhum material didático cadastrado!");
//        }
//        for (Livro livro : livros) {
//            System.out.println(livro.toString());
//        }
//    }
    public void listarMateriaisDidaticos() throws MDNaoEncontradoException {
        if(materiaisDidaticos.isEmpty()) {
            throw new MDNaoEncontradoException("Nenhum material didático cadastrado!");
        }
        for (MaterialDidatico material : materiaisDidaticos) {
            System.out.println(materiaisDidaticos.toString());
        }
    }

    // IMPORTACAO DE ARQUIVO
    public void importaLivros(String arquivo) {
        try {
            List<String> linhas = Files.readAllLines(Paths.get(arquivo));
            for (int i = 1; i < linhas.size(); i++) {
                String linha = linhas.get(i).replace("\"", "");
                String[] dadosLivro = linha.split("\t");
                int id = Integer.parseInt(dadosLivro[0].trim());
                String titulo = dadosLivro[1].trim();
                String autor = dadosLivro[2].trim();
                String tipo = dadosLivro[3].trim();
                String seguimento = dadosLivro[5].trim();
                String ISBN = dadosLivro[6].trim();
                float valor = Float.parseFloat(dadosLivro[7].trim());
                int quantidade = Integer.parseInt(dadosLivro[9].trim());
                int edicao = Integer.parseInt(dadosLivro[10].trim());

                Livro novoLivro = new Livro(id, titulo, tipo, seguimento, valor, quantidade, autor, ISBN, edicao);
                this.adicionarMD(novoLivro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void importaApostilas(String arquivo) {
        try {
            List<String> linhas = Files.readAllLines(Paths.get(arquivo));
            for (int i = 1; i < linhas.size(); i++) {
                String linha = linhas.get(i).replace("\"", "");
                String[] dadosLivro = linha.split("\t");
                int id = Integer.parseInt(dadosLivro[0].trim());
                String titulo = dadosLivro[1].trim();
                String tipo = dadosLivro[2].trim();
                String seguimento = dadosLivro[3].trim();
                float valor = Float.parseFloat(dadosLivro[4].trim());
                int quantidade = Integer.parseInt(dadosLivro[5].trim());
                int volume = Integer.parseInt(dadosLivro[6].trim());
                String SKU = dadosLivro[7].trim();

                Apostila novaApostila = new Apostila(id, titulo, tipo, seguimento, valor, quantidade, volume, SKU);
                this.adicionarMD(novaApostila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // EXPORTAÇÃO DE ARQUIVOS
    public void exportaLivros(String arquivoExportacao) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(arquivoExportacao));
            writer.write(
                    "id\ttitulo\tautor\ttipo\tdescricao\tseguimento\tISBN\tvalor\tvolume\tquantidade\tedicao\n");
            for (Livro livro : livros) {
                writer.write(livro.getId() + "\t"
                        + livro.getTitulo() + "\t"
                        + livro.getAutor() + "\t"
                        + livro.getEdicao() + "\t"
                        + livro.getISBN() + "\t"
                        + livro.getTipo() + "\t"
                        + livro.getSeguimento() + "\t"
                        + livro.getValor() + "\t"
                        + livro.getQuantidade() + "\t"
                        + livro.getEdicao() + "\t"
                );
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //IMPLEMENTAÇÃO DE MAP
    public void imprimeRelatorioISBN() throws MDNaoEncontradoException {
        for (Map.Entry<String, List<Livro>> entrada : livrosPorISBN.entrySet()) {
            System.out.println("ISBN: " + entrada.getKey());
            for (Livro material : entrada.getValue()) {
                System.out.println("Título: " + material.getTitulo());
            }
            System.out.println();
        }
        throw new MDNaoEncontradoException("Nenhum material didático cadastrado!");
    }
    @Override
    public void imprimir() {

    }
}
