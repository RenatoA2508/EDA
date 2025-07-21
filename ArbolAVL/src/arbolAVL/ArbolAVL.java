package arbolAVL;

public class ArbolAVL {
private Nodo raiz; //El árbol empieza desde una raíz. Es un puntero que nunca se moverá para no perder la referencia a la estructura
	
	//Método para insertar nodos en el árbol
	private Nodo insertarNodo(Nodo nodo, int valor) {
		if(nodo == null) { //Condición 1: Si el nodo mandado (raíz) apunta a nulll, es decir, está vacío:
			return new Nodo(valor); //Retornamos la instancia de un nodo nuevo
		}
		if(valor < nodo.valor) { //Condición 2: Si el valor (parámetro) es menor al valor del nodo actual:
			nodo.izquierdo = insertarNodo(nodo.izquierdo, valor); //Recorremos el subárbol izquierdo y se insertará el nodo cuando se cumpla Condición 1 (recursividad)
		}else if(valor > nodo.valor) { //Condición 3: Si el valor (parámetro) es mayor al valor del nodo actual:
			nodo.derecho = insertarNodo(nodo.derecho, valor); //Recorremos el subárbol izquierdo y se insertará el nodo cuando se cumpla Condición 1 (recursividad)
		}else { //Condición 4: (Por descarte) Si el valor (parámetro) es igual al valor de nodo actual:
			return nodo; //Se retorna el nodo actual
		}
		nodo.altura = Math.max(alturaNodo(nodo.izquierdo), alturaNodo(nodo.derecho)) + 1; /*Se calcula la altura del nodo (raíz) actual con la mayor de las 
		alturas del subárbol derecho e izquierdo y sumando 1 porque se añade un nuevo nodo*/
		return balancear(nodo); //Balancea el arbol en caso de que el nodo insertado haya alterado el factor de equilibrio de algun nodo
	}
	
	public void insertar(int dato) {
		raiz = insertarNodo(raiz, dato);
	}
	
	//Eliminar nodo
	private Nodo eliminarNodo(Nodo nodo, int valor) {
		if(nodo==null) return null;
		if(valor < nodo.valor) {
			nodo.izquierdo=eliminarNodo(nodo.izquierdo, valor);
		}else if(valor > nodo.valor) {
			nodo.derecho=eliminarNodo(nodo.derecho, valor);
		}else {
			//Caso Nodo con 0 o 1 hijos
			if(nodo.izquierdo==null) return nodo.derecho;
			if(nodo.derecho==null) return nodo.izquierdo;
			//Caso nodo con 2 hijos
			Nodo sucesor=minimo(nodo.derecho);
			nodo.valor=sucesor.valor;
			nodo.derecho=eliminarNodo(nodo.derecho, sucesor.valor);
		}
		nodo.altura = Math.max(alturaNodo(nodo.izquierdo), alturaNodo(nodo.derecho)) + 1;
		return balancear(nodo);
	}
	public void eliminar(int dato) {
		if (buscarNodo(this.raiz, dato)) {
			raiz = eliminarNodo(raiz, dato);
		}else {
			System.out.println("Dato inexistente en el arbol....");
		}
	}
	//Minimo de un arbol
	private Nodo minimo(Nodo nodo) { //Recibe como parametro la raiz del arbol/subarbol del cual se va a determinar su nodo mas pequeño
		while(nodo.izquierdo != null) {
			nodo = nodo.izquierdo; //Recorre todo el arbol/subarbol a la izquierda y se detiene en el ultimo, que siempre coincide con el nodo de menor valor
		}
		return nodo;
	}
	
	//Buscar nodo
	private boolean buscarNodo(Nodo nodo, int valor) {
		if(nodo==null) return false;
		if(valor == nodo.valor) return true;
		return (valor < nodo.valor )?buscarNodo(nodo.izquierdo, valor):buscarNodo(nodo.derecho, valor);
	}
	//Método para obtener la altura del nodo padre cuando se añade un nodo hijo
	private int alturaNodo(Nodo nodo) {
		if(nodo == null) { //Si el nodo hijo es null, es decir, si no tiene hijo derecho o izquierdo:
			return 0; //Retorna 0. Por definición, la altura de un nodo inexistente es 0.
		}//Si el padre si tiene nodo hijo (izquierda o derecha)
		return nodo.altura; //Retorna la altura del padre
	}
	
