
public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        arbol.Insertar(23);
        arbol.Insertar(10);
        arbol.Insertar(17);
        arbol.Insertar(26);
        arbol.Insertar(11);
        arbol.Insertar(8);
        arbol.Insertar(35);
        arbol.Insertar(78);
        arbol.Insertar(44);
        arbol.Insertar(46);
        arbol.Insertar(25);
        arbol.Insertar(24);

        System.out.print("InOrder: ");
        arbol.InOrden();

       // System.out.println("Buscar 17: " + arbol.Buscar(17));
       //System.out.println("Buscar 99: " + arbol.Buscar(99));

       // System.out.println("Mínimo: " + arbol.Minimo());
       // System.out.println("Máximo: " + arbol.Maximo());
       // System.out.println("Tamaño: " + arbol.Tamaño());

        int nodoElim = 35;
        System.out.println("Eliminar " + nodoElim);
        arbol.Eliminar(nodoElim);
        arbol.InOrden();
        /*
        System.out.println("Eliminar 23 (raíz)");
        arbol.eliminar(23);
        arbol.inOrden();
        */
    }
}
