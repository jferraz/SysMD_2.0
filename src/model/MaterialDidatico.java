package model;

public abstract class MaterialDidatico {
    private int id;
    private String titulo;
    private String tipo;
    private String seguimento;
    private float valor;
    private int quantidade;

    public MaterialDidatico(int id, String titulo, String tipo, String seguimento, float valor, int quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.seguimento = seguimento;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public MaterialDidatico() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSeguimento() {
        return seguimento;
    }

    public void setSeguimento(String seguimento) {
        this.seguimento = seguimento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    public void setValor(String valor) {
        try {
            this.valor = Float.parseFloat(valor);
        } catch (NumberFormatException e) {
            this.valor = 0.0f;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "\nRelação de materiais didáticos: " +
                "\nId: " + id +
                "\nTítulo: " + titulo +
                "\nTipo: " + tipo +
                "\nSeguimento: " + seguimento +
                "\nValor: " + valor +
                "\nQuantidade: " + quantidade;
    }
}
