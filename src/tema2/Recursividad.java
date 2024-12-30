package tema2;

/**
 *
 * @author Manuel
 */
public class Recursividad {
    public int prueba(int n) {
        if (n > 0) {
            return n + prueba(n - 1);
        }
        else {
            return 0;
        }
    }
}
