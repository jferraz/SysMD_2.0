package model;

public class Livro extends MaterialDidatico{
    private String autor;
    private String ISBN;
    private int edicao;

    public Livro(int id, String titulo, String tipo, String seguimento, float valor, int quantidade, String autor, String ISBN, int edicao) {
        super(id, titulo, tipo, seguimento, valor, quantidade);
        this.autor = autor;
        this.ISBN = ISBN;
        this.edicao = edicao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public void add(Livro livro) {
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
    public String getTitulo() {
        return super.getTitulo();
    }

    @Override
    public void setTitulo(String titulo) {
        super.setTitulo(titulo);
    }

    @Override
    public String getTipo() {
        return super.getTipo();
    }

    @Override
    public void setTipo(String tipo) {
        super.setTipo(tipo);
    }

    @Override
    public String getSeguimento() {
        return super.getSeguimento();
    }

    @Override
    public void setSeguimento(String seguimento) {
        super.setSeguimento(seguimento);
    }

    @Override
    public float getValor() {
        return super.getValor();
    }

    @Override
    public void setValor(float valor) {
        super.setValor(valor);
    }

    @Override
    public int getQuantidade() {
        return super.getQuantidade();
    }

    @Override
    public void setQuantidade(int quantidade) {
        super.setQuantidade(quantidade);
    }

    @Override
    public String toString() {
        return "ID: " + super.getId()
                + " Título: " + super.getTitulo()
                + " Autor: " + autor
                + " Edição: " + edicao
                + " Tipo: " + super.getTipo()
                + " Seguimento: " + super.getSeguimento()
                + " Quantidade: " + super.getQuantidade()
                + " Valor: " + super.getValor()
                + " ISBN: " + ISBN;
    }
}
