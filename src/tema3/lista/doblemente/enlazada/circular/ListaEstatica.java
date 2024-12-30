package tema3.lista.doblemente.enlazada.circular;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class ListaEstatica {
    int max, ini, fin;
    int ant[];
    int dato[];
    int sig[];
    Scanner input = new Scanner(System.in);
    
    public ListaEstatica() {
        max = 5;
        ant = new int[max];
        dato = new int[max];
        sig = new int[max];
        ini = -1;
    }
    
    public ListaEstatica(int max) {
        this.max = max;
        ant = new int[max];
        dato = new int[max];
        sig = new int[max];
        ini = -1;
    }
    
    public void insertar(int d) {
        int aux = 0;
        if (!llena()) {
            if (vacia()) {
                ini = 0;
                ant[ini] = 0;
                dato[ini] = d;
                sig[ini] = 0;
            }
            else {
                for (int i = 0; i < dato.length; i++) {
                    if (dato[i] == 0 || dato[i] == -1) {
                        if (aux == 0) {
                            dato[i] = d;
                            sig[i] = ini;
                            sig[i-1] = i;
                            ant[i] = i - 1;
                            ant[ini] = i;
                            
//                            aux = ant[ini] + 1;
//                            dato[aux] = d;
//                            sig[aux-1] = aux;
//                            sig[aux] = ini;
//                            ant[aux] = aux - 1;
//                            ant[ini] = aux;
                            aux = 1;
                        }
                    }
                }
            }
        }
        else {
            System.out.println("La lista está llena");
        }
    }
    
    public void eliminar(int d) {
        int aux = 0;
        if (!vacia()) {
            if ( (aux = buscar(d)) != -1) {
                if (aux == ini) {
                    //El dato a eliminar está al inicio
                    sig[ant[ini]] = sig[ini]; 
                    ant[sig[ini]] = ant[ini];
                    aux = ini;
                    ini = sig[ini];
                }
                else {
                    //El dato a eliminar está entre inicio y final o en el final
                    sig[ant[aux]] = sig[aux];
                    ant[sig[aux]] = ant[aux];
                }
                ant[aux] = -1;
                dato[aux] = -1;
                sig[aux] = -1;
                System.out.println("El primer elemento coincidente ha sido borrado de forma exitosa");
            }
            else {
                System.out.println("No existe el dato " + d + " en la lista");
            }
        }
        else {
            System.out.println("La lista está vacía");
        }
    }
    
    public int buscar(int d) { //Para buscar algún dato
        int aux = -1;
        if (!vacia()) {
            for (int i = 0; i < dato.length; i++) {
                if (dato[i] == d) {
                    aux = i;
                }
            }
        }
        else {
            System.out.println("La lista está vacia");
        }
        return aux;
        
//        int aux = -1;
//        if (!vacia()) {
//            aux = ini;
//            while (d != dato[aux] && aux != ant[ini]) {
//                aux = sig[aux];
//            }
//            if (d != dato[aux]) {
//                aux = -1;
//            }
//        }
//        else {
//            System.out.println("La lista est� vacia");
//        }
//        return aux;
    }
    
    public boolean llena() {
        /*
        Si el ciclo encuentra un elemento igual a
        -1 o 0 aux toma el valor de 1
        regresa true cuando aux se queda en 0
        regresa false cuando aux vale 1
        */
        byte aux = 0;
        for (int i = 0; i < dato.length; i++) {
            if (dato[i] == -1 || dato[i] == 0) {
                aux = 1;
            }
        }
        return (aux == 0);
    }
    
    public boolean vacia() {
        /*
        Si el ciclo encuentra un elemento diferente a
        -1 o 0 aux toma el valor de 1
        regresa true cuando aux se queda en 0
        regresa false cuando aux vale 1
        */
        byte aux = 0;
        for (int i = 0; i < dato.length; i++) {
            if (dato[i] != -1 && dato[i] != 0) {
                aux = 1;
            }
        }
        return (aux == 0);
    }
    
    public void mostrar() {
        if (!vacia()) {
            System.out.println("ind\tant\tdato\tsig");
            System.out.println("---\t---\t----\t---");
            for (int pos = 0; pos <= dato.length - 1; pos++) {
                if (dato[pos] != -1 && dato[pos] != 0) {
                    System.out.println(" " + pos + "\t " + ant[pos] + "\t " + dato[pos] + "\t " + sig[pos]);
                }
            }
            System.out.println("");
            }
        else {
            System.out.println("La lista está vacia");
        }
    }
    
    public void menu() {
        byte opc = 0;
        int aux;
        
        do {
            System.out.print("\nLista menú 2.0\n"
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
