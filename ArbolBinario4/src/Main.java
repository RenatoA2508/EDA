
public class Main {
	public static void main (String[] args) {
		Arbol arbol1 = new Arbol();
		
		arbol1.Insertar(8);
		arbol1.Insertar(5);
		arbol1.Insertar(10);
		arbol1.Insertar(3);
		arbol1.Insertar(6);
		arbol1.Insertar(11);
		
		
		System.out.println("Recorrido InOrder: ");
		arbol1.InOrder(arbol1.getInicial());
				
		arbol1.EliminarNodo(8);
		
		System.out.println();
		System.out.println("\nDespués de borrar un nodo");
		System.out.println("Recorrido InOrder: ");
		arbol1.InOrder(arbol1.getInicial());
		
		/*
	
			
		arbol1.Eliminar(25);
		
		System.out.println();
		System.out.println("\nDespués de borrar un nodo");
		System.out.println("Recorrido InOrder: ");
		arbol1.InOrder(arbol1.getInicial());
		
		
		System.out.println("Recorrido Preorder: " );
		arbol1.PreOrder(arbol1.getInicial());
	
		System.out.println("\nRecorrido PostOrder: ");
		arbol1.PostOrder(arbol1.getInicial());
		
		System.out.println("Buscar:..." );
		//System.out.println();
		arbol1.BuscarNodo(arbol1.getInicial(), 78);
		
		//System.out.println("\nAltura Árbol: ");
		//System.out.println(arbol1.AlturaArbol(arbol1.getInicial()));
		///*/
		
	}
}
