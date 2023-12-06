package model;

public class Apostila extends MaterialDidatico{
    private int volume;
    private String SKU;

    public Apostila(int id, String titulo, String tipo, String seguimento, float valor, int quantidade, int volume, String SKU) {
        super();
        this.volume = volume;
        this.SKU = SKU;
    }

    public Apostila(String titulo, String seguimento){
        super();
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
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
                + " Tipo: " + super.getTipo()
                + " Seguimento: " + super.getSeguimento()
                + " Quantidade: " + super.getQuantidade()
                + " Valor: " + super.getValor()
                + " Volume: " + volume
                + " SKU: " + SKU;
    }
}
