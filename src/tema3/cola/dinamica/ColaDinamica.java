package tema3.cola.dinamica;

import java.util.*;

/**
 *
 * @author Manuel
 */
public class ColaDinamica {
    Cola ini, fin, cola;
    Scanner input = new Scanner(System.in);
    
    public ColaDinamica() {
        ini = fin = null;
    }
    
    public void insertar(String nom) {
        if (!llena()) {
            cola = new Cola();
            cola.nombre = nom;
            cola.sig = null;
            
            if (ini == null) {
                ini = fin = cola;
            }
            else {
                fin.sig = cola;
                fin = cola;
            }
        }
        else {
            System.out.println("La cola está llena");
        }
    }
    
    public void eliminar() {
        Cola aux = ini;
        
        if (!vacia()) {
            ini = aux.sig;
            aux = null;
        }
        else {
            System.out.println("La cola está vacía");
        }
    }
    
    public boolean llena() {
        return (new Cola() == null);
    }
    
    public boolean vacia() {
        return ini == null;
    }
    
    public void mostrar() {
        Cola aux = ini;
        
        if (!vacia()) {
            System.out.print("Cola: ");
            while (aux != null) {
                System.out.print(" " + aux.nombre);
                aux = aux.sig;
            }
            System.out.println("");
        }
        else {
            System.out.println("La cola está vacía");
        }
    }
    
    public void menu() {
        byte opc = 0;
        
        do {
            System.out.print("\nIngrese una opción\n"
                    + "1) insertar\n"
                    + "2) eliminar\n"
                    + "3) verificar si la cola está vacía\n"
                    + "4) verificar si la cola está llena\n"
                    + "5) mostrar cola\n"
                    + "0) salir\n"
                    + "> ");
            try {
                opc = input.nextByte();
                switch (opc) {
                    case 1 -> {
                        System.out.println("Ingrese un nombre");
                        insertar(input.next());
                    }
                    case 2 -> eliminar();
                    case 3 -> {
                        if (vacia()) {
                            System.out.println("La cola está vacía");
                        }
                        else {
                            System.out.println("La cola NO está vacía");
                        }
                    }
                    case 4 -> {
                        if (llena()) {
                            System.out.println("La cola está llena");
                        }
                        else {
                            System.out.println("La cola NO está llena");
                        }
                    }
                    case 5 -> mostrar();
                    default -> {
                        opc = -1;
                        System.out.println("Saliendo del programa..");
                    }
                }
            }
            catch (InputMismatchException e) {
                System.err.println("No es una opción válida");
                input.nextLine();
            }
        }while (opc != -1);
        input.close();
    }
}
