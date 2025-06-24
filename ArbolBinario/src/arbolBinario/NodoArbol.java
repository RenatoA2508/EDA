package arbolBinario;

public class NodoArbol {
	public int dato;
	public NodoArbol izquierdo, derecho;
	public NodoArbol(int dato) {
		this.dato = dato;
		this.izquierdo = null;
		this.derecho = null;
	}
	//Getters
	public int getDato() {
		return dato;
	}
	public NodoArbol getIzquierda() {
		return izquierdo;
	}
	public NodoArbol getDerecha() {
		return derecho;
	}
	
	public void insertarNodo(int dato) {

		if(dato<this.dato) {
			//Insertar Hijo izq.
			if(this.izquierdo == null) {
				System.out.println("Insertando a la izquierda "+dato);
				this.izquierdo = new NodoArbol(dato);
			}else {
				
				this.izquierdo.insertarNodo(dato);
			}
		}else {
			//Insertar Hijo der.
			if(this.derecho == null) {
				System.out.println("Insertando a la derecha "+dato);
				this.derecho = new NodoArbol(dato);
			}else {
				
				this.derecho.insertarNodo(dato);
			}
		}
	}
	
	
}
