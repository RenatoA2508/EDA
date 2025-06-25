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
			this.raiz.insertarNodo(valor);//Se empieza a decidir donde colocar el nodo desde la raiz, va bajando segun las llamadas recursivas
		}
	}
	//Recorrido preorden
	public void EjecutarPreOrder() {
		PreOrder(raiz);
	}
	public void PreOrder(NodoArbol nodo) {
		if(nodo == null) { //Caso base
			return;
		}else {
			System.out.print(nodo.getDato() + "-"); //Visita la raiz (R)
			PreOrder(nodo.getIzquierda()); //Recorre el subarbol izquierdo (I)
			PreOrder(nodo.getDerecha()); //Recorre el subarbol derecho (D)
		}
	}
	
}
