package arbolBinario;

public class ArbolBinario {
	private NodoArbol raiz;
	private int nivel=0;
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
	//Recorrido preorden: R-I-D
	public void EjecutarPreOrder() {
		PreOrder(raiz);
	}
	private void PreOrder(NodoArbol nodo) {
		if(nodo == null) { //Caso base
			return;
		}else {
			System.out.print(nodo.getDato() + "-"); //Visita la raiz (R)
			PreOrder(nodo.getIzquierda()); //Recorre el subarbol izquierdo (I)
			PreOrder(nodo.getDerecha()); //Recorre el subarbol derecho (D)
		}
	}
	//Recorrido preorden: I-R-D
	public void EjecutarInOrder() {
		InOrder(raiz);
	}
	private void InOrder(NodoArbol nodo) {
		if(nodo == null) { //Caso base
			return;
		}else {
			InOrder(nodo.getIzquierda()); //Recorre el subarbol izquierdo (I)
			System.out.print(nodo.getDato() + "-"); //Visita la raiz (R)
			InOrder(nodo.getDerecha()); //Recorre el subarbol derecho (D)
		}
	}
	//Recorrido preorden: I-D-R
	public void EjecutarPostOrder() {
		PostOrder(raiz);
	}
	private void PostOrder(NodoArbol nodo) {
		if(nodo == null) { //Caso base
			return;
		}else {
			PostOrder(nodo.getIzquierda()); //Recorre el subarbol izquierdo (I)
			PostOrder(nodo.getDerecha()); //Recorre el subarbol derecho (D)
			System.out.print(nodo.getDato() + "-"); //Visita la raiz (R)
		}
	}
	//Buscar con while
	public boolean ejecutarBuscarNodo2(int valor) {
		return buscarNodo2(raiz, valor);
	}
	public boolean buscarNodo2(NodoArbol nodo, int dato) {
		NodoArbol aux = nodo;
		while(dato != aux.getDato()) {
			if(dato < aux.getDato()) {
				aux =  aux.getIzquierda();
			}else {
				aux =  aux.getDerecha();
			}
			if(aux == null) {
				return false;
			}
		}
		return true;
	}
	//Buscar nodo del arbol
	public void ejecutarBuscarNodo(int valor) {
		buscarNodo(raiz, valor);
	}
	public void buscarNodo(NodoArbol nodo, int dato) {
		if(esVacio()) {
			System.out.println("Arbol vacio, nada por buscar");
			
			return;
		}
		if(nodo == null) {
			System.out.println("Elemento "+dato+" no se encontro");
			return;
		}
		if(nodo.getDato() == dato) {
			System.out.println("Elemento "+dato+" encontrado en el nivel " + nivel);
			nivel = 0;
			return;
		}
		if(dato<nodo.getDato()) { 
			System.out.println("Buscando en el subarbol izquierdo");
			contarNiveles();
			buscarNodo(nodo.getIzquierda(), dato);
			
			
		}else {
			System.out.println("Buscando en el subarbol derecho");
			contarNiveles();
			buscarNodo(nodo.getDerecha(), dato);
		}	
	}
	//Eliminar nodo
	public void EliminarNodoHoja(NodoArbol padre, NodoArbol aux, boolean esHijoIzq) {
		if(aux == raiz) {
			raiz = null;
		}else {
			if(esHijoIzq) {
				padre.setIzquierdo(null);
			}else {
				padre.setDerecho(null);
			}
		}
	}
	public void EliminarNodoUnHijo(NodoArbol padre, NodoArbol aux, boolean esHijoIzq) {
		if(aux.getDerecha() == null) {
			if(aux == raiz) {
				raiz = raiz.getIzquierda();
			}else {
				if(esHijoIzq) {
					padre.setIzquierdo(aux.getIzquierda());
				}else {
					padre.setDerecho(aux.getIzquierda());
				}
			}
		}else {
			if(aux == raiz) {
				raiz = raiz.getDerecha();
			}else {
				if(esHijoIzq) {
					padre.setIzquierdo(aux.getIzquierda());
				}else {
					padre.setDerecho(aux.getIzquierda());
				}
			}
		}
	}
	//Contar niveles{
	public void contarNiveles() {
		nivel++;
	}
}
