package tema3.cola.circular;

/**
 *
 * @author Manuel
 */
public class ColaCircularPrueba {
    public static void main(String[] args) {
        ColaCircular c = new ColaCircular();
        
        c.mostrar();
        System.out.println("");
        
        c.insertar("Prueba1");
        c.insertar("Prueba2");
        c.insertar("Prueba3");
        c.mostrar();
        
        c.eliminar();
        c.eliminar();
        c.mostrar();
        
        c.insertar("Prueba4");
        c.mostrar();
    }
}
