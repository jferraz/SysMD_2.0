import controller.LoginController;
import controller.MaterialDidaticoController;
import controller.MenuController;
import model.*;
import util.LoginException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Livro> livros = new ArrayList<>();
    private static MaterialDidaticoController mdController = new MaterialDidaticoController();
    private static Usuario usuarioAutenticado = null;
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        LoginController loginController = new LoginController(usuarios);

        usuarios.add(new Administrador(1, "admin", "000111222-99", "admin@sysmd.com", "adm123", "admin", "Administrador"));
        usuarios.add(new AuxiliarCompras(1, "aux_compras", "000111222-88", "aux@sysmd.com", "auxc123", "auxc", "AuxiliarCompras"));

        Scanner sc = new Scanner(System.in);
        boolean autenticado = false;
        Usuario usuarioAutenticado = null;
        int tentativa = 3;

        while (!autenticado && tentativa > 0) {

            System.out.println("\nSYSMD - Insira suas credenciais\n");
            System.out.println("Usuário");
            String nome = sc.nextLine();
            System.out.println("Senha");
            String senha = sc.nextLine();

            try {
                usuarioAutenticado = loginController.autenticar(nome, senha);
                autenticado = true;

            } catch (LoginException e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
                tentativa--;
                System.out.println("Restam " + tentativa + " tentativas.");
            }

        }

        if (autenticado) {
            mostraMenuPrincipal(usuarioAutenticado);
        } else {
            System.out.println("Credenciais incorretas... vaza!");
            sc.close();
        }
    }


    public static void mostraMenuPrincipal(Usuario usuario) {
        MenuController menuController = new MenuController(mdController);
        Scanner sc = new Scanner(System.in);
        boolean fim = false;

        while (!fim) {
            System.out.println("\nSYSMD - Selecione uma opção:\n");
            System.out.println("Usuário: " + usuario.getNome());
            if ("Administrador".equals(usuario.getCargo())) {
                System.out.println("1 - Cadastro de Materiais Didáticos");
            }
            System.out.println("2 - Consulta MD por id");
            System.out.println("3 - Consulta todos MD");
            System.out.println("4 - Edita MD");
            System.out.println("5 - Importa livros");
            if ("Administrador".equals(usuario.getCargo())) {
                System.out.println("6 - Excluir livros");
            }
            if ("Administrador".equals(usuario.getCargo())) {
                System.out.println("7 - Relatório financeiro");
            }
            System.out.println("8 - Exporta relatório");
            System.out.println("9 - Exporta livros por ISBN/Titulo/Autor");
            System.out.println("10 - Sair");

            String opcao = sc.nextLine();

            switch (opcao) {

                case "1":
                    menuController.cadastraMaterialDidatico();
                    break;
                case "2":
                    //menuController
                    break;
                case "3":
                    menuController.consultaTodosMd();
                    break;
                case "4":
                    menuController.editaMD();
                    break;
                case "5":
                    menuController.importaMD();
                    break;
                case "6":
                    menuController.excluiMD();
                    break;
                case "7":
                    menuController.relatorioFinanceiro();
                    break;
                case "8":
                    menuController.exportaRelacaoMD();
                    break;
                case "9":
                    menuController.exportaLivroISBN();
                    break;
                case "10":
                    fim = true;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;

            }
        }
    }
}
