package tema1.fila;

/**
 *
 * @author manuel
 */
public class Fila {
    Nodo ini, fin, nodo;
    
    public Fila() { ini = fin = null; }
    
    public void insertar(int id) {
        if (!llena()) {
            nodo = new Nodo();
            nodo.id = id;
            nodo.sig = null;
            
            if (ini == null) {
                ini = fin = nodo;
            }else {
                fin.sig = nodo;
                fin = nodo;
            }
        }
    }
    
    public void eliminar() {
        Nodo actual = ini;
        
        if (!vacia()) {
            ini = actual.sig;
            actual = null;
        } else
            System.out.println("La fila está vacía..");
    }
    
    public boolean vacia() {
        return (ini == null);
    }
    
    public boolean llena() {
        return (new Nodo() == null ? true : false);
    }
    
    public void mostrarFila() {
        Nodo actual = ini;
        
        if (!vacia()) {
            System.out.print("FILA: ");
            while (actual != null) {
                System.out.print(" " + actual.id);
                actual = actual.sig;
            }
            System.out.println("");
        }
        else
            System.out.println("La fila está vacía");
    }
}
