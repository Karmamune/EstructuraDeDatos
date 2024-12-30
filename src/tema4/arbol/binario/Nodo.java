package tema4.arbol.binario;

/**
 *
 * @author Manuel
 */
public class Nodo {
    char dato;
    Nodo hijoIzq;
    Nodo hijoDer;
    
    public Nodo() {
        dato = ' ';
        hijoIzq = null;
        hijoDer = null;
    }
    
    public Nodo(char dato) {
        this.dato = dato;
        hijoIzq = null;
        hijoDer = null;
    }
}
