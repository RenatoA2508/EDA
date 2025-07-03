package LCE;

class ABB {
    NodoArbol raiz;

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private NodoArbol insertarRec(NodoArbol nodo, int valor) {
        if (nodo == null) {
            return new NodoArbol(valor);
        }
        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRec(nodo.derecho, valor);
        }
        return nodo;
    }

    public int calcularLCI() {
        return calcularLCIRec(raiz, 1);
    }

    private int calcularLCIRec(NodoArbol nodo, int profundidad) {
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
        return calcularLCERec(raiz, 1);
    }

    private int calcularLCERec(NodoArbol nodo, int profundidad) {
        if (nodo == null) return 0;

        if (nodo.izquierdo == null && nodo.derecho == null) {
            return profundidad;
        }

        return calcularLCERec(nodo.izquierdo, profundidad + 1) +
               calcularLCERec(nodo.derecho, profundidad + 1);
    }
}
