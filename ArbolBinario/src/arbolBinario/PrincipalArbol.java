package arbolBinario;

public class PrincipalArbol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolBinario arbol1 = new ArbolBinario();
		arbol1.insertar(10);
		arbol1.insertar(5);
		arbol1.insertar(15);
		arbol1.insertar(6);
		arbol1.insertar(17);
		arbol1.insertar(20);
		
		
		//arbol1.PreOrder(arbol1.getRaiz());
		arbol1.EjecutarPreOrder();
	}

}
