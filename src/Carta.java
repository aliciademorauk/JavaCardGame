public class Carta {

    private final String letra;
    private final int valor;
    private final String identificador;

    public Carta (int valor, String letra) {
        this.valor = valor;
        this.letra = letra;
        this.identificador = valor + letra;
    }

    public String getIdentificador () {
        return identificador;
    }
    public boolean sePuedeApilarSobreCarta (Carta otraCarta) {
        return this.letra.equals(otraCarta.letra) || this.valor == otraCarta.valor;
    }
}
