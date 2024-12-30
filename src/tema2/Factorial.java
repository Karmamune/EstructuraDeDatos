package tema2;

import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Ingrese un número > ");
        int fac = input.nextInt();
        int resultado = 1;
        
        for (int i = fac; i > 0; i--) {
            resultado = resultado * i;
        }
        
        System.out.println("Resultado: " + resultado);
    }
}
