public class ManoDeUno {
    private Carta[] cartasEnMano;

    private int numeroCartasEnMano;

    public ManoDeUno (int maxCartasEnMano) {
        numeroCartasEnMano = 0;
        this.cartasEnMano = new Carta[maxCartasEnMano];
    }

    public boolean estaVacia () {
        return numeroCartasEnMano ==  0;
    }

    public void agregarCarta(Carta otraCarta) {
        cartasEnMano[numeroCartasEnMano] = otraCarta;
        numeroCartasEnMano ++;
    }

    public Carta extraerCartaApilableSobre (Carta otraCarta) {


    }

    public String getMano () {
        StringBuilder mano = new StringBuilder("La mano del jugador es: ");
        for (Carta carta : cartasEnMano) {
            mano.append(String.format(carta.getIdentificador() + ", "));
        }
        return mano.toString();
    }
}