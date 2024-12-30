package tema4.arbol.binario;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Manuel
 */
public class ArbolBinario {
    Nodo raiz, nodo;
    Scanner input = new Scanner(System.in);
    
    String auxS = "";
    char auxC = ' ';
    
    public ArbolBinario() {
        raiz = null;
    }
    
    public void insertar(char d) {
        Nodo padre, aux;
        nodo = new Nodo(d);
        
        if (raiz == null) {
            raiz = nodo;
        }
        else {
            aux = raiz;
            
            do {
                padre = aux;
                if (d > aux.dato) {
                    aux = aux.hijoDer;
                }
                else {
                    aux = aux.hijoIzq;
                }
            } while (aux != null);
            
            if (d > padre.dato) {
                padre.hijoDer = nodo;
            }
            else {
                padre.hijoIzq = nodo;
            }
        }
    }
    
    public Nodo buscar(char c) {
        Nodo aux = raiz;
        boolean ban = false;
        
        while (aux != null && ban == false) {
            if (c == aux.dato) {
                ban = true;
            }
            else {
                if (c > aux.dato) {
                    aux = aux.hijoDer;
                }
                else {
                    aux = aux.hijoIzq;
                }
            }
        }
        return aux;
    }
    
    public Nodo buscarPadre(char c) {
        Nodo padre = null, aux = raiz;
        boolean ban = false;
        
        while (aux != null && ban == false) {
            if (c == aux.dato) {
                ban = true;
            }
            else {
                padre = aux;
                
                if (c > aux.dato) {
                    aux = aux.hijoDer;
                }
                else {
                    aux = aux.hijoIzq;
                }
            }
        }
        return padre;
    }
    
    public void eliminar(char c) {
        Nodo aux, aux2, padre;
        
        if (raiz != null) {
            padre = buscarPadre(c);
            if ((aux = buscar(c)) != null) {
                //Cuando el nodo a eliminar no tiene hijos
                if (aux.hijoIzq == null && aux.hijoDer == null) {
                    if (padre.hijoIzq != null) {
                        if (c == padre.hijoIzq.dato) {
                            padre.hijoIzq = null;
                        }
                    }
                    if (padre.hijoDer != null) {
                        if (c == padre.hijoDer.dato) {
                            padre.hijoDer = null;
                        }
                    }
                }
                //Cuando el nodo a eliminar tiene un solo hijo
                else if (aux.hijoIzq != null && aux.hijoDer == null) {
                    if (padre.hijoIzq != null) {
                        if (c == padre.hijoIzq.dato) {
                            padre.hijoIzq = aux.hijoIzq;
                        }
                    }
                    if (padre.hijoDer != null) {
                        if (c == padre.hijoDer.dato) {
                            padre.hijoDer = aux.hijoIzq;
                        }
                    }
                }
                else if (aux.hijoIzq == null && aux.hijoDer != null) {
                    if (padre.hijoIzq != null) {
                        if (c == padre.hijoIzq.dato) {
                            padre.hijoIzq = aux.hijoDer;
                        }
                    }
                    if (padre.hijoDer != null) {
                        if (c == padre.hijoDer.dato) {
                            padre.hijoDer = aux.hijoDer;
                        }
                    }
                }
                //Cuando el nodo a eliminar tiene 2 hijos
                else { //(aux.hijoIzq != null && aux.hijoDer != null)
                    aux = siguiente(raiz, c);
                    padre = buscarPadre(aux.dato);
                    aux2 = buscar(c);
                    aux2.dato = aux.dato;
                    
                    if (padre.hijoIzq == aux) {
                        padre.hijoIzq = aux.hijoDer;
                    }
                    else {
                        padre.hijoDer = aux.hijoDer;
                    }
                }
            }
        }
        else {
            System.out.println("El árbol está vacío");
        }
    }
    
    boolean auxB = true;
    
    public Nodo siguiente(Nodo n, char c) {
        if (n != null) {
            siguiente(n.hijoIzq, c);
            if (n.dato > c && auxB) {
                auxC = n.dato;
                auxB = false;
            }
            siguiente(n.hijoDer, c);
        }
        return buscar(auxC);
    }
    
    public Nodo anterior(Nodo n, char c) {
        if (n != null) {
            anterior(n.hijoIzq, c);
            if (n.dato < c) {
                auxS += n.dato;
            }
            else if (n.dato == c) {
                auxC = auxS.charAt(auxS.length() - 1);
            }
            anterior(n.hijoDer, c);
        }
        return buscar(auxC);
    }
    
    public void inOrden(Nodo n) {
        if (n != null) {
            inOrden(n.hijoIzq);
            System.out.print(n.dato + " ");
            inOrden(n.hijoDer);
        }
        if (n == raiz) {
            System.out.println("");
        }
    }
    
    public void preOrden(Nodo n) {
        if (n != null) {
            System.out.print(n.dato + " ");
            preOrden(n.hijoIzq);
            preOrden(n.hijoDer);
        }
    }
    
    public void postOrden(Nodo n) {
        if (n != null) {
            postOrden(n.hijoIzq);
            postOrden(n.hijoDer);
            System.out.print(n.dato + " ");
        }
    }
    /*
    InOrden
    I, R, D
    
    PreOrden
    R, I, D
    
    PostOrden
    I, D, R
    
    I = Izquierdo
    R = Raíz
    D = Derecho
    */
    
    public void menu() {
        byte opc = 0;
        boolean f = true;
        
        do {
            if(!f) {
                System.out.println("");
            }
            else {
                f = false;
            }
            System.out.print("Ingrese una opción\n"
                    + "1) insertar\n"
                    + "2) eliminar\n"
                    + "3) buscar\n"
                    + "4) inOrden\n"
                    + "5) preOrden\n"
                    + "6) postOrden\n"   
                    + "0) salir\n"
                    + "> ");
            try {
                opc = input.nextByte();
                switch (opc) {
                    case 1 -> {
                        System.out.println("Ingrese un caracter");
                        insertar((input.next()).charAt(0));
                    }
                    case 2 -> {
                        System.out.println("Ingrese el caracter a eliminar");
//                        eliminar((input.next()).charAt(0));
                    }
                    case 3 -> {
                        System.out.println("Ingrese el caracter que quiere buscar");
                    }
                    case 4 -> {
                        System.out.println("\ninOrden");
                        inOrden(raiz);
                        System.out.println("");
                    }
                    case 5 -> {
                        System.out.println("\npreOrden");
                        preOrden(raiz);
                        System.out.println("");
                    }
                    case 6 -> {
                        System.out.println("\npostOrden");
                        postOrden(raiz);
                        System.out.println("");
                    }
                    default -> {
                        opc = -1;
                        System.out.println("Saliendo del programa..");
                    }
                }
            }
            catch (InputMismatchException ime){
                System.err.println("No es una opción válida");
                input.nextLine();
            }
        }while (opc != -1);
    }
}
