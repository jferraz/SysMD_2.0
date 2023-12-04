package controller;

import model.Apostila;
import model.Livro;
import model.MaterialDidatico;
import util.MDNaoEncontradoException;

import java.util.Scanner;

public class MenuController {
    private MaterialDidaticoController mdController;

    public MenuController(MaterialDidaticoController mdController){
        this.mdController = mdController;
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

    public void consultaMD(){
        try {
            System.out.println("Insira o Id do Livro que deseja buscar: ");
            int idLivro = sc.nextInt();
            sc.nextLine();
            MaterialDidatico livro = mdController.buscaMDporId(idLivro);
            System.out.println("Livro " + livro);
        } catch (MDNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
    public void consultaTodosMd(){
        try {
            mdController.listarMateriaisDidaticos();
        } catch (MDNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
    public void importaMD(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseja importar um livro ou uma apostila?\n 1 - Livro \n 2 - Apostila");
        int opcao = sc.nextInt();
        if(opcao == 1){
            String arquivo = "C:\\Users\\jborg\\OneDrive\\Documentos\\livros.txt";
            mdController.importaLivros(arquivo);
        }
        else if(opcao == 2){
            String arquivo = "C:\\Users\\jborg\\OneDrive\\Documentos\\apostilas.txt";
            mdController.importaApostilas(arquivo);
        }
        else System.out.println("Opção inválida!");;
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
        String arquivoExportacao = "C:\\Users\\jborg\\OneDrive\\Documentos\\livros_exportados.txt"; // Defina o caminho para exportação
        mdController.exportaLivros(arquivoExportacao);
        System.out.println("Livros exportados para " + arquivoExportacao);
    }
    public void exportaLivroISBN(){
        try {
            mdController.imprimeRelatorioISBN();
        } catch (MDNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editaMD(){
        System.out.println("Edição de materiais didáticos\n\n");
        System.out.println("Insira os novos dados:\n\n");
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
    }

    public void relatorioFinanceiro() {
    }
}
