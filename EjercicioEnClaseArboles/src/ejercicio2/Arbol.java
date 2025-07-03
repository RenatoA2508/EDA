package ejercicio2;

public class Arbol {
	public Nodo inicial;
	
	public void Insertar(int valor) {
    	inicial = InsertarRec(inicial, valor);
    }
    private Nodo InsertarRec(Nodo nodo, int valor) {
        if (nodo == null) return new Nodo(valor);

        if (valor < nodo.valor) {
            nodo.izquierdo = InsertarRec(nodo.izquierdo, valor);
        } else {
            nodo.derecho = InsertarRec(nodo.derecho, valor);
        }
        return nodo;
    }
  //Recorrido preorden: R-I-D
  	public void EjecutarPreOrder() {
  		PreOrder(inicial);
  	}
  	private void PreOrder(Nodo nodo) {
  		if(nodo == null) { //Caso base
  			return;
  		}
  		System.out.print(nodo.valor + "-"); //Visita la raiz (R)
  		PreOrder(nodo.izquierdo); //Recorre el subarbol izquierdo (I)
  		PreOrder(nodo.derecho); //Recorre el subarbol derecho (D)
  		
  	}
  	//Recorrido preorden: I-R-D
  	public void EjecutarInOrder() {
  		InOrder(inicial);
  	}
  	private void InOrder(Nodo nodo) {
  		if(nodo == null) { //Caso base
  			return;
  		}
  		InOrder(nodo.izquierdo); //Recorre el subarbol izquierdo (I)
  		System.out.print(nodo.valor + "-"); //Visita la raiz (R)
  		InOrder(nodo.derecho); //Recorre el subarbol derecho (D)
  		
  	}
  	//Recorrido preorden: I-D-R
  	public void EjecutarPostOrder() {
  		PostOrder(inicial);
  	}
  	private void PostOrder(Nodo nodo) {
  		if(nodo == null) { //Caso base
  			return;
  		}
  		PostOrder(nodo.izquierdo); //Recorre el subarbol izquierdo (I)
  		PostOrder(nodo.derecho); //Recorre el subarbol derecho (D)
  		System.out.print(nodo.valor + "-"); //Visita la raiz (R)
  		
  	}
  	
  	public int calcularLCI() {
        return calcularLCIRec(inicial, 1);
    }

    private int calcularLCIRec(Nodo nodo, int profundidad) {
        if (nodo == null) return 0;

        // Si es hoja, no se cuenta en LCI
        if (nodo.izquierdo == null && nodo.derecho == null) {
            return 0;
        }

        return profundidad + 
               calcularLCIRec(nodo.izquierdo, profundidad + 1) +
               calcularLCIRec(nodo.derecho, profundidad + 1);
    }

    public int calcularLCE() {
        return calcularLCERec(inicial, 1);
    }

    private int calcularLCERec(Nodo nodo, int profundidad) {
        if (nodo == null) return 0;

        if (nodo.izquierdo == null && nodo.derecho == null) {
            return profundidad;
        }

        return calcularLCERec(nodo.izquierdo, profundidad + 1) +
               calcularLCERec(nodo.derecho, profundidad + 1);
    }
}
