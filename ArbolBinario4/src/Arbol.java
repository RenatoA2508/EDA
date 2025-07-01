/**
 * Clase que implementa un Árbol Binario de Búsqueda.
 */
public class Arbol {
	private NodoArbol inicial;
	
	
	
	public Arbol () {
		inicial = null;
	}
		
	public NodoArbol getInicial() {
		return inicial;
	}

	//insertar nodos 
	public void Insertar(int valor) {
		//System.out.println("Estoy en Insertar árbol...");
		
		if(this.inicial==null) {
			//System.out.println("entra al this.inicial = null");
			this.inicial = new NodoArbol(valor);
		}else {
			//System.out.println("Inicial: " + inicial.getValor() + ", valor:" + valor);
			this.inicial.InsertarNodo(valor);
		}
	}
			
    /**
     * Verifica si un valor existe en el árbol.
     * @param valor Valor a buscar.
     * @return true si existe, false en caso contrario.
     */
	public void BuscarNodo(NodoArbol nodo, int elemento) {
		if(nodo==null) {
			System.out.println("Arbol Vacio");
			return;
		}else {
			if(elemento==nodo.getValor()) {
				System.out.println("Elemento " + elemento +" localizado.");
			}
			if(elemento<nodo.getValor()) {
				System.out.println("Buscar en subárbol izquierdo...");
				BuscarNodo(nodo.getIzquierdo(), elemento);
			}
			if(elemento>nodo.getValor()) {
				System.out.println("Buscar en subárbol derecho...");
				BuscarNodo(nodo.getDerecho(), elemento);
			}
		}
	}
	
	//Buscar con while - No recursivo 
	public boolean BuscarNodo2(NodoArbol nodo, int dato) {
		NodoArbol auxiliar = nodo;
		while (dato != auxiliar.getValor()) {
			if(dato < auxiliar.getValor() ) {
				auxiliar = auxiliar.getIzquierdo();
			}else {
				auxiliar = auxiliar.getDerecho();
			}
			
			if(auxiliar == null) {
				return false;
			}
		}
		
		return true;
	}
	
	
	
	 /**
     * Elimina un nodo del árbol.
     * @param dato: Valor a eliminar.
     */
	public boolean EliminarNodo(int dato) {
		NodoArbol auxiliar = inicial;
		NodoArbol padre = inicial;
		boolean esHijoIzquierdo=true;
		
		while (dato != auxiliar.getValor()) {
			padre=auxiliar;
			
			if(dato < auxiliar.getValor() ) {
				auxiliar = auxiliar.getIzquierdo();
				
			}else {
				auxiliar = auxiliar.getDerecho();
				esHijoIzquierdo=false;
			}
			
			if(auxiliar == null) {
				return false;
			}
		}
		
		if(auxiliar.EsHoja()) {
			EliminarNodoHoja(padre, auxiliar, esHijoIzquierdo);
		}else {
			if(auxiliar.getIzquierdo()==null || auxiliar.getDerecho()==null){
				EliminarNodoUnHijo(padre, auxiliar, esHijoIzquierdo);
			}
		}
			
	
		return true;
	}
	
	
	private void EliminarNodoUnHijo(NodoArbol padre, NodoArbol auxiliar, boolean esHijoIzquierdo) {
		if(auxiliar.getDerecho()==null) {
			if(auxiliar==inicial) {
				inicial =auxiliar.getIzquierdo();
			}else {
				if(esHijoIzquierdo) {
					padre.setIzquierdo(auxiliar.getIzquierdo());
				}else {
					padre.setDerecho(auxiliar.getIzquierdo());
				}
			}
		}else {
			if(auxiliar.getIzquierdo()==null) {
				if(auxiliar==inicial) {
					inicial =auxiliar.getDerecho();
				}else {
					if(esHijoIzquierdo) {
						padre.setIzquierdo(auxiliar.getDerecho());
					}else {
						padre.setDerecho(auxiliar.getDerecho());
					}
				}
			}
		}
	}
	
	
	private void EliminarNodoHoja(NodoArbol padre, NodoArbol auxiliar, boolean esHijoIzquierdo) {
		if(auxiliar==inicial) {
			inicial = null;
		}else {
			if(esHijoIzquierdo) {
				padre.setIzquierdo(null);
			}else {
				padre.setDerecho(null);
			}
		}
			
	}
	
	
    // Eliminar un nodo - otro método - Si func.
    public void Eliminar2(int valor) {
        inicial = EliminarNodo2(inicial, valor);
    }

    private NodoArbol EliminarNodo2(NodoArbol nodo, int valor) {
        if (nodo == null) {
            return null;
        }

        if (valor < nodo.getValor()) {
            nodo.setIzquierdo(EliminarNodo2(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getValor()) {
            nodo.setDerecho(EliminarNodo2(nodo.getDerecho(), valor));
        } else {
            // Caso 1: Nodo hoja
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                return null;
            }
            // Caso 2: Un solo hijo
            else if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }
            // Caso 3: Dos hijos
            else {
                NodoArbol sucesor = EncontrarMinimo(nodo.getDerecho());
                nodo.setValor(sucesor.getValor());
                nodo.setDerecho(EliminarNodo2(nodo.getDerecho(), sucesor.getValor()));
            }
        }

        return nodo;
    }

    // Sucesor in-order (mínimo del subárbol derecho)
    private NodoArbol EncontrarMinimo(NodoArbol nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }
	
	//Recorrido preorden
	/*public void EjecutarPreorder() {
		this.PreOrder(this.inicial);
	}*/
	
	public void PreOrder(NodoArbol nodo) {
		//Caso base-detener recursividad
		if(nodo == null) {
			return;
		}else {
			System.out.print(nodo.getValor() + ", ");
			PreOrder(nodo.getIzquierdo());
			PreOrder(nodo.getDerecho());
		}
	}
	
	public void InOrder(NodoArbol nodo) {
		//Caso base-detener recursividad
		if(nodo == null) {
			return;
		}else {
			InOrder(nodo.getIzquierdo());
			System.out.print(nodo.getValor() + ", ");
			InOrder(nodo.getDerecho());
		}
	}
	
	public void PostOrder(NodoArbol nodo) {
		//Caso base-detener recursividad
		if(nodo == null) {
			return;
		}else {
			PostOrder(nodo.getIzquierdo());
			PostOrder(nodo.getDerecho());
			System.out.print(nodo.getValor() + ", ");		
		}
	}
		
}
