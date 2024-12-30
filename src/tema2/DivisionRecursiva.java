package tema2;

/**
 *
 * @author manuel
 */
public class DivisionRecursiva {
    public static void main(String[] args) {
        System.out.println("Divisi�n: " +dR(10, 3));
        System.out.println("Residuo: " +dRR(10, 3));
    }
    
    /*
    x = primer número.
    y = segundo número.
    z = contador de cuantas veces se restó y a x.
    */
    
    public static int dR(int x, int y) {
        if (x == 0) {
            return 0;
        }
        else if (x < 0) {
            return -1;
        }
        else {
            x = x - y;
            return 1 + dR(x, y);
        }
    }
    
    public static int dRR(int x, int y) {
        if (x < y) {
            return x;
        }
        else {
            return dRR(x-y, y);
        }
    }
}
