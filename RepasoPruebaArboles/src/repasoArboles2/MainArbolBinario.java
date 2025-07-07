package repasoArboles2;

public class MainArbolBinario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolBinario arbol = new ArbolBinario();

        arbol.insertar(23);
        arbol.insertar(10);
        arbol.insertar(17);
        arbol.insertar(26);
        arbol.insertar(11);
        arbol.insertar(8);
        arbol.insertar(35);
        arbol.insertar(78);
        arbol.insertar(44);
        arbol.insertar(46);
        arbol.insertar(25);
        arbol.insertar(24);

        System.out.print("InOrder: ");
        arbol.inOrden();

        System.out.println("Buscar 17: " + arbol.buscar(17));
       System.out.println("Buscar 99: " + arbol.buscar(99));

       System.out.println("Mínimo: " + arbol.minimo());
        //System.out.println("Máximo: " + arbol.Maximo());
        System.out.println("Tamaño: " + arbol.tamaño());

        int nodoElim = 35;
        System.out.println("Eliminar " + nodoElim);
        arbol.eliminar(nodoElim);
        arbol.inOrden();
        
        System.out.println("Eliminar 23 (raíz)");
        arbol.eliminar(23);
        arbol.inOrden();
        
	}

}
