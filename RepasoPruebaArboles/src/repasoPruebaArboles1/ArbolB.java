package repasoPruebaArboles1;

public class ArbolB {
	private NodoArbol inicial;
	
	public void insertar(int valor) {
		inicial = insertarNodo(inicial, valor);
	}
	private NodoArbol insertarNodo(NodoArbol nodo, int valor) {
		if(nodo == null) return new NodoArbol(valor);
		
		if(valor < nodo.valor) {
			nodo.izquierdo = insertarNodo(nodo.izquierdo, valor);
		}else {
			nodo.derecho = insertarNodo(nodo.derecho, valor);
		}
		return nodo;
	}
	
//	private NodoArbol insertarNodo2(NodoArbol nodo, int valor) {
//		if(nodo==null) return new NodoArbol(valor);
//		
//		if(valor<nodo.valor) {
//			nodo.izquierdo = insertarNodo2(nodo.izquierdo, valor);
//		}else {
//			nodo.derecho = insertarNodo2(nodo.derecho, valor);
//		}
//		return nodo;
//	}
//	
//	private NodoArbol insertarNod(NodoArbol nodo, int valor) {
//		if(nodo == null) return new NodoArbol(valor);
//		
//		if(valor<nodo.valor) {
//			nodo.izquierdo = insertarNod(nodo.izquierdo, valor);
//		}else {
//			nodo.derecho = insertarNod(nodo.derecho, valor);
//		}
//		return nodo;
//	}
	
	public boolean buscar(int valor) {
		return buscarNodo(inicial, valor);
	}
	
	private boolean buscarNodo(NodoArbol nodo, int valor) {
		if(nodo == null) return false;
		if(nodo.valor == valor ) return true;
		return (valor < nodo.valor)?buscarNodo(nodo.izquierdo, valor):buscarNodo(nodo.derecho, valor);
	}
	
//	private boolean buscarNodo2(NodoArbol nodo, int valor) {
//		if(nodo==null) return false;
//		if(nodo.valor == valor) return true;
//		return (valor < nodo.valor)?buscarNodo(nodo.izquierdo, valor):buscarNodo(nodo.derecho, valor);
//	}
//	private boolean buscarNodo3(NodoArbol nodo, int valor) {
//		if(nodo==null) return false;
//		if(nodo.valor == valor) return true;
//		return (valor < nodo.valor)?buscarNodo(nodo.izquierdo, valor):buscarNodo(nodo.izquierdo, valor);
//	}
	public int minimo() {
		if(inicial == null) throw new RuntimeException("Arbol vacio, nada por buscar");
		return minimo(inicial).valor;
	}
	
	private NodoArbol minimo(NodoArbol nodo) {
		while(nodo.izquierdo != null) {
			nodo=nodo.izquierdo;
		}
		return nodo;
	}
	
	
//	public int minimo2() {
//		if(inicial == null) throw new RuntimeException("Arbol vacio bro");
//		return minimo(inicial).valor;
//	}
//	private NodoArbol minimo2(NodoArbol nodo) {
//		while(nodo.izquierdo != null) {
//			nodo = nodo.izquierdo;
//		}
//		return nodo;
//	}
//	
//	public int minimo3() {
//		return minimo(inicial).valor;
//	}
//	
//	private NodoArbol minimo3(NodoArbol nodo) {
//		while(nodo.izquierdo !=null) {
//			nodo= nodo.izquierdo;
//		}
//		return nodo;
//	}
	
//	private NodoArbol insertarNodes(NodoArbol nodo, int valor) {
//		if(nodo==null) return new NodoArbol(valor);
//		if(valor < nodo.valor) {
//			nodo.izquierdo = insertarNodes(nodo.izquierdo, valor);
//		}else {
//			nodo.derecho = insertarNodes(nodo.derecho, valor);
//		}
//		return nodo;
//	}
//	private boolean buscarNode(NodoArbol nodo, int valor) {
//		if(nodo == null) return false;
//		if(valor == nodo.valor) return true;
//		return (valor < nodo.valor)?buscarNodo(nodo.izquierdo, valor):buscarNodo(nodo.derecho, valor);
//	}
//	private NodoArbol minimo(NodoArbol nodo) {
//		while(nodo.izquierdo !=null) {
//			nodo=nodo.izquierdo;
//		}
//		return nodo;
//	}
	public int tamaño() {
		return tamaño(inicial);
	}
	private int tamaño(NodoArbol nodo) {
		if(nodo == null) return 0;
		return 1 + tamaño(nodo.izquierdo)+tamaño(nodo.derecho);
	}
	
//	public int tamaño2() {
//		return tamaño(inicial);
//	}
//	private int tamaño2(NodoArbol nodo) {
//		if(nodo==null) return 0;
//		return 1+tamaño(nodo.izquierdo)+tamaño(nodo.derecho);
//	}
	public int Maximo() {
		if(inicial == null) throw new RuntimeException("Arbol vacio");
		NodoArbol aux = inicial;
		while(aux.derecho != null) {
			aux = aux.derecho;
		}
		return aux.valor;
	}
	