	//Método para rotar cuando un nodo está desbalanceado a la izquierda (II / LL)
	private Nodo rotacionSimpleDerecha(Nodo z) { //Parámetro: "z" es el nodo desbalanceado (FE = 2 o FE = -2)
		Nodo y = z.izquierdo; //"y" es el nodo hijo izquierdo de "z", se va a convertir en la nueva raíz del subárbol
		Nodo T2 = y.derecho; //"T2" es el nodo hijo derecho de "y" (si no existe es null)
		y.derecho = z; //"z" pasa a ser el hijo derecho de "y"
		z.izquierdo = T2; //"T2" pasa a ser hijo izquierdo de "z" una vez se ha movido
		z.altura = (Math.max(alturaNodo(z.izquierdo), alturaNodo(z.derecho)) + 1); //Se actualiza la altura del nodo "z" porque se ha movido abajo
		y.altura = (Math.max(alturaNodo(y.izquierdo), alturaNodo(y.derecho)) + 1); //Se actualiza la altura del nodo "y" porque se ha quedado arriba
		return y; //Retorna el nodo "y" debido a que es la nueva raíz del subárbol
	}
	
	//Método para rotar cuando un nodo está desbalanceado a la derecha (DD / RR)
	private Nodo rotacionSimpleIzquierda(Nodo z) { //Parámetro: "z" es el nodo desbalanceado (FE = 2 o FE = -2)
		Nodo y = z.derecho; //"y" es el nodo hijo derecho de "z", se va a convertir en la nueva raíz del subárbol
		Nodo T2 = y.izquierdo; //"T2" es el nodo hijo izquierdo de "y" (si no existe es null)
		y.izquierdo = z; //"z" pasa a ser el hijo izquierdo de "y"
		z.derecho = T2; //"T2" pasa a ser hijo derecho de "z" una vez se ha movido
		z.altura = (Math.max(alturaNodo(z.izquierdo), alturaNodo(z.derecho)) + 1); //Se actualiza la altura del nodo "z" porque se ha movido abajo
		y.altura = (Math.max(alturaNodo(y.izquierdo), alturaNodo(y.derecho)) + 1); //Se actualiza la altura del nodo "y" porque se ha quedado arriba
		return y; //Retorna el nodo "y" debido a que es la nueva raíz del subárbol
	}
	
	//Factor de equilibrio
	private int factorEquilibrio(Nodo nodo) {
		if(nodo==null) return 0;
		return alturaNodo(nodo.izquierdo)-alturaNodo(nodo.derecho);
	}
	//Balancear arbol
	private Nodo balancear(Nodo nodo) {
		//Nota: I->Izquierda L->Left; D->Derecha R->Right
		int fe = factorEquilibrio(nodo);
		//Caso II/LL -> Rotar a la derecha
		if( fe > 1 && factorEquilibrio(nodo.izquierdo) >= 0 ) { //FE desbalanceado = 2 y FE hijo izquierdo = 1 o 0
			return rotacionSimpleDerecha(nodo); 
		}
		//Caso ID/LR -> Rotar primero a la izquierda y luego a la derecha
		if( fe > 1 && factorEquilibrio(nodo.izquierdo) < 0 ) { //FE desbalanceado = 2 y FE hijo izquierdo = -1
			nodo.izquierdo=rotacionSimpleIzquierda(nodo.izquierdo); 
			return rotacionSimpleDerecha(nodo);
		}
		//Caso DD/RR -> Rotar a la izquierda
		if( fe < -1 && factorEquilibrio(nodo.derecho) <= 0 ) { //FE desbalanceado = -2 y FE hijo derecho = -1 o 0
			return rotacionSimpleIzquierda(nodo);
		}
		//Caso DI/RL -> Rotar primero a la derecha y luego a la izquierda
		if( fe < -1 && factorEquilibrio(nodo.derecho) > 0 ) { //FE desbalancead = -2 y FE hijo derecho = 1
			nodo.derecho = rotacionSimpleDerecha(nodo.derecho);
			return rotacionSimpleIzquierda(nodo);
		}
		return nodo;
	}
	
	//Ordenes
	private void InOrder(Nodo nodo) {
		  if (nodo != null) {
	            InOrder(nodo.izquierdo);
	            System.out.print(nodo.valor + " ");
	            InOrder(nodo.derecho);
	        }
	}
	
	public void ImpInOrder() {
		InOrder(raiz);
		System.out.println();
	}
	
	
	@Override
    public String toString() {
        StringBuilder arbol = new StringBuilder();
        imprimirÁrbolAux(raiz, 0, arbol);
        return arbol.toString();
    }

    // Método auxiliar para imprimir el árbol en forma de texto
    private void imprimirÁrbolAux(Nodo nodo, int nivel, StringBuilder arbol) {
        if (nodo != null) {
            imprimirÁrbolAux(nodo.derecho, nivel + 1, arbol);
            for (int i = 0; i < nivel; i++) {
                arbol.append("                 ");
            }
            arbol.append(nodo.valor).append("\n");
            imprimirÁrbolAux(nodo.izquierdo, nivel + 1, arbol);
        }
    }
}
