package repasoArboles4;

public class Arbol {
	private Nodo inicial;
	
	private boolean esVacio() {
		return inicial==null;
	}
	
	public void insertar(int valor) {
		inicial = insertarNodo(inicial, valor);
	}
	
	private Nodo insertarNodo(Nodo nodo, int valor) {
		if(nodo==null) return new Nodo(valor);
		if(valor < nodo.valor) {
			nodo.izquierdo=insertarNodo(nodo.izquierdo, valor);
		}else {
			nodo.derecho=insertarNodo(nodo.derecho, valor);
		}
		return nodo;
	}
	public void eliminar(int valor) {
		if(esVacio()) System.out.println("Arbol vacio, nada por eliminar");
		inicial=eliminarNodo(inicial, valor);
	}
	
	private Nodo eliminarNodo(Nodo nodo, int valor) {
		if(nodo==null) return null;
		if(valor < nodo.valor) {
			nodo.izquierdo=eliminarNodo(nodo.izquierdo, valor);
		}else if(valor > nodo.valor) {
			nodo.derecho=eliminarNodo(nodo.derecho, valor);
		}else {
			if(nodo.izquierdo==null) return nodo.derecho;
			if(nodo.derecho==null) return nodo.izquierdo;
			Nodo sucesor=minimo(nodo.derecho);
			nodo.valor=sucesor.valor;
			nodo.derecho=eliminarNodo(nodo.derecho, sucesor.valor);
		}
		return nodo;
	}
	
	public int minimo() {
		return minimo(inicial).valor;
	}
	
	private Nodo minimo(Nodo nodo) {
		while(nodo.izquierdo!=null) {
			nodo=nodo.izquierdo;
		}
		return nodo;
	}
	
	public boolean buscar(int valor) {
		if(esVacio()) System.out.println("Arbol vacio, nada por eliminar");
		return buscarNodo(inicial, valor);
	}
	private boolean buscarNodo(Nodo nodo, int valor) {
		if(nodo==null) return false;
		if(valor == nodo.valor) return true;
		return (valor < nodo.valor )?buscarNodo(nodo.izquierdo, valor):buscarNodo(nodo.derecho, valor);
	}
	private int LCI(Nodo nodo, int prof) {
		if(nodo==null) return 0;
		if(nodo.izquierdo==null && nodo.derecho==null) return 0;
		return prof + LCI(nodo.izquierdo, prof +1 )+LCI(nodo.derecho, prof +1 );
	}
	public int calculoLCI() {
		return LCI(inicial, 1);
	}
	private int LCE(Nodo nodo, int prof) {
		if(nodo==null) return 0;
		if(nodo.izquierdo==null && nodo.derecho==null) return prof;
		return LCE(nodo.izquierdo, prof +1)+LCE(nodo.derecho, prof +1);
	}
	public int calculoLCE() {
		return LCE(inicial, 1);
	}
	
	private int tamañoArbol(Nodo nodo) {
		if(nodo==null) return 0;
		return 1+tamañoArbol(nodo.izquierdo)+tamañoArbol(nodo.derecho);
	}
	public int tamaño() {
		if(esVacio()) System.out.println("Arbol vacio, nada por eliminar");
		return tamañoArbol(inicial);
	}
	
	private void PreOrder(Nodo nodo) {
		if(nodo==null) return;
		System.out.print(nodo.valor + "-");
		PreOrder(nodo.izquierdo);
		PreOrder(nodo.derecho);
	}
	private void InOrder(Nodo nodo) {
		if(nodo==null) return;
		InOrder(nodo.izquierdo);
		System.out.print(nodo.valor + "-");
		
		InOrder(nodo.derecho);
	}
	private void PostOrder(Nodo nodo) {
		if(nodo==null) return;
		
		PostOrder(nodo.izquierdo);
		PostOrder(nodo.derecho);
		System.out.print(nodo.valor + "-");
	}
	public void preOrder() {
		if(esVacio()) System.out.println("Arbol vacio, nada por mostrar");
		PreOrder(inicial);
		System.out.println();
	}
	public void inOrder() {
		if(esVacio()) System.out.println("Arbol vacio, nada por mostrar");
		InOrder(inicial);
		System.out.println();
	}
	public void postOrder() {
		if(esVacio()) System.out.println("Arbol vacio, nada por mostrar");
		PostOrder(inicial);
		System.out.println();
	}
	
	public int primerMultTres() {
		return multTres(inicial);
	}
	
	private int multTres(Nodo nodo) {
		if(nodo==null) return -1;
		int encontrado = multTres(nodo.izquierdo);
		if(encontrado!=-1) return encontrado;
		if(nodo.valor %3==0) return nodo.valor;
		return multTres(nodo.derecho);
	}
	
}