	public void Ordenes() {
		PreOrden(inicial);
		System.out.println();
		InOrden(inicial);
		System.out.println();
		PostOrden(inicial);
		System.out.println();
		
	}
	
	private void PreOrden(NodoArbol nodo) {
		if(nodo==null) return;
		System.out.print(nodo.valor + "-"); //R
		PreOrden(nodo.izquierdo); //I
		PreOrden(nodo.derecho); //D
	}
	
	private void InOrden(NodoArbol nodo) {
		if(nodo==null) return;
		InOrden(nodo.izquierdo);//I
		System.out.print(nodo.valor+"- ");//R
		InOrden(nodo.derecho);//D
	}
	
	private void PostOrden(NodoArbol nodo) {
		if(nodo==null) return;
		PostOrden(nodo.izquierdo);//I
		PostOrden(nodo.derecho);//D
		System.out.print(nodo.valor + "-");//R
	}
	
	public void eliminarNodo(int valor) {
		if(inicial==null) throw new RuntimeException("Arbol vacio, nada por eliminar");
		inicial = eliminarNodo(inicial, valor);
	}
	
	private NodoArbol eliminarNodo(NodoArbol nodo, int valor) {
		if(nodo == null) return null;
		if(valor < nodo.valor) {
			nodo.izquierdo = eliminarNodo(nodo.izquierdo, valor);
		}else if(valor > nodo.valor) {
			nodo.derecho = eliminarNodo(nodo.derecho, valor);
		}else {
			if(nodo.derecho == null) return nodo.izquierdo;
			if(nodo.izquierdo== null) return nodo.derecho;
			
			NodoArbol sucesor = minimo(nodo.derecho);
			nodo.valor = sucesor.valor;
			System.out.println("Nodo eliminado: "+sucesor.valor);
			nodo.derecho = eliminarNodo(nodo.derecho, sucesor.valor); 
		}
		
		return nodo;
	}
	
	
	public void eliminarNodo2(int valor) {
		if(inicial==null) throw new RuntimeException("Arbol vacio, nada por borrar");
		inicial = eliminarNodo(inicial, valor);
	}
	
//	private NodoArbol eliminarNodo2(NodoArbol nodo, int valor) {
//		if(nodo == null) return null;
//		
//		if(valor < nodo.valor) {
//			nodo.izquierdo = eliminarNodo2(nodo.izquierdo, valor);
//		}else if(valor > nodo.valor) {
//			nodo.derecho = eliminarNodo2(nodo.derecho, valor);
//		}else {
//			if(nodo.derecho == null ) return nodo.izquierdo;
//			if(nodo.izquierdo == null ) return nodo.derecho;
//			
//			NodoArbol sucesor = minimo(nodo.derecho);
//			nodo.valor = sucesor.valor;
//			System.out.println("Nodo eliminado: "+sucesor.valor);
//			nodo.derecho = eliminarNodo2(nodo.derecho, sucesor.valor);
//		}
//		return nodo;
//	}
//	
//	public void eliminarNodo3(int valor) {
//		if(inicial==null) throw new RuntimeException("Arbol vacio");
//		inicial = eliminarNodo3(inicial, valor);
//	}
//	
//	
//	private NodoArbol eliminarNodo3(NodoArbol nodo, int valor) {
//		if(nodo==null) return null;
//		if(valor < nodo.valor) {
//			nodo.izquierdo = eliminarNodo3(nodo.izquierdo, valor);
//		}else if( valor > nodo.valor) {
//			nodo.derecho = eliminarNodo3(nodo.derecho, valor);
//		}else {
//			if(nodo.derecho == null) return nodo.izquierdo;
//			if(nodo.izquierdo== null) return nodo.derecho;
//			
//			NodoArbol sucesor = minimo(nodo.derecho);
//			nodo.valor = sucesor.valor;
//			System.out.println("Nodo a eliminar: "+sucesor.valor);
//			nodo.derecho = eliminarNodo3(nodo.derecho, sucesor.valor);
//		}
//		return nodo;
//	}
	public int calculoLCI() {
		return LCI(inicial, 1);
	}
	
