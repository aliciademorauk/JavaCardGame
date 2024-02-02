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
        boolean cartaAgregada = false;
        for (int i = 0; i < cartasEnMano.length && !cartaAgregada; i++) {
            if (cartasEnMano[i] == null) {
                cartasEnMano[i] = otraCarta;
                cartaAgregada = true;
            }
        }
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