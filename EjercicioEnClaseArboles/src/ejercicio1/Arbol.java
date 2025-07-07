package ejercicio1;

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
    public boolean Buscar(int valor) {
        return BuscarRec(inicial, valor);
    }

    private boolean BuscarRec(Nodo nodo, int valor) {
        if (nodo == null) return false;
        if (valor == nodo.valor) return true;
        return valor < nodo.valor
            ? BuscarRec(nodo.izquierdo, valor)
            : BuscarRec(nodo.derecho, valor);
    }
    
    public void InOrden() {
        InOrdenRec(inicial);
        System.out.println();
    }

    private void InOrdenRec(Nodo nodo) {
        if (nodo != null) {
            InOrdenRec(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            InOrdenRec(nodo.derecho);
        }
    }
    
    
    public int primerMultiploDeTres() {
        return buscarMultiploDeTres(inicial);
    }
    
    private int buscarMultiploDeTres(Nodo nodo) {
        if (nodo == null) return -1; //Caso base

        int encontrado = buscarMultiploDeTres(nodo.izquierdo); //Recorre el subarbol izquierdo (I)
        if (encontrado != -1) return encontrado;        

        if (nodo.valor % 3 == 0)  return nodo.valor; //Visita la raiz (R)

        return buscarMultiploDeTres(nodo.derecho); ////Recorre el subarbol derecho (R)
    }
    
    
    public void Eliminar(int valor) {
        inicial = eliminarNodo(inicial, valor);
    }

//    private Nodo EliminarRec(Nodo nodo, int valor) {
//    	System.out.println("imprimiendo nodo.derecho valor: " + nodo.valor + ", " + valor);
//        if (nodo == null) return null;
//
//        if (valor < nodo.valor) {
//            nodo.izquierdo = EliminarRec(nodo.izquierdo, valor);
//        } else{ 
//        	
//        	if (valor > nodo.valor) {
//        		nodo.derecho = EliminarRec(nodo.derecho, valor);
//        	} else {
//            // Caso: nodo sin hijos o un solo hijo
//            if (nodo.izquierdo == null) return nodo.derecho;
//            if (nodo.derecho == null) return nodo.izquierdo;
//
//            // Caso: nodo con dos hijos
//            Nodo sucesor = Minimo(nodo.derecho);
//            nodo.valor = sucesor.valor;
//            System.out.println("valor de nodo.derecho que envío a eliminar: " + nodo.valor);
//            nodo.derecho = EliminarRec(nodo.derecho, sucesor.valor);
//            
//        	}
//        }
//        return nodo;
//    }
    private Nodo eliminarNodo(Nodo nodo, int valor) {
		if(nodo == null) return null;
		if(valor < nodo.valor) {
			nodo.izquierdo = eliminarNodo(nodo.izquierdo, valor);
		}else if(valor > nodo.valor) {
			nodo.derecho = eliminarNodo(nodo.derecho, valor);
		}else {
			if(nodo.derecho == null) return nodo.izquierdo;
			if(nodo.izquierdo== null) return nodo.derecho;
			
			Nodo sucesor = Minimo(nodo.derecho);
			nodo.valor = sucesor.valor;
			System.out.println("Nodo eliminado: "+nodo.valor);
			nodo.derecho = eliminarNodo(nodo.derecho, sucesor.valor); 
		}
		return nodo;
	}
    
    
    public int Minimo() {
        if (inicial == null) throw new RuntimeException("Árbol vacío");
        //Minimo(inicial) obtiene una referencia al nodo mínimo, no el entero del valor.
        return Minimo(inicial).valor;
    }
    
    private Nodo Minimo(Nodo nodo) {
    	System.out.println("Nodo......................: " + nodo.valor);
    	while (nodo.izquierdo != null) {
        	System.out.println("Valor de nodo.izq: " + nodo.valor + ", ");
            nodo = nodo.izquierdo;
        }
        return nodo;
    }
}
