package tema1;

/**
 *
 * @author Manuel
 */
public class Humano2Prueba {
    public static void main(String[] args) {
     
        Humano2 mtx[] = new Humano2[10];
        
        Humano2 var1 = new Humano2();
        var1.nombre = "Danielito";
        var1.edad = 7;
        var1.estatura = 1.20;
        var1.peso = 30;
        var1.sig = null;
        
        mtx[0] = var1;
        
        Humano2 var2 = new Humano2();
        var2.nombre = "Liliana";
        var2.edad = 9;
        var2.estatura = 1.10;
        var2.peso = 40;
        var2.sig = null;
        
        var1.sig = var2;
        mtx[1] = var2;
        
        Humano2 var3 = new Humano2();
        var3.nombre = "Edgar";
        var3.edad = 8;
        var3.estatura = 1.15;
        var3.peso = 27;
        var3.sig = null;
        
        var2.sig = var3;
        mtx[2] = var3;
        
        for (int i = 0; i < mtx.length; i++) {
            System.out.println(mtx[i]);
        }
    }
}
