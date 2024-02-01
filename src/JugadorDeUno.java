public class JugadorDeUno {

    private String nombreJugador;
    private ManoDeUno manoDeUnoDeEsteJugador;
    public JugadorDeUno (String nombreJugador, int numeroCartas) {
        this.nombreJugador = nombreJugador;
        this.manoDeUnoDeEsteJugador = new ManoDeUno(numeroCartas);
    }

    public String getNombre () {return nombreJugador;}

    public boolean sinCartasEnLaMano () {
        return manoDeUnoDeEsteJugador.estaVacia();
    }

    public void cogeCartas (PilaDeCartas pilaDeCartas, int numeroDeCartasACoger) {
        for (int i = 0; i < numeroDeCartasACoger; i++) {
            Carta cartaCogida = pilaDeCartas.extraerCartaParteSuperior();
            manoDeUnoDeEsteJugador.agregarCarta(cartaCogida);
        }
    }

    public void juega (PilaDeCartas, PilaDeCartas) {

    }
}
