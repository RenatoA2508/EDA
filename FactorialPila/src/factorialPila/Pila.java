package factorialPila;

public class Pila {
	private Nodo cima;
	
	public boolean esVacia() {
		return cima==null;
	}
	public void push(int dato) {
		Nodo nuevo = new Nodo(dato);
		nuevo.siguiente=cima;
		cima = nuevo;
	}
	public int pop() {
		if(esVacia()) {
			System.out.println("Pila vacia, nada por borrar");
			return -1;
		}
		int datoCima = peek();
		cima = cima.siguiente;
		return datoCima;
		
	}
	
	public void mostrar() {
		if(esVacia()) {
			System.out.println("Pila vacia, nada por mostrar");
		}else {
			Nodo aux= cima;
			while(aux!=null) {
				System.out.println("["+aux.dato+"]");
				aux=aux.siguiente;
			}
		}
	}
	
	public int peek() {
		if(esVacia()) {
			return -1;
		}
		return cima.dato;
	}
	
	
	
}
