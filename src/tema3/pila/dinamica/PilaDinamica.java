package tema3.pila.dinamica;

/**
 *
 * @author Manuel
 */
public class PilaDinamica {
    Nodo tope, nodo;
    
    public PilaDinamica() {
        tope = null;
    }
    
    public void meter(int dato) {
        if (!llena()) {
            nodo = new Nodo();
            nodo.dato = dato;
            nodo.ant = tope;
            tope = nodo;
        }
        else {
            System.out.println("Pila llena");
        }
    }
    
    public void sacar() {
        if (!vacia()) {
            tope = tope.ant;
        }
        else {
            System.out.println("La pila está vacía");
        }
    }
    
    public boolean llena() {
        return (new Nodo()) == null;
    }
    
    public boolean vacia() {
        return tope == null;
    }
    
    public void mostrar() {
        Nodo aux = nodo;
        
        if (!vacia()) {
            System.out.println("PILA");
            while (aux != null) {
                System.out.println(" " + aux.dato);
                aux = aux.ant;
            }
        }
        else {
            System.out.println("La pila está vacía");
        }
    }
    
    public void mostrarRec(Nodo i, int a) {
        if (i != null) {
            if (a == 0) {
                System.out.print("PILA\n");
            }
            System.out.println(" " + i.dato);
            mostrarRec(i.ant, ++a);
        }
        else {
            System.out.println("");
        }
    }
}
