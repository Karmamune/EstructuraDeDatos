package tema2;

/**
 *
 * @author Manuel
 */
public class Fibonacci {
    
    public static void main(String[] args) {
        System.out.println("Fibonacci de 8: " + fiboRec(8));
        System.out.println("Secuencia Fibonacci recursiva: " + secFiboRec(8));
    }
    
//    public static int fibo(int i) {
//        if (i == 0) {
//            return 0;
//        }
//        else if (i == 1) {
//            return 1;
//        }
//        else {
//            int n1 = 0, n2 = 1, r = 0;
//            while (i >= 2) {
//                r = n1 + n2;
//                n1 = n2; n2 = r;
//                i--;
//            }
//            return r;
//        }
//    }
    
    public static String secFibo(int n) {
        String cad = "";
        int c = 0;
        if (n == 0) {
            return "";
        }
        else if (n == 1) {
            return "0";
        }
        else {
            int n1 = 0, n2 = 1, temp;
            while (c >= n) {
                cad += " " + n1;
                temp = n1 + n2;
                n1 = n2; n2 = temp;
                c++;
            }
            return cad;
        }
    }
    
    public static int fiboRec(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else {
            return fiboRec(n-1) + fiboRec(n-2);
        }
    }
    
    public static String secFiboRec(int n) {
        if (n >= 0) {
            return secFiboRec(n-1) + " " + fiboRec(n);
        }
        else {
            return "";
        }
    }
}
