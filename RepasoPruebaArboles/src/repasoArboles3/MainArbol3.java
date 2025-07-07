package repasoArboles3;

import repasoArboles2.ArbolBinario;

public class MainArbol3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arbol arbol = new Arbol();

		
		
		
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
        System.out.println("Máximo: " + arbol.maximo());
        System.out.println("Tamaño: " + arbol.tamaño());

        int nodoElim = 35;
        System.out.println("Eliminar " + nodoElim);
        arbol.eliminar(nodoElim);
        arbol.inOrden();
        
        System.out.println("Eliminar 23 (raíz)");
        arbol.eliminar(23);
        arbol.inOrden();
        
        arbol.preOrden();
        arbol.postOrden();
        
        System.out.println("EL primer multiplo de 3 encontrado es: "+arbol.primerMultTres());
	}

}
