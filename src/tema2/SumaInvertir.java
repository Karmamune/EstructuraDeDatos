package tema2;

/**
 *
 * @author Manuel
 */
public class SumaInvertir {
    public static void main(String[] args) {
        System.out.println("Suma de 1234: " + suma(1234, 0));
        System.out.println("Número 1234 invertido: " + invertir(1234, 1));
        //contador de invertir() inicia en 1 para no pasarse del arreglo
    }
    
    public static int suma(int x, int c) {
        if (c > (Integer.toString(x)).length() - 1) {
            return 0;
        }
        else {
            return (Integer.toString(x).charAt(c) - '0') + suma(x, ++c);
        }
    }
    
    public static String invertir(int x, int c) {
        if (c > (Integer.toString(x).length())) {
            return "";
        }
        else {
            return (Integer.toString(x).charAt(Integer.toString(x).length() -  c)) + invertir(x, ++c);
        }
    }
}
