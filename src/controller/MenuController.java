package controller;

import model.Apostila;
import model.Livro;
import model.MaterialDidatico;
import util.MDNaoEncontradoException;

import java.io.IOException;
import java.util.Scanner;

public class MenuController {
    private MaterialDidaticoController mdController;
    public RelatorioController rcController;

    public MenuController(MaterialDidaticoController mdController){
        this.mdController = mdController;
        this.rcController = new RelatorioController();
        this.sc = new Scanner(System.in);
    }

    Scanner sc = new Scanner(System.in);
    public void cadastraMaterialDidatico(){
        System.out.println("Selecione o tipo de material didático a cadastrar:\n\n1 - Livro \n2 - Apostila ");
        int md = sc.nextInt();
        if(md == 1){
            System.out.println("Insira os dados do livro\n\n");
            System.out.println("Id:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Título: ");
            String titulo = sc.nextLine();
            System.out.println("Autor: ");
            String autor = sc.nextLine();
            System.out.println("Tipo: ");
            String tipo = sc.nextLine();
            System.out.println("Seguimento: ");
            String seguimento = sc.nextLine();
            System.out.println("ISBN: ");
            String ISBN = sc.nextLine();
            System.out.println("Valor: ");
            float valor = sc.nextInt();
            sc.nextLine();
            System.out.println("Quantidade: ");
            int quantidade = sc.nextInt();
            sc.nextLine();
            System.out.println("Edicao: ");
            int edicao = sc.nextInt();
            sc.nextLine();

            Livro novoLivro = new Livro(id, titulo, tipo, seguimento, valor, quantidade, autor, ISBN, edicao);
            mdController.adicionarMD(novoLivro);
        }
        if(md == 2){
            System.out.println("Insira os dados da apostila\n\n");
            System.out.println("Id:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Título: ");
            String titulo = sc.nextLine();
            System.out.println("Autor: ");
            String tipo = sc.nextLine();
            System.out.println("Seguimento: ");
            String seguimento = sc.nextLine();
            System.out.println("SKU: ");
            String SKU = sc.nextLine();
            System.out.println("Valor: ");
            float valor = sc.nextInt();
            sc.nextLine();
            System.out.println("Quantidade: ");
            int quantidade = sc.nextInt();
            sc.nextLine();
            System.out.println("Volume: ");
            int volume = sc.nextInt();
            sc.nextLine();

            Apostila novaApostila = new Apostila(id, titulo, tipo, seguimento, valor, quantidade, volume, SKU);
            mdController.adicionarMD(novaApostila);
        }
        else System.out.println("Opção inválida!");

    }
    //CONSULTAS
    public void consultas() throws MDNaoEncontradoException {
        System.out.println("Selecione a consulta desejada: \n1 - Livro por ID\n2 - Todos os livros\n3 - Apostila por ID\n4 - Todas as apostilas\n5 - Todos MD");
        int opcao = sc.nextInt();
        if(opcao == 1){
            System.out.println("Insira o Id do livro que deseja buscar: ");
            int idLivro = sc.nextInt();
            sc.nextLine();
            MaterialDidatico livro = mdController.buscaLivroPorId(idLivro);
            System.out.println("Livro " + livro);
        }
        if(opcao == 2){
            rcController.imprimeLivros();
        }
        if(opcao == 3){
            System.out.println("Insira o Id da apostila que deseja buscar: ");
            int idApostila = sc.nextInt();
            sc.nextLine();
            MaterialDidatico apostila = mdController.buscaApostilaPorId(idApostila);
            System.out.println("Apostila: " + idApostila);
        }
        if(opcao == 4){
            rcController.imprimeApostilas();
        }
        if(opcao == 5){
            try{
                rcController.listarMateriaisDidaticos();
            }catch(MDNaoEncontradoException e){
                System.out.println(e.getMessage());
            }

        }
    }

    public void importaMD(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseja importar um livro ou uma apostila?\n 1 - Livro \n 2 - Apostila");
        int opcao = sc.nextInt();
        try {
            if (opcao == 1) {
                String arquivo = "E:\\Estudo\\SysMD\\SysMD_2.0\\src\\livros.txt";
                mdController.importaLivros(arquivo);
                System.out.println("Livros importados com sucesso!" + arquivo);
            } else if (opcao == 2) {
                String arquivo = "C:\\Estudo\\apostilas.txt"; //"C:\\Users\\jborg\\OneDrive\\Documentos\\apostilas.txt";
                mdController.importaApostilas(arquivo);
                System.out.println("Apostilas importadas com sucesso!");
            } else System.out.println("Opção inválida!");

        } catch (MDNaoEncontradoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro desconhecido durante a importação: "+ e.getMessage());
        }
    }
    public void excluiMD(){
        try {
            System.out.println("Insira o Id que deseja excluir: ");
            int idLivro = sc.nextInt();
            sc.nextLine();
            mdController.removerMD(idLivro);
        } catch (MDNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
    public void exportaRelacaoMD(){
        String arquivoExportacao = "C:\\Users\\jborg\\OneDrive\\Documentos\\livros_exportados.txt";
        //String arquivoExportacao = "C:\\Users\\jborg\\Documents\\livros_exportados.txt";
        mdController.exportaLivros(arquivoExportacao);
        System.out.println("Livros exportados para " + arquivoExportacao);
    }
    public void exportaLivroISBN(){
        try {
            rcController.imprimeRelatorioISBN();
        } catch (MDNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void exportaApostilaSKU(){
        try{
            rcController.imprimeRelatorioSKU();
        } catch (MDNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editaMD() {
        System.out.println("Selecione o tipo de material a ser editado: \n1 - Livro \n2 - Apostila");
        int opcao = sc.nextInt();
        if(opcao == 1) {
            System.out.println("Insira o Id do livro a ser editado");
            int idLivro = sc.nextInt();
            mdController.editaLivro(idLivro);
        }
        else if(opcao == 2 ){
            System.out.println("Insira o Id da apostila a ser editada");
            int idApostila = sc.nextInt();
            mdController.editApostila(idApostila);
        }
    }

    public void relatorioFinanceiro() {
        rcController.relatorios.gerarRelatorio();
    }
}
