package tema1.fila_con_arreglos;

import java.util.*;

/**
 *
 * @author Manuel
 */
public class FilaConArreglos {
    
    /*
    Para hacer este programa se me ocurrió
    utilizar 2 arreglos principales y uno 
    extra como herramienta para mover
    los arreglos en el método eliminar
    */
    
    Scanner input = new Scanner(System.in);
    
    int ID[] = new int[5];
    int SIG[] = new int[5];
    int TEMP[] = new int[5];
    
    /*
    El método "menu()" sirve para comunicarse
    con los otros métodos mediante un switch
    y una entrada del teclado.
    */
    
    public void menu() {
        
        ID[0] = -1;
        SIG[0] = -1;
        
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
                    case 3 -> compVacia();
                    case 4 -> compLlena();
                    case 5 -> mostrarFila();
                    case 0 -> {System.out.println("Saliendo del programa..");}
                    default -> {System.err.println("Ingrese una opción válida");}
                    case 6 -> imp();
                }
            }
            catch (InputMismatchException e) {
                System.err.println("Ingrese una opción válida");
                input.nextLine();
                System.out.print("> ");
            }
        }while (opc != 0);
    }
    
    /*
    El método "insertar()" primero revisa si
    la fila está llena, si no entonces
    el usuario puede agregar un id que quiera
    el id se guarda en la posición del arreglo
    que tenga un -1, el -1 es un valor con el
    que ya empieza el arreglo ID, el programa
    actualiza el valor en el siguiente índice
    del arreglo ID para que este sea -1 y en
    la próxima ocasión que se quiera insertar
    otro ID sepa donde colocarlo, a su vez, en
    el arreglo SIG se guarda en la posición actual
    un -1 que indica que nadie sigue de ese ID y
    en el arreglo SIG en la posición del índice
    anterior se actualiza el valor para que indique
    que el anterior ID apunta a este nuevo ID que
    acabamos de agregar al arreglo.
    */
    
    public void insertar() {
        System.out.print("\nIngrese el ID\n> ");
        if (!llena()) {
            for (int i = 0; i < ID.length; i++) {
                if (ID[i] == -1) {
                    ID[i] = input.nextInt();
                    ID[i+1] = -1;
                    SIG[i] = -1;
                    if (i > 0)
                        SIG[i-1] = i;
                    System.out.println("Se ha agregado el ID.");
                    break;
                }
            }
        }
    }
    
    /*
    En el método "eliminar()" lo que se me ocurrió
    hacer es crear otro arreglo llamado
    TEMP que me sirviera para mover todo
    el contenido de los arreglos ID y SIG
    y eliminar los valores contenidos en
    los índices 0, ya que como es una fila
    siempre se va a eliminar el primero en
    llegar.
    */
    
    public void eliminar() {
        for (int i = 0; i < ID.length - 1; i++) {
            TEMP[i] = ID[i+1];
        }
        
        for (int i = 0; i < TEMP.length; i++) {
            ID[i] = TEMP[i];
        }
        
        for (int i = 0; i < SIG.length - 1; i++) {
            TEMP[i] = ID[i+1];
        }
        
        for (int i = 0; i < TEMP.length; i++) {
            SIG[i] = TEMP[i];
        }
        
        System.out.println("Se ha eliminado con éxito el primer ID de la fila.");
    }
    
    /*
    El método "vacia()" comprueba si la
    fila está vacía y regresa un valor
    booleano que sirve para el programa.
    */
    
    public boolean vacia() {
        return (ID[0] == -1);
    }
    
    /*
    A diferencia del método "vacia()" el propósito
    de el método "compVacia()" es para imprimir texto
    para que el usuario conozca si la fila está vacía
    o no.
    */
    
    public void compVacia() {
        if (ID[0] == -1) {
            System.out.println("La fila está vacía.");
        }
        else {
            System.out.println("La fila NO está vacía.");
        }
    }
    
    //Lo mismo que "vacia()" pero para saber si está llena.
    
    public boolean llena() {
        return ID[4] != 0;
    }
    
    //Lo mismo que con "compVacia()" pero para saber si está llena.
    
    public void compLlena() {
        if (ID[4] == 0) {
            System.out.println("La fila NO está llena.");
        }
        else {
            System.out.println("La fila está llena");
        }
    }
    
    /*
    En "mostrarFila()" primero se comprueba que la fila
    no está vacía, si sí estuviera, entonces se usa el
    método "compVacía()" solo para imprimir que la fila
    está vacía. Cuando la fila ya tiene valores, entonces
    estos son mostrados gracias a un ciclo for, para que
    no se vieran los 0 con los que viene por defecto el
    arreglo y tampoco el valor -1, agregué una condición
    para que estos valores no se impriman.
    */
    
    public void mostrarFila() {
        if (!vacia()) {
            System.out.print("Fila: ");
            for (int i = 0; i < ID.length; i++) {
                if (ID[i] != 0 && ID[i] != -1) {
                    System.out.print(ID[i] + " ");
                }
            }
            System.out.println("");
        }
        else {
            compVacia();
        }
    }
    
    /*
    Este método es solo para el programador,
    este método me ayudó a comprobar que se
    estuvieran actualizando los valores de
    los arreglos correspondientes de forma
    correcta. Se accede ingresando un 6 en el
    menú.
    */
    
    public void imp() {
        System.out.println("");
        System.out.print("Arreglo ID: ");
        for (int i = 0; i < ID.length; i++) {
            System.out.print(ID[i] + " ");
        }
        System.out.println("");
        System.out.print("Arreglo SIG: ");
        for (int i = 0; i < SIG.length; i++) {
            System.out.print(SIG[i] + " ");
        }
        System.out.println("");
    }
}