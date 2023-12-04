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
}
