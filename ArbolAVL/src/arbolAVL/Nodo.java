package arbolAVL;

public class Nodo {
	public int altura; //Definición: La altura de un nodo es el número de niveles desde ese nodo hasta su hoja más profunda.
	public int valor;
	public Nodo derecho;
	public Nodo izquierdo;
	
	public Nodo(int valor) {
		this.altura = 1; /*La altura de un nodo suelto (sin hijos) es 1 por definición. Este atributo cambiará 
		cuando el nodo tenga hijos y forme parte de un árbol.*/
		this.valor = valor;
		this.derecho = null; 
		this.izquierdo = null;
	}
}