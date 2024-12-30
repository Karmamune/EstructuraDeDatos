package tema3;

import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class Pila {
    int tam = 6;
    int pila[] = new int[tam];
    int tope = 0;
    char temp[] = new char[tam];
    
    public int push(int data) {
        if (!isFull()) {
            pila[tope] = data;
            tope++;
            return data;
        }
        else {
            return -1;
        }
    }
    
    public int pop() {
        int aux = 0;
        if (!isEmpty()) {
            tope--;
            aux = pila[tope];
            pila[tope] = 0;
            return aux;
        }
        else {
            return -1;
        }
    }
    
    public boolean isEmpty() {
//        return (tope == 0) ? true : false;
        return (tope == 0);
    }
    
    public boolean isFull() {
//        return (tope == tam) ? true : false;
        return (tope == tam);
    }
    
    public void print() {
        System.out.println("Pila: ");
        for (int i = 0; i < tope; i++) {
            System.out.print(" " + pila[i]);
        }
        System.out.println("");
        System.out.println("Tope: " + tope);
        System.out.println("");
    }
    
    public void print2() {    
        System.out.println("\n<<Pila>>");
        System.out.println("_     _");
        for (int i = pila.length - 1; i >= 0; i--) {
            if(pila[i] == 0) {
                System.out.print(" |   |");
            }
            else {
                System.out.print(" | " + pila[i] + " |");
            }
            if(i == tope) {
                System.out.print(" <-- tope");
            }
            System.out.println("");
        }
        System.out.println("  ---");
    }
    
    public void menu() {
        Scanner input = new Scanner(System.in);
        int opc = 0;
        
        do {
            System.out.print("\n<<Pila>>\n"
                    + "1) Meter\n2) Sacar\n3) Comprobar si está vacía\n"
                    + "4) Comprobar si está llena\n5) Mostrar pila\n"
                    + "6) Mostrar 2\n0) Salir\n> ");
            opc = input.nextInt();
            switch (opc) {
                case 1 -> {
                    System.out.print("\n¿Qué número quiere meter a la pila?\n> ");
                    push(input.nextInt());
                }
                case 2 -> {
                    pop();
                }
                case 3 -> {
                    if (isEmpty()) {
                        System.out.println("La pila está vacía");
                    }
                    else {
                        System.out.println("La pila NO está vacía");
                    }
                }
                case 4 -> {
                    if (isFull()) {
                        System.out.println("La pila está llena");
                    }
                    else {
                        System.out.println("La pila NO está llena");
                    }
                }
                case 5 -> {
                    print();
                }
                case 6 -> {
                    print2();
                }
                default -> {
                    opc = 0;
                }
            }
        }while(opc != 0);
    }
}
