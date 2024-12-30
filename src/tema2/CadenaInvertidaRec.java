package tema2;

/**
 *
 * @author Manuel
 */
public class CadenaInvertidaRec {
    
    public static void main(String[] args) {
        System.out.println(cad("Prueba", 1));
        System.out.println(cad2("Prueba"));
    }
    
    public static String cad(String c, int x) {
        if (x > c.length()) {
            return "";
        }
        else {
            return c.charAt(c.length() - x) + cad(c, ++x);
        }
    }
    
//    public static String cad2(String c) {
//        String cad = "";
//        
//        while (!c.equals("")) {
//            cad = c.charAt(0) + cad;
//            c = c.substring(1);
//        }
//        return cad;
//    }
    
    public static String cad2(String c) {
        if (!c.equals("")) {
            return cad2(c.substring(1)) + c.charAt(0);
        }
        else {
            return "";
        }
    }
}
