package arbolAVL;

import java.util.Scanner;

public class MainArbolAVL {
    public static void main(String[] args) {
    	ArbolAVL arbol = new ArbolAVL();
    	int dato;
    	int [] tree;
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Ingrese la cantidad de datos para su arbol:");
    	int cantidad = sc.nextInt();
    	
    	tree = new int[cantidad];
    	for (int i = 0; i < cantidad; i++) {
			System.out.println("Ingrese el " + (i+1) + " dato de su arbol:");
			dato = sc.nextInt();
			arbol.insertar(dato);
		}
    	
    	System.out.println("Recorrido del arbol: ");
    	arbol.ImpInOrder();
    	
    	System.out.println("\n" + arbol.toString()+"\n");
    	
    	System.out.println("Ingrese un dato a eliminar del arbol: ");
    	dato = sc.nextInt();
    	arbol.eliminar(dato);
    	
    	System.out.println("Recorrido del arbol (DESPUES DE ELIMINAR EL DATO): ");
    	arbol.ImpInOrder();
    	
    	System.out.println("\n"+arbol.toString()+"\n");
    }
}
