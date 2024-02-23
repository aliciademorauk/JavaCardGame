public class JugadorDeUno {
    private String nombreJugador;
    private ManoDeUno manoDeUnoDeEsteJugador;
    public JugadorDeUno (String nombreJugador, int numeroCartasInicialParaCoger) {
        this.nombreJugador = nombreJugador;
        this.manoDeUnoDeEsteJugador = new ManoDeUno(numeroCartasInicialParaCoger);
    }

    public String getNombre () {return nombreJugador;}

    public boolean sinCartasEnLaMano () {
        return manoDeUnoDeEsteJugador.estaVacia();
    }

    public void cogeCartas (PilaDeCartas pilaDeCartas, int numeroDeCartasACoger) {
        for (int i = 0; i < numeroDeCartasACoger; i++) {
            if (pilaDeCartas.hayCartasDisponibles()) {
                Carta cartaCogida = pilaDeCartas.extraerCartaParteSuperior();
                manoDeUnoDeEsteJugador.agregarCarta(cartaCogida);
            }
        }
    }

    public void juega (PilaDeCartas pilaDeCartas, PilaDeCartas cartasDesechadas) {
        Carta cartaCimaPilaTiradas = cartasDesechadas.verCartaParteSuperior();
        System.out.printf("Hay que sacar carta para un %s.\nLa mano del jugador es: %s.\n", cartaCimaPilaTiradas.getIdentificador(), manoDeUnoDeEsteJugador.getMano());
        Carta cartaADesechar = manoDeUnoDeEsteJugador.extraerCartaApilableSobre(cartaCimaPilaTiradas);
        if (cartaADesechar != null) {
            System.out.println("Tengo carta válida en la mano.");
            cartasDesechadas.agregarCarta(cartaADesechar);
        }
        else {
            System.out.println("No tengo carta válida en la mano, cojo carta...");
            Carta cartaASumarAMano = pilaDeCartas.extraerCartaParteSuperior();
            if (cartaASumarAMano != null) {
                manoDeUnoDeEsteJugador.agregarCarta(cartaASumarAMano);
                Carta segundaCartaADesechar = manoDeUnoDeEsteJugador.extraerCartaApilableSobre(cartaCimaPilaTiradas);
                if (segundaCartaADesechar != null) {
                    System.out.printf("Ahora sí tengo carta válida en la mano: %s.", cartaASumarAMano.getIdentificador());
                    cartasDesechadas.agregarCarta(segundaCartaADesechar);
                }
                else {
                    System.out.println("Tampoco puedo jugar tras coger una carta.");
                }
            }
        }
    }
}
