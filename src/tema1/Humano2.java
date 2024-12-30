package tema1;

/**
 *
 * @author Manuel
 */
public class Humano2 {
    
    String nombre;
    char sexo;
    byte edad;
    double estatura, peso;
    Humano2 sig;
    
    @Override
    public String toString() {
        return "Nombre: " + nombre 
                + "\nSexo: " + sexo 
                + "\nEdad: " + edad 
                + " años\nEstatura: " + estatura 
                + " m\nPeso: " + peso + " kg\n";
                
    }
}
