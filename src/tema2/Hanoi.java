package tema2;

/**
 *
 * @author Manuel
 */
public class Hanoi {
    
    public static void main(String[] args) {
        hanoi(3, "ORIGEN", "AUXILIAR", "DESTINO");
    }
    
    public static void hanoi(int discos, String origen, String auxiliar, String destino) {
        if (discos == 1) {
            System.out.println(" Mover disco de la torre " + origen + " a la torre " + destino);
        }
        else {
            hanoi(discos-1, origen, destino, auxiliar);
            System.out.println(" Mover disco de la torre " + origen + " a la torre " + destino);
            hanoi(discos-1, auxiliar, origen, destino);
        }
    }
}
