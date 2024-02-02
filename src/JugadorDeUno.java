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

    public void juega (PilaDeCartas pilaDeCartas, PilaDeCartas cartasDesechadas) {
        Carta cartaDePilaTiradas = cartasDesechadas.verCartaParteSuperior();
        Carta cartaADesechar = manoDeUnoDeEsteJugador.extraerCartaApilableSobre(cartaDePilaTiradas);
        if (cartaADesechar != null) {
            cartasDesechadas.agregarCarta(cartaADesechar);
            System.out.println("Has podido apilar.");
        }
        else {
            Carta cartaASumarAMano = pilaDeCartas.extraerCartaParteSuperior();
            manoDeUnoDeEsteJugador.agregarCarta(cartaASumarAMano);
            System.out.println("No has podido apilar y ahora tienes una carta más en tu mano.");
        }
    }
}
