package arbolBinario;

public class ArbolBinario {
	private NodoArbol raiz;
	public boolean esVacio() {
		return raiz==null;
	}
	public NodoArbol getRaiz() {
		return raiz;
	}
	//Insertar nodos
	public void insertar(int valor) {
		if(esVacio()) {
			System.out.println("Insertando raiz... "+valor);
			this.raiz = new NodoArbol(valor);
		}else {
			System.out.println("Insertando nodo no raiz... "+valor);
			this.raiz.insertarNodo(valor);
		}
	}
	//Recorrido preorden
	public void EjecutarPreOrder() {
		PreOrder(raiz);
	}
	public void PreOrder(NodoArbol nodo) {
		if(nodo == null) {
			return;
		}else {
			System.out.print(nodo.getDato() + "-");
			PreOrder(nodo.getIzquierda());
			PreOrder(nodo.getDerecha());
		}
	}
	
}
