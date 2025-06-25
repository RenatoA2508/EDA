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
		if(dato<this.dato) { //Compara el parametro con el valor del nodo que hace la llamada (sea raiz, izquierdo o derecho)
			//Insertar Hijo izq.
			if(this.izquierdo == null) {
				//Si no hay nada en el lado izquierdo del nodo que hace la llamada, se inserta ahi
				System.out.println("Insertando a la izquierda "+dato);
				this.izquierdo = new NodoArbol(dato);
			}else {
				//Como izquierdo fue el ultimo insertado, es ahora el quien va a decidir donde se inserta el nuevo nodo (a su derecha o izq)
				this.izquierdo.insertarNodo(dato);
			}
		}else {
			//Insertar Hijo der.
			if(this.derecho == null) {
				//Si no hay nada en el lado derecho del nodo que hace la llamada, se inserta ahi
				System.out.println("Insertando a la derecha "+dato);
				this.derecho = new NodoArbol(dato);
			}else {
				//Como derecho fue el ultimo insertado, es ahora el quien va a decidir donde se inserta el nuevo nodo (a su derecha o izq)
				this.derecho.insertarNodo(dato);
			}
		}
	}
	
	
}
