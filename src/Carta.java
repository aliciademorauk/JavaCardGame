public class Carta {
    private final String letra;
    private final int valor;

    public Carta (int valor, String letra) {
        this.valor = valor;
        this.letra = letra;
    }

    public String getIdentificador () {
        return valor + letra;
    }
    public boolean sePuedeApilarSobreCarta (Carta otraCarta) {
        return this.letra.equals(otraCarta.letra) || this.valor == otraCarta.valor;
    }
}
