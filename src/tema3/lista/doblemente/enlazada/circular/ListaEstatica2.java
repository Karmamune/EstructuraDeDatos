package tema3.lista.doblemente.enlazada.circular;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Manuel
 */
public class ListaEstatica2 {
    int lista[][];
    boolean firstTime = true;
    Scanner input = new Scanner(System.in);
    
    public ListaEstatica2() {
        lista = new int[5][3];
    }
    
    public ListaEstatica2(int max) {
        lista = new int[max][3];
    }
    
    public void insertar(int d) {
        boolean aux = true;
        if (!llena()) {
            for (int i = 0; i < lista.length; i++) {
                if ((lista[i][1] == 0 || lista[i][1] == -1) && aux) {
                    if (firstTime) {
                        lista[0][0] = 0;
                        lista[0][1] = d;
                        lista[0][2] = 0;
                        firstTime = false;
                    }
                    else {
                        lista[i][1] = d;
                        lista[i][0] = lista[i-1][0];
                        lista[i-1][0] = i;
                        lista[i][2] = lista[0][2];
                        lista[i-1][2] = i;
                    }
                    aux = false;
                }
            }
        }
        else {
            System.out.println("La lista está llena");
        }
    }
    
    public void eliminar(int d) {
        
    }
    
    public int buscar(int d) {
        return -1;
    }
    
    public boolean vacia() {
        boolean aux = true;
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i][1]);
            if (lista[i][1] != 0 || lista[i][1] != -1) {
                aux = false;
            }
        }
        return aux;
    }
    
    public boolean llena() {
        boolean aux = true;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i][1] == 0 || lista[i][1] == -1) {
                aux = false;
            }
        }
        return aux;
    }
    
    public void mostrar() {
        if (!vacia()) {
            System.out.println("ind\tant\tdato\tsig\n---\t---\t----\t---");
            for (int i = 0; i < lista.length; i++) {
                System.out.print(" " + i + "\t ");
                for (int j = 0; j < lista[i].length; j++) {
                    System.out.print(lista[i][j] + "\t ");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("La lista está vacía");
        }
    }
    
    public void menu() {
        byte opc = 0;
        int aux;
        
        do {
            System.out.print("\nLista menú 1.0\n"
                    + "1) Insertar\n"
                    + "2) Eliminar\n"
                    + "3) Buscar\n"
                    + "4) Verificar si la lista está vacía\n"
                    + "5) Verificar si la lista está llena\n"
                    + "6) Mostrar lista\n"
                    + "0) Salir\n"
                    + "> ");
            try {
                opc = input.nextByte();
                switch (opc) {
                    case 1 -> {
                        System.out.print("Ingrese el dato a insertar\n> ");
                        insertar(input.nextInt());
                    }
                    case 2 -> {
                        System.out.print("¿Qué dato de la lista quiere eliminar?\n> ");
                        eliminar(input.nextInt());
                    }
                    case 3 -> {
                        System.out.print("¿Qué dato quiere buscar en la lista?\n> ");
                        if ((aux = buscar(input.nextInt())) != -1) {
                            System.out.println("La posición del primer dato coinciente encontrado es " + aux);
                        }
                        else {
                            System.out.println("No se encontró ese elemento en la lista");
                        }
                    }
                    case 4 -> {
                        if (vacia()) {
                            System.out.println("La lista está vacía");
                        }
                        else {
                            System.out.println("La lista NO está vacía");
                        }
                    }
                    case 5 -> {
                        if (llena()) {
                            System.out.println("La lista está llena");
                        }
                        else {
                            System.out.println("La lista NO está llena");
                        }
                    }
                    case 6 -> mostrar();
                    default -> {
                        opc = -1;
                        System.out.println("Saliendo del programa");
                    }
                }
            }
            catch (InputMismatchException e) {
                System.err.println("No es una opción válida");
                input.nextLine();
            }
        } while (opc != -1);
        input.close();
    }
}
