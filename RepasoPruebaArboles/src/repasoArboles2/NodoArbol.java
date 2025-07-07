package repasoArboles2;

public class NodoArbol {
	public int valor;
	NodoArbol izquierdo, derecho;
	
	public NodoArbol(int valor) {
		this.valor = valor;
		izquierdo=derecho=null;
	}
}
