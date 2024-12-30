package tema3.cola.circular;

/**
 *
 * @author Manuel
 */
public class ColaCircular {
    int ini, fin, contIns;
    String dato[];
    
    public ColaCircular() {
        dato = new String[5];
        ini = fin = contIns = 0;
    }
    
    public ColaCircular(int total) {
        dato = new String[total];
        ini = fin = contIns = 0;
    }
    
    public void insertar(String s) {
        if (!llena()) {
            dato[fin] = s;
            fin = (fin + 1) % dato.length;
            contIns++;
        }
    }
    
    public String eliminar() {
        String aux = "";
        if (!vacia()) {
            aux = dato[ini];
            dato[ini] = "";
            ini = (ini + 1) % dato.length;
            contIns--;
        }
        return aux;
    }
    
    public boolean vacia() {
        return (contIns == 0);
    }
    
    public boolean llena() {
        return (contIns == dato.length);
    }
    
    public void mostrar() {
        System.out.println("pos\tdato\n---\t----");
        for (int pos = 0; pos < dato.length; pos++) {
            System.out.println(" " + pos + "\t" + dato[pos]);
        }
        System.out.println("\nIni = " + ini);
        System.out.println("Fin = " + fin + "\n");
    }
    
    public void menu() {
        
    }
}
