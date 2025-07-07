package repasoArboles2;

public class ArbolBinario {
	private NodoArbol inicial;
	
	public boolean esVacio() {
		return inicial==null;
	}
	
	public void insertar(int valor) {
		inicial = insertarNodo(inicial, valor);
	}
	
	private NodoArbol insertarNodo(NodoArbol nodo, int valor) {
		if(nodo==null) return new NodoArbol(valor);
		
		if(valor < nodo.valor) {
			nodo.izquierdo = insertarNodo(nodo.izquierdo, valor);
		}else {
			nodo.derecho = insertarNodo(nodo.derecho, valor);
		}
		return nodo;
	}
	
	public boolean buscar(int valor) {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		return buscarNodo(inicial, valor);
	}
	
	private boolean buscarNodo(NodoArbol nodo, int valor) {
		if(nodo==null) return false;
		if(valor == nodo.valor) return true;
		return (valor < nodo.valor)?buscarNodo(nodo.izquierdo, valor):buscarNodo(nodo.derecho, valor);
	}
	
	private NodoArbol minimo(NodoArbol nodo) {
		while(nodo.izquierdo!=null) {
			nodo = nodo.izquierdo;
		}
		return nodo;
	}
	public int minimo() {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		return minimo(inicial).valor;
	}
	
	public void eliminar(int valor) {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		inicial = eliminarNodo(inicial, valor);
	}
	
	private NodoArbol eliminarNodo(NodoArbol nodo, int valor) {
		if(nodo==null) return null;
		
		if(valor < nodo.valor) {
			nodo.izquierdo = eliminarNodo(nodo.izquierdo, valor);
		}else if(valor > nodo.valor) {
			nodo.derecho = eliminarNodo(nodo.derecho, valor);
		}else {
			if(nodo.derecho ==null) return nodo.izquierdo;
			if(nodo.izquierdo==null) return nodo.derecho;
			NodoArbol sucesor = minimo(nodo.derecho);
			nodo.valor = sucesor.valor;
			System.out.println("Nodo a eliminar "+valor);
			nodo.derecho = eliminarNodo(nodo.derecho, sucesor.valor);
		}
		return nodo;
	}
	
	public int tamaño() {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		return tamañoArbol(inicial);
	}
	
	private int tamañoArbol(NodoArbol nodo) {
		if(nodo == null) return 0;
		return 1 + tamañoArbol(nodo.izquierdo)+tamañoArbol(nodo.derecho);
	}
	public int calculoLCI() {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		return LCI(inicial, 1);
	}
	
	private int LCI(NodoArbol nodo, int profundidad) {
		if(nodo==null) return 0;
		if(nodo.izquierdo == null && nodo.derecho==null) return 0;
		return profundidad+LCI(nodo.izquierdo, profundidad+1)+LCI(nodo.derecho, profundidad+1);
	}
	
	public int calculoLCE() {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		return LCE(inicial, 1);
	}
	
	private int LCE(NodoArbol nodo, int profundidad) {
		if(nodo==null) return 0;
		if(nodo.izquierdo==null && nodo.derecho==null) return profundidad;
		return LCE(nodo.izquierdo, profundidad+1)+LCE(nodo.derecho, profundidad+1);
	}
	
	public void preOrden() {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		PreOrden(inicial);
		System.out.println();
	}
	public void inOrden() {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		InOrden(inicial);
		System.out.println();
	}
	public void postOrden() {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		PostOrden(inicial);
		System.out.println();
	}
	
	private void PreOrden(NodoArbol nodo) {
		if(nodo==null) return;
		System.out.print(nodo.valor + " ");
		PreOrden(nodo.izquierdo);
		PreOrden(nodo.derecho);
	}
	private void InOrden(NodoArbol nodo) {
		if(nodo==null) return;
		InOrden(nodo.izquierdo);
		System.out.print(nodo.valor + " ");
		InOrden(nodo.derecho);
	}
	private void PostOrden(NodoArbol nodo) {
		if(nodo==null) return;
		PostOrden(nodo.izquierdo);
		PostOrden(nodo.derecho);
		System.out.print(nodo.valor + " ");
	}
	
}
