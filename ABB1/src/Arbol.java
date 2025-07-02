/**
 * Clase que implementa un Árbol Binario de Búsqueda.
 */
public class Arbol {
    private NodoArbol inicial;

    /**
     * Inserta un nuevo valor en el árbol.
     * @param valor Valor a insertar.
     */
    public void Insertar(int valor) {
    	inicial = InsertarRec(inicial, valor);
    }

    private NodoArbol InsertarRec(NodoArbol nodo, int valor) {
        if (nodo == null) return new NodoArbol(valor);

        if (valor < nodo.valor) {
            nodo.izquierdo = InsertarRec(nodo.izquierdo, valor);
        } else {
            nodo.derecho = InsertarRec(nodo.derecho, valor);
        }
        return nodo;
    }

    /**
     * Verifica si un valor existe en el árbol.
     * @param valor Valor a buscar.
     * @return true si existe, false en caso contrario.
     */
    public boolean Buscar(int valor) {
        return BuscarRec(inicial, valor);
    }

    private boolean BuscarRec(NodoArbol nodo, int valor) {
        if (nodo == null) return false;
        if (valor == nodo.valor) return true;
        return valor < nodo.valor
            ? BuscarRec(nodo.izquierdo, valor)
            : BuscarRec(nodo.derecho, valor);
    }

    /**
     * Elimina un valor del árbol.
     * @param valor Valor a eliminar.
     */
    public void Eliminar(int valor) {
        inicial = EliminarRec(inicial, valor);
    }

    private NodoArbol EliminarRec(NodoArbol nodo, int valor) {
    	System.out.println("imprimiendo nodo.derecho valor: " + nodo.valor + ", " + valor);
        if (nodo == null) return null;

        if (valor < nodo.valor) {
            nodo.izquierdo = EliminarRec(nodo.izquierdo, valor);
        } else{ 
        	
        	if (valor > nodo.valor) {
        		nodo.derecho = EliminarRec(nodo.derecho, valor);
        	} else {
            // Caso: nodo sin hijos o un solo hijo
            if (nodo.izquierdo == null) return nodo.derecho;
            if (nodo.derecho == null) return nodo.izquierdo;

            // Caso: nodo con dos hijos
            NodoArbol sucesor = Minimo(nodo.derecho);
            nodo.valor = sucesor.valor;
            System.out.println("valor de nodo.derecho que envío a eliminar: " + nodo.valor);
            nodo.derecho = EliminarRec(nodo.derecho, sucesor.valor);
            
        	}
        }
        return nodo;
    }

    /**
     * Retorna el valor mínimo del árbol.
     * @return Valor mínimo.
     * @throws RuntimeException si el árbol está vacío.
     * método público que da el valor mínimo (un int).
     */
    public int Minimo() {
        if (inicial == null) throw new RuntimeException("Árbol vacío");
        //Minimo(inicial) obtiene una referencia al nodo mínimo, no el entero del valor.
        return Minimo(inicial).valor;
    }
    
    /**
     * método privado recursivo que da el nodo mínimo (NodoArbol).
     * @param nodo: es el nodo.derecho del nodo a eliminar
     * @return nodo mínimo (NodoArbol)
     */
    private NodoArbol Minimo(NodoArbol nodo) {
    	System.out.println("Nodo......................: " + nodo.valor);
    	while (nodo.izquierdo != null) {
        	System.out.println("Valor de nodo.izq: " + nodo.valor + ", ");
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    /**
     * Retorna el valor máximo del árbol.
     * @return Valor máximo.
     * @throws RuntimeException si el árbol está vacío.
     */
    public int Maximo() {
        if (inicial == null) throw new RuntimeException("Árbol vacío");
        NodoArbol actual = inicial;
        while (actual.derecho != null) {
            actual = actual.derecho;
        }
        return actual.valor;
    }

    /**
     * Verifica si el árbol está vacío.
     * @return true si está vacío, false en caso contrario.
     */
    public boolean EstaVacio() {
        return inicial == null;
    }

    /**
     * Retorna la cantidad de nodos del árbol.
     * @return Número de nodos.
     */
    public int Tamaño() {
        return TamañoRec(inicial);
    }

    private int TamañoRec(NodoArbol nodo) {
        if (nodo == null) return 0;
        return 1 + TamañoRec(nodo.izquierdo) + TamañoRec(nodo.derecho);
    }

    /**
     * Recorrido InOrder.
     */
    public void InOrden() {
        InOrdenRec(inicial);
        System.out.println();
    }

    private void InOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            InOrdenRec(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            InOrdenRec(nodo.derecho);
        }
    }

    /**
     * Recorrido PreOrder.
     */
    public void PreOrden() {
        PreOrdenRec(inicial);
        System.out.println();
    }

    private void PreOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            PreOrdenRec(nodo.izquierdo);
            PreOrdenRec(nodo.derecho);
        }
    }

    /**
     * Recorrido PostOrder.
     */
    public void PostOrden() {
        PostOrdenRec(inicial);
        System.out.println();
    }

    private void PostOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            PostOrdenRec(nodo.izquierdo);
            PostOrdenRec(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }
}
