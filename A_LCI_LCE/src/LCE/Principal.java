package LCE;

public class Principal {
    public static void main(String[] args) {
        ABB abb = new ABB();
        
        // Ejemplo: 8, 3, 10, 1, 6, 14, 4, 7, 13
        //int[] valores = {8, 3, 10};
        int[] valores = {10, 5, 6, 1, 12, 11, 13};
        for (int v : valores) {
            abb.insertar(v);
        }

        System.out.println("Longitud de Camino Interno (LCI): " + abb.calcularLCI());
        System.out.println("Longitud de Camino Externo (LCE): " + abb.calcularLCE());
    }
}
