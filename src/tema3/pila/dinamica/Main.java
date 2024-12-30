package tema3.pila.dinamica;

/**
 *
 * @author Manuel
 */
public class Main {
    public static void main(String[] args) {
        PilaDinamica pila = new PilaDinamica();
    
        pila.mostrar();
        System.out.println("");
        
        pila.meter(2);
        pila.meter(4);
        pila.meter(6);
        pila.mostrar();
        System.out.println("");
        
        pila.sacar();
        pila.mostrarRec(pila.tope, 0);
    }
}
