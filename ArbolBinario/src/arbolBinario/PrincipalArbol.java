package arbolBinario;

import java.util.Scanner;

public class PrincipalArbol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArbolBinario arbol1 = new ArbolBinario();
		int opcion;
		do {
			System.out.println();
			System.out.println("1. Insertar Nodo");
			System.out.println("2. Buscar nodo");
			System.out.println("3. Imprimir PreOrder");
			System.out.println("4. Imprimir InOrder");
			System.out.println("5. Imprimir PostOrder");
			System.out.println("6. Salir");
			System.out.println("Ingrese la opcion deseada: ");
			opcion= sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("--INSERTAR NODO--");
				System.out.println("Ingrese un valor: ");
				int nodo = sc.nextInt();
				arbol1.insertar(nodo);
				break;
			case 2:
				System.out.println("--BUSCAR NODO--");
				System.out.println("Ingrese un valor a buscar: ");
				int aBuscar = sc.nextInt();
				arbol1.ejecutarBuscarNodo(aBuscar);
				break;
			case 3:
				System.out.println("--PRE ORDER--");
				arbol1.EjecutarPreOrder();
				break;
			case 4:
				System.out.println("--IN ORDER--");
				arbol1.EjecutarInOrder();
				break;
			case 5:
				System.out.println("--POST ORDER--");
				arbol1.EjecutarPostOrder();
				break;
			case 6:
				System.out.println("Gracias por usar el programa :)");
				break;
			default:
				System.out.println("Ingrese una opcion valida");
				break;
			}
		}while(opcion != 6);
		
		
		
	}

}
