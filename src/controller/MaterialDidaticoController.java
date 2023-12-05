package controller;

import model.*;
import util.MDNaoEncontradoException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MaterialDidaticoController implements Imprimivel {
    private List<Livro> livros;
    private List<Apostila> apostilas;
    private List<MaterialDidatico> materiaisDidaticos;
    private Map<String, List<MaterialDidatico>> livroPorISBN = new HashMap<>();
    private Map<String, List<MaterialDidatico>> apostilasPorSKU = new HashMap<>();

    Scanner sc = new Scanner(System.in);

    public MaterialDidaticoController() {
        this.materiaisDidaticos = new ArrayList<>();
        this.livros = new ArrayList<>();
        this.apostilas = new ArrayList<>();
    }

    public void adicionarMD(MaterialDidatico material) {
        if (material instanceof Livro) {
            Livro livro = (Livro) material;//DOWNCASTING
            livroPorISBN.computeIfAbsent(livro.getISBN(), k -> new ArrayList<>()).add(livro);
        } else if (material instanceof Apostila) {
            Apostila apostila = (Apostila) material;
            apostilasPorSKU.computeIfAbsent(apostila.getSKU(), k -> new ArrayList<>()).add(apostila);
        }
        materiaisDidaticos.add(material);
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
            System.out.println(material.toString());
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

    public void editaLivro(int idLivro) {
        //Livro editLivro = null;
        for(MaterialDidatico material : materiaisDidaticos) {
            if (material.getId() == idLivro) {
                Livro editLivro = (Livro) material;//DOWNCAST

                System.out.println("Insira os dados nos campos que deseja editar; deixe em branco o que não for editar.");
                System.out.println("Título");
                String titulo = sc.nextLine();
                editLivro.setTitulo(titulo);
                System.out.println("Autor: ");
                String autor = sc.nextLine();
                editLivro.setAutor(autor);
                System.out.println("Tipo: ");
                String tipo = sc.nextLine();
                editLivro.setTipo(tipo);
                System.out.println("Seguimento: ");
                String seguimento = sc.nextLine();
                editLivro.setSeguimento(seguimento);
                System.out.println("ISBN: ");
                String ISBN = sc.nextLine();
                editLivro.setISBN(ISBN);
                System.out.println("Valor: ");
                float valor = sc.nextInt();
                editLivro.setValor(valor);
                sc.nextLine();
                System.out.println("Quantidade: ");
                int quantidade = sc.nextInt();
                editLivro.setQuantidade(quantidade);
                sc.nextLine();
                System.out.println("Edicao: ");
                int edicao = sc.nextInt();
                editLivro.setEdicao(edicao);
                sc.nextLine();

                System.out.println("Livro atualizado com sucesso!");
            }
        }
    }

    public void editApostila(int idApostila) {
        for(MaterialDidatico material : materiaisDidaticos){
            if(material.getId() == idApostila) {
                Apostila editApostila = (Apostila) material;

                System.out.println("Insira os dados nos campos que deseja editar; deixe em branco o que não for editar.");
                System.out.println("Título: ");
                String titulo = sc.nextLine();
                editApostila.setTitulo(titulo);
                System.out.println("Tipo: ");
                String tipo = sc.nextLine();
                editApostila.setTipo(tipo);
                System.out.println("Seguimento: ");
                String seguimento = sc.nextLine();
                editApostila.setSeguimento(seguimento);
                System.out.println("SKU: ");
                String SKU = sc.nextLine();
                editApostila.setSKU(SKU);
                System.out.println("Valor: ");
                float valor = sc.nextInt();
                editApostila.setValor(valor);
                sc.nextLine();
                System.out.println("Quantidade: ");
                int quantidade = sc.nextInt();
                editApostila.setQuantidade(quantidade);
                sc.nextLine();
                System.out.println("Volume: ");
                int volume = sc.nextInt();
                editApostila.setVolume(volume);
                sc.nextLine();

                System.out.println("Apostila atualizada com sucesso!");
            }
        }
    }

    @Override
    public void imprimir() {

    }
}
