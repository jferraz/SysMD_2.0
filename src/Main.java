import controller.LoginController;
import controller.MaterialDidaticoController;
import controller.MenuController;
import controller.RelatorioController;
import model.*;
import util.LoginException;
import util.MDNaoEncontradoException;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Livro> livros = new ArrayList<>();
    private static MaterialDidaticoController mdController = new MaterialDidaticoController();
    private static Usuario usuarioAutenticado = null;
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) throws MDNaoEncontradoException {
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
            String usuario = sc.nextLine();
            System.out.println("Senha");
            String senha = sc.nextLine();

            try {
                usuarioAutenticado = loginController.autenticar(usuario, senha);
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

    public static void mostraMenuPrincipal(Usuario usuario) throws MDNaoEncontradoException {
        MenuController menuController = new MenuController(mdController);
        LoginController login = new LoginController(usuarios);
        RelatorioController relatorio = new RelatorioController();
        RelatorioLogAcesso relatLog = new RelatorioLogAcesso();
        RelatorioFinanceiro relFin = new RelatorioFinanceiro();
        Scanner sc = new Scanner(System.in);
        boolean fim = false;

        while (!fim) {
            System.out.println("\n************************************************************");
            System.out.println("|               SysMD - Selecione uma opção:               |");
            System.out.println("************************************************************");
            System.out.println("| Usuário: " + usuario.getNome() + "");
            System.out.println("| 1 - Cadastro de Materiais Didáticos");
            System.out.println("| 2 - Consultas de MD");
            System.out.println("| 3 - Edita MD");
            System.out.println("| 4 - Importa MD");

            if ("Administrador".equals(usuario.getCargo())) {
                System.out.println("| 5 - Excluir MD");
            }
            if ("Administrador".equals(usuario.getCargo())) {
                System.out.println("| 6 - Relatório financeiro");
            }

            System.out.println("| 7 - Exporta relatório em arquivo ");
            System.out.println("| 8 - Imprime MD por ISBN & Título");

            if ("Administrador".equals(usuario.getCargo())) {
                System.out.println("| 9 - Log de acessos");
            }

            System.out.println("| 10 - Sair");
            System.out.println("**********************************************************\n");

            String opcao = sc.nextLine();

            switch (opcao) {

                case "1":
                    menuController.cadastraMaterialDidatico();
                    break;
                case "2":
                    menuController.consultas();
                    break;
                case "3":
                    menuController.editaMD();
                    break;
                case "4":
                    menuController.importaMD();
                    break;
                case "5":
                    menuController.excluiMD();
                    break;
                case "6":
                    relFin.imprimir();
                    break;
                case "7":
                    menuController.exportarDados();
                    break;
                case "8":
                    menuController.imprimeRelatorioMAP();
                    break;
                case "9":
                    login.getLogAcessos();
                    break;
                case "10":
                    fim = true;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;

            }
            if (!fim) {
                aguardaEnter(sc);
            }
        }
    }
    private static void aguardaEnter(Scanner scanner) {
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }
}
