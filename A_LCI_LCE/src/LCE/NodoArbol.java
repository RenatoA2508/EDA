package LCE;

class NodoArbol {
    int valor;
    NodoArbol izquierdo, derecho;

    public NodoArbol(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}