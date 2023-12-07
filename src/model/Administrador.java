package model;

public class Administrador extends Usuario{

    public Administrador(int id, String nome, String CPF, String email, String senha, String usuario, String cargo) {
        super(id, nome, CPF, email, senha, usuario, cargo);
    }
    public Administrador(String usuario, String email, String cargo, String senha) {
        super();

    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public String getCPF() {
        return super.getCPF();
    }

    @Override
    public void setCPF(String CPF) {
        super.setCPF(CPF);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getSenha() {
        return super.getSenha();
    }

    @Override
    public void setSenha(String senha) {
        super.setSenha(senha);
    }

    @Override
    public String getUsuario() {
        return super.getUsuario();
    }

    @Override
    public void setUsuario(String usuario) {
        super.setUsuario(usuario);
    }

    @Override
    public String getCargo() {
        return super.getCargo();
    }

    @Override
    public void setCargo(String cargo) {
        super.setCargo(cargo);
    }

    @Override
    public boolean autenticar(String nome, String senha) {
        return super.autenticar(nome, senha);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
