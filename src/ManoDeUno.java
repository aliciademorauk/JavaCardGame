public class ManoDeUno {
    private Carta[] cartasEnMano;

    public ManoDeUno (int maxCartasEnMano) {
        this.cartasEnMano = new Carta[maxCartasEnMano];
    }

    public boolean estaVacia () {
        for (Carta carta : cartasEnMano) {
            if (carta != null) {return false;}
        }
        return true;
    }

    public void agregarCarta(Carta otraCarta) {
        int i = 0;
        while (cartasEnMano[i] != null) i++;
        cartasEnMano[i] = otraCarta;
    }

    public Carta extraerCartaApilableSobre (Carta cartaSobreLaQueHayQueApilar) {
        for (int i = 0; i < cartasEnMano.length; i++) {
            if (cartasEnMano[i] != null) {
                if (cartasEnMano[i].sePuedeApilarSobreCarta(cartaSobreLaQueHayQueApilar)) {
                    Carta carta = cartasEnMano[i];
                    cartasEnMano[i] = null;
                    return carta;
                }
            }
        }
        return null;
    }

    public String getMano () {
        StringBuilder mano = new StringBuilder("La mano del jugador es: ");
        for (Carta carta : cartasEnMano) {
            if (carta != null) {
                mano.append(String.format(carta.getIdentificador() + ", "));
            }
        }
        if (mano.isEmpty()) {
            return "Sin cartas.";
        }
        mano.delete(mano.length() - 2, mano.length());
        return mano.toString();
    }
}