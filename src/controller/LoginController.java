package controller;

import model.Autenticavel;
import model.LogAcesso;
import model.Usuario;
import util.LoginException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LoginController {
    private List<Usuario> usuarios;
    private static List<LogAcesso> logAcessos = new ArrayList<>();

    public LoginController(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario autenticar(String usuario, String senha) throws LoginException {
        for (Usuario usr : usuarios) {
            boolean sucesso = usr.autenticar(usuario, senha);
            logAcessos.add(new LogAcesso(usuario, new Date(), sucesso));
            if (sucesso) {
                System.out.println("Sucesso!");
                return usr;
            }
        }
        throw new LoginException("Credenciais incorretas.");
    }

    public List<LogAcesso> getLogAcessos() {
        System.out.println("Número de acessos: " + logAcessos.size());
        System.out.println(logAcessos);
        return logAcessos;
    }
}
