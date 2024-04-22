public class JuegoDelUNO {
	/*
	 * Instanciar la "pila de cartas para coger" y añadir tantas barajas completas a
	 * la pila de cartas como se haya solicitado en los parámetros del main. La pila
	 * se debe barajar. Instanciar la "pila de cartas tiradas". La carta inicial de
	 * esta pila se deberá extraer de la "pila de cartas para coger". Instanciar
	 * tantos jugadores como se haya solicitado en los parámetros del main.
	 * Cada jugador debe ser capaz de tener en su mano la totalidad de las cartas
	 * disponibles. Cada jugador cogerá de la "pila de cartas para coger" el número
	 * inicial de cartas en mano, que es el tercero de los parámetros del main. El
	 * juego otorga en orden, turno a cada jugador tantas veces como sea necesario,
	 * hasta que un jugador gane o hasta que no queden cartas en la
	 * "pila de cartas para coger". Cuando le toca el turno a un jugador, este juega
	 * usando las cartas de su mano y las de la "pila de cartas para coger"
	 * intentando apilarlas sobre la "pila de cartas tiradas". 
	 */
	
	public static void main(String[] args) {
		if(args.length != 3)
			System.out.println("Parámetros: <número de barajas a usar> <número de jugadores> <número inicial de cartas en mano>");
		else {
	        //parseInt es un método estético del envoltorio Integer que convierte en entero un String
			final int numBarajas = Integer.parseInt(args[0]);
			final int numJugadores = Integer.parseInt(args[1]);
			final int numInicialDeCartasEnMano = Integer.parseInt(args[2]);
			jugarPartidaDeUno(numBarajas, numJugadores, numInicialDeCartasEnMano);
		}
	}
	
	private static void jugarPartidaDeUno(int numBarajas, int numJugadores, int numInicialDeCartasEnMano) {
		final int[] VALORES = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		final String[] LETRAS = {"A", "B", "C", "D"};
		final int numeroDeCartasInicialEnPilaParaCoger = numBarajas * VALORES.length * LETRAS.length;
		
		
		// Preparar la pila de cartas para coger. Tantas barajas completas como se haya pedido.
		// Solo aquí se CREAN cartas. En el resto del juego se intercambian
		PilaDeCartas cartasParaCoger = new PilaDeCartas(numeroDeCartasInicialEnPilaParaCoger);
		for(int numB = 0; numB < numBarajas; numB++)
			for(int valor : VALORES )
				for(String letra : LETRAS)
					cartasParaCoger.agregarCarta(new Carta(valor, letra));

		// Barajar la pila del mazo
		cartasParaCoger.barajar();
		
		// Preparar pila de cartas ya tiradas. Una carta boca arriba al principio sacada de la pila para coger.
		// Mismo tama�o que el mazo de cartas.
		PilaDeCartas cartasTiradas = new PilaDeCartas(numeroDeCartasInicialEnPilaParaCoger);
		cartasTiradas.agregarCarta(cartasParaCoger.extraerCartaParteSuperior());
		
		// Preparar los jugadores de la partida
		// Array de tantos jugadores como haya indicado el usuario
		JugadorDeUno[] jugadores = new JugadorDeUno[numJugadores];
		for(int i = 0; i < numJugadores; i++) {
			// OJO: Previamente no se ha instanciado ningún jugador
			// Se instancian aquí
			jugadores[i] = new JugadorDeUno("Jugador " + (i+1), numeroDeCartasInicialEnPilaParaCoger);
			jugadores[i].cogeCartas(cartasParaCoger, numInicialDeCartasEnMano); 
			// El jugador coge las cartas iniciales del mazo de carta (cartasParaCoger)
		}
		
		// Secuenciación del juego
		System.out.println("Juego del UNO");
		System.out.println("Número de jugadores: " + jugadores.length);
		System.out.println("Pila de cartas para coger con " + numeroDeCartasInicialEnPilaParaCoger + " cartas.");
		System.out.println("Número inicial de cartas en mano: " + numInicialDeCartasEnMano + " cartas.\n");
		
		int indiceDeTurno = 0;
		JugadorDeUno jugador;
		do {
			jugador = jugadores[indiceDeTurno];
			System.out.println("Turno de: " + jugador.getNombre());
			jugador.juega(cartasParaCoger, cartasTiradas);  	
			indiceDeTurno = (indiceDeTurno + 1) % numJugadores; //actualizaci�n �ndice array jugadores!
		} while(!jugador.sinCartasEnLaMano() && cartasParaCoger.hayCartasDisponibles());

		// Recuerda utilizar los métodos de cada clase y no repetir código
		// El juego continúa mientras el jugador y el mazo sigan teniendo cartas
		// Si el jugador en turno se queda sin cartas o no quedan cartas en el mazo, se termina

		if(jugador.sinCartasEnLaMano())
			System.out.println("El ganador es: " + jugador.getNombre());
		else
			System.out.println("Se han acabado las cartas. No hay ganador.");
	}
}
