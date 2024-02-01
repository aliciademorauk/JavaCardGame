import java.util.Random;

public class PilaDeCartas {
    private Carta[] pila;
    private int cartasAlmacenadas;

    public PilaDeCartas (int maxCartas) {
        this.cartasAlmacenadas = 0;
        this.pila = new Carta[maxCartas];
    }
    public boolean hayCartasDisponibles () {
        return cartasAlmacenadas > 0;
    }

    // LIFO: agregamos carta en el ultimo elemento de la pila (i.e. en el primer elemento que sea null) y extraemos carta siempre por la parte superior (i.e. cogemos la carta en el ultimo indice)
    public void agregarCarta (Carta otraCarta) {
        pila[cartasAlmacenadas] = otraCarta;
        cartasAlmacenadas++;
    }

    public Carta extraerCartaParteSuperior () {
        Carta cartaExtraida = pila[cartasAlmacenadas - 1];
        // Se desecha la carta extraida:
        pila[cartasAlmacenadas - 1] = null;
        cartasAlmacenadas --;
        return cartaExtraida;
    }

    public Carta verCartaParteSuperior () {
        return  pila[cartasAlmacenadas - 1];
    }

    public void barajar () {
        Random generadorAleatorio = new Random();
        int indiceAleatorio;
        for (int i = cartasAlmacenadas - 1; i > 1; i--) {
            Carta cartaIntercambio= pila[i];
            indiceAleatorio = generadorAleatorio.nextInt(i);
            pila[i] = pila[indiceAleatorio];
            pila[indiceAleatorio] = cartaIntercambio;
        }
    }
}
