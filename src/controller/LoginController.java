package controller;

import model.Autenticavel;
import model.Usuario;
import util.LoginException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginController {
    private List<Usuario> usuarios;

    public LoginController(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario autenticar(String nome, String senha) throws LoginException {
        for (Usuario usr : usuarios) {
            if (usr.autenticar(nome, senha)) {
                System.out.println("Sucesso!");
                return usr;
            }
        }
        throw new LoginException("Credenciais incorretas.");
    }
}
