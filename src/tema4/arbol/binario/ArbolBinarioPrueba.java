package tema4.arbol.binario;

/**
 *
 * @author Manuel
 */
public class ArbolBinarioPrueba {
    public static void main(String[] args) {
        ArbolBinario aB = new ArbolBinario();
        
        aB.insertar('J');
        aB.insertar('C');
        aB.insertar('K');
        aB.insertar('A');
        aB.insertar('E');
        aB.insertar('M');
        aB.insertar('D');
        aB.insertar('L');
        aB.insertar('O');
        aB.insertar('N');
        
//        aB.menu();
        
//        aB.inOrden(aB.raiz);
//        aB.eliminar('R');
//        aB.inOrden(aB.raiz);
        
//        aB.inOrden(aB.raiz);
//        System.out.println( "" + aB.siguiente(aB.raiz, 'M') == null ?
//                aB.siguiente(aB.raiz, 'M') :
//                aB.siguiente(aB.raiz, 'M').dato);

        aB.inOrden(aB.raiz);
        aB.eliminar('J');
        aB.inOrden(aB.raiz);
    }
}
