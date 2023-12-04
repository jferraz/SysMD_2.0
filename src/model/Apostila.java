package model;

public class Apostila extends MaterialDidatico{
    private int volume;
    private String SKU;

    public Apostila(int id, String titulo, String tipo, String seguimento, float valor, int quantidade, int volume, String SKU) {
        super(id, titulo, tipo, seguimento, valor, quantidade);
        this.volume = volume;
        this.SKU = SKU;
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
    public String toString() {
        return "Apostila{" +
                "volume=" + volume +
                ", SKU='" + SKU + '\'' +
                '}';
    }
}
