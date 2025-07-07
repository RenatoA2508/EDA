package repasoArboles3;

public class Arbol {
	private Nodo inicial;
	
	private boolean esVacio() {
		return inicial==null;
	}
	
	public void insertar(int valor) {
		inicial = insertarNodo(inicial, valor);
	}
	
	private Nodo insertarNodo(Nodo nodo, int valor) {
		if(nodo==null) return new Nodo(valor);
		
		if(valor < nodo.valor) {
			nodo.izquierdo=insertarNodo(nodo.izquierdo, valor);
		}else {
			nodo.derecho=insertarNodo(nodo.derecho, valor);
		}
		return nodo;
	}
	
	public int minimo() {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		return minimo(inicial).valor;
	}
	
	private Nodo minimo(Nodo nodo) {
		while(nodo.izquierdo!=null) {
			nodo=nodo.izquierdo;
		}
		return nodo;
	}
	
	public void eliminar(int valor) {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		inicial = eliminarNodo(inicial, valor);
	}
	
	private Nodo eliminarNodo(Nodo nodo, int valor) {
		if(nodo==null) return null;
		
		if(valor < nodo.valor) {
			nodo.izquierdo=eliminarNodo(nodo.izquierdo, valor);
		}else if(valor > nodo.valor) {
			nodo.derecho=eliminarNodo(nodo.derecho, valor);
		}else {
			if(nodo.izquierdo==null) return nodo.derecho;
			if(nodo.derecho==null) return nodo.izquierdo;
			Nodo sucesor = minimo(nodo.derecho);
			nodo.valor = sucesor.valor;
			System.out.println("Nodo a eliminar: "+valor);
			nodo.derecho=eliminarNodo(nodo.derecho, sucesor.valor);
		}
		return nodo;
	}
	public boolean buscar(int valor) {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		return buscarNodo(inicial, valor);
	}
	
	private boolean buscarNodo(Nodo nodo, int valor) {
		if(nodo==null) return false;
		if(valor==nodo.valor) return true;
		return(valor < nodo.valor)?buscarNodo(nodo.izquierdo, valor):buscarNodo(nodo.derecho, valor);
	}
	
	private int tamañoNodo(Nodo nodo) {
		if(nodo==null) return 0;
		return 1+tamañoNodo(nodo.izquierdo)+tamañoNodo(nodo.derecho);
	}
	public int tamaño() {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		return tamañoNodo(inicial);
	}
	
	public int calculoLCI() {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		return LCI(inicial, 1);
	}
	
	private int LCI(Nodo nodo, int profundidad) {
		if(nodo==null) return 0;
		if(nodo.izquierdo==null && nodo.derecho==null) return 0;
		return profundidad + LCI(nodo.izquierdo, profundidad +1)+LCI(nodo.derecho, profundidad+1);
	}
	
	public int calculoLCE() {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		return LCE(inicial, 1);
	}
	private int LCE(Nodo nodo, int profundidad) {
		if(nodo==null) return 0;
		if(nodo.izquierdo==null && nodo.derecho==null) return profundidad;
		
		return LCE(nodo.izquierdo, profundidad+1)+LCE(nodo.derecho, profundidad+1);
	}
	
	private void PreOrden(Nodo nodo) {
		if(nodo==null) return;
		System.out.print(nodo.valor + "-");
		PreOrden(nodo.izquierdo);
		PreOrden(nodo.derecho);
	}
	private void InOrden(Nodo nodo) {
		if(nodo==null) return;
		InOrden(nodo.izquierdo);
		System.out.print(nodo.valor + "-");
		
		InOrden(nodo.derecho);
	}
	private void PostOrden(Nodo nodo) {
		if(nodo==null) return;
		
		PostOrden(nodo.izquierdo);
		PostOrden(nodo.derecho);
		System.out.print(nodo.valor + "-");
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
	
	private Nodo maximo(Nodo nodo) {
		while(nodo.derecho!=null) {
			nodo=nodo.derecho;
		}
		return nodo;
		
	}
	public int maximo() {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		return maximo(inicial).valor;
	}
	
	public int primerMultTres() {
		if(esVacio()) throw new RuntimeException("Arbol vacio");
		return multiploTres(inicial);
	}
	
	private int multiploTres(Nodo nodo) {
		if(nodo==null) return -1;
		
		int encontrado = multiploTres(nodo.izquierdo);
		if(encontrado!=-1) return encontrado;
		
		if(nodo.valor%3==0) return nodo.valor;
		
		return multiploTres(nodo.derecho);
	}
	
}


