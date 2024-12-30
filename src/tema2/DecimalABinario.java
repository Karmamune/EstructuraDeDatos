package tema2;

/**
 *
 * @author Manuel
 */
public class DecimalABinario {
    
    /*
    x = número decimal.
    c = contador.
    */
    
    public static void main(String[] args) {
        System.out.printf("Decimal: 13\nBinario: " +decABinRec(6, 0)+ "\n");
//        decABin(13);
    }
    
    public static void decABin(int x) {
        String aux = "";
        while (x > 0) {
            aux += x%2;
            x = x/2;
        }
        String bin = "";
        for (int i = aux.length(); i > 0; i--) {
            bin += aux.charAt(i-1);
        }
        System.out.print(bin);
    }
    
    public static String decABinRec(int x, int c) {
        if (x == 0 && c == 0) {
            return "0";
        }
        else if (x == 0) {
            return "";
        }
        else {
            return "" + decABinRec(x/2, ++c) + x%2;
        }
    }
    
    public static String decABinRecSin0(int x) {
        if (x == 0) {
            return "0";
        }
        else {
            return "" + decABinRecSin0(x/2) + x%2;
        }
    }
}
