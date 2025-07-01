/**
 * Clase que representa un nodo del árbol binario de búsqueda.
 * implemento getters y setters
 * implemento método EsHoja?
 * tambien método para insertar NodoArbol
 */
public class NodoArbol {
    private int valor;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    public NodoArbol(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }

	public int getValor() {
		return valor;
	}
	 

	public NodoArbol getIzquierdo() {
		return izquierdo;
	}
	
	public NodoArbol getDerecho() {
		return derecho;
	}
	
	//Setters
	public void setValor(int valor) {
		this.valor = valor;
	}

	public void setIzquierdo(NodoArbol izquierdo) {
		this.izquierdo = izquierdo;
	}

	public void setDerecho(NodoArbol derecho) {
		this.derecho = derecho;
	}	
	
	public boolean EsHoja() {
		return (this.izquierdo== null && this.derecho==null);
	}
	
	
	public void InsertarNodo(int valor) {
		if(valor < this.valor) {
			//insertar hijo izq.
			if(this.izquierdo == null) {
				//System.out.println("Hijo izq = null, insertando..." + valor );
				this.izquierdo = new NodoArbol(valor);
			}else {
				//System.out.println("Llamada recursiva hijo izq. a InsertarNodo con " + valor);
				this.izquierdo.InsertarNodo(valor);
			}
			
		}else {
			//insertar hijo der.
			if(this.derecho == null) {
				//System.out.println("Hijo der = null, insertando..." + valor );
				this.derecho = new NodoArbol(valor);
			}else {
				//System.out.println("Llamada recursiva hijo der. a InsertarNodo con " + valor);
				this.derecho.InsertarNodo(valor);
			}
		}
	}

	
		
}
