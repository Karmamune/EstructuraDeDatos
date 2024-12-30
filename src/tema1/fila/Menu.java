package tema1.fila;

import java.util.*;

/**
 *
 * @author Manuel
 */
public class Menu {
    
    Scanner input = new Scanner(System.in);
    Fila fila = new Fila();
    
    public void menu() {
        byte opc = 0;
        
        do {
            System.out.print("\nIngrese una opción\n1) Insertar\n2) Eliminar\n"
                    + "3) Verificar si la fila está vacía\n4) Verificar si la fila está llena\n"
                    + "5) Mostrar fila\n0) Salir\n> ");
            try {
                opc = input.nextByte();
                switch (opc) {
                    case 1 -> insertar();
                    case 2 -> eliminar();
                    case 3 -> vacia();
                    case 4 -> llena();
                    case 5 -> mostrarFila();
                    case 0 -> {System.out.println("Saliendo del programa..");}
                    default -> {System.err.println("Ingrese una opción válida");}
                }
            }
            catch (InputMismatchException e) {
                System.err.println("Ingrese una opción válida");
                input.nextLine();
                System.out.print("> ");
            }
        }while (opc != 0);
    }
    
    public void insertar() {
        boolean ciclo = true;
        System.out.print("Ingrese el ID\n> ");
        do {
            try {
                fila.insertar(input.nextInt());
                System.out.println("Se ha insertado con éxito en la fila");
                ciclo = false;
            }
            catch (InputMismatchException e) {
                System.err.println("Ingrese un valor válido");
                input.nextLine();
                System.out.print("> ");
            }
        }while (ciclo);
    }
    
    public void eliminar() {
        fila.eliminar();
        System.out.println("Se ha eliminado el primer elemento de la fila con éxito");
    }
    
    public void vacia() {
        if (fila.vacia())
            System.out.println("La fila está vacía");
        else
            System.out.println("La fila NO está vacía");
    }
    
    public void llena() {
        if (fila.llena())
            System.out.println("La fila está llena");
        else
            System.out.println("La fila NO está llena");
    }
    
    public void mostrarFila() {
        fila.mostrarFila();
    }
}