	private int LCI(NodoArbol nodo, int profundidad) {
		if(nodo==null) return 0;
		
		if(nodo.izquierdo==null && nodo.derecho == null) return 0;
		
		return profundidad + LCI(nodo.derecho, profundidad + 1) + LCI(nodo.izquierdo, profundidad+1);
	}
	
	public int calculoLCE() {
		return LCE(inicial, 1);
	}
	
	private int LCE(NodoArbol nodo, int profundidad) {
		if(nodo==null) return 0;
		
		if(nodo.izquierdo ==null && nodo.derecho == null) return profundidad;
		
		return LCE(nodo.izquierdo, profundidad+1)+LCE(nodo.derecho, profundidad+1);
	}
	
	public int calculoLCI2() {
		return LCI2(inicial, 1);
	}
	
	private int LCI2(NodoArbol nodo, int profundidad) {
		if(nodo==null) return 0;
		
		if(nodo.derecho == null && nodo.izquierdo ==null) return 0;
		
		return profundidad + LCI(nodo.derecho, profundidad+1)+ LCI(nodo.izquierdo, profundidad+1);
	}
	
	
	
	public int calculoLCE2() {
		return LCE2(inicial, 1);
	}
	
	private int LCE2(NodoArbol nodo, int profundidad) {
		if(nodo==null) return 0;
		if(nodo.derecho ==null && nodo.izquierdo == null) return profundidad;
		
		return LCE(nodo.derecho, profundidad + 1) + LCE(nodo.izquierdo, profundidad+1);
	}
	
	private int multiploTres(NodoArbol nodo) {
		if(nodo==null) return -1;
		
		int encontrado = multiploTres(nodo.izquierdo);
		if(encontrado!=-1) return encontrado;
		
		if(nodo.valor % 3 == 0) return nodo.valor;
		
		return multiploTres(nodo.derecho);
		
	}
	
	
	private int MultiploTres(NodoArbol nodo) {
		if(nodo==null) return -1;
		int encontrado = MultiploTres(nodo.izquierdo);
		if(encontrado!=-1) return encontrado;
		
		if(nodo.valor % 3 == 0) return nodo.valor;
		
		return MultiploTres(nodo.derecho);
	}
	
	
	private int multTres(NodoArbol nodo) {
		if(nodo==null) return -1;
		
		int encontrado = multTres(nodo.izquierdo);
		
		if(encontrado!=-1) return encontrado;
		
		if(nodo.valor % 3 == 0) return nodo.valor;
		
		return multTres(nodo.derecho);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

	



