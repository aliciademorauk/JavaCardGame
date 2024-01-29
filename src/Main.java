
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

// Preguntas: clase barajar?; si quisiera mantener el codigo que esta commented out en el main, como podria configurarlo para que el usuario pudiera re-escribir el parametro en la terminal sin re-ejecutar
public class Main {
    public static void main(String[] args) {

        // Asegurarnos de que el usuario nos ha dado un número de barajas para la pila de cartas al ejecutar el programa
        if (args.length != 1 || !isValidNumber(args[0])) {
            System.out.println("Por favor, re-ejecuta el programa y escribe un único número válido como parametro para indicar el número de barajas.\n");
            System.exit(1);
        }

        // Definimos los valores necesarios para crear la pila
        final int numBarajas = Integer.parseInt(args[0]);
        final int[] valores = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        final String[] letras = {"A", "B", "C", "D",};
        final int numeroCartasInicial = numBarajas * valores.length * letras.length;

        System.out.printf("El número de barajas es %d y el número total de cartas es %d.\n", numBarajas, numeroCartasInicial);

        // Creamos la pila con el metodo agregarCarta
        PilaDeCartas pilaDeCartas = new PilaDeCartas(numeroCartasInicial);
        for (int i = 0; i < numBarajas; i++) {
            for (int valor : valores) {
                for (String letra : letras) {
                    pilaDeCartas.agregarCarta(new Carta(valor,letra));
                }
            }
        }

        // Se baraja el mazo
        pilaDeCartas.barajar();

        // Empieza el juego
        int numeroCartasApiladas = 0;

        while (pilaDeCartas.hayCartasDisponibles()) {
            Carta cartaSacada = pilaDeCartas.extraerCartaParteSuperior();
            String identificadorCartaSacada = cartaSacada.getIdentificador();
            if (pilaDeCartas.hayCartasDisponibles()) {
                Carta cartaCima = pilaDeCartas.verCartaParteSuperior();
                String identificadorCartaCima = cartaCima.getIdentificador();
                if (cartaSacada.sePuedeApilarSobreCarta(cartaCima)) {
                    System.out.printf("La carta sacada es %s.\n%s es apilable sobre la carta que está ahora en la cima, %s.\n", identificadorCartaSacada, identificadorCartaSacada, identificadorCartaCima);
                    numeroCartasApiladas++;
                }
                else {System.out.printf("La carta sacada es %s.\nLo siento, %s no es apilable sobre la carta que está ahora en la cima, %s.\n", identificadorCartaSacada, identificadorCartaSacada, identificadorCartaCima);
                }
            }
        }

        System.out.printf("El juego ha terminado. El número total de cartas apiladas es %d.\n", numeroCartasApiladas);
    }
    public static boolean isValidNumber(String valorArgs) {
        try {
            Integer.parseInt(valorArgs);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}