package ejercicio2;

import java.util.Random;
import java.util.Scanner;

public class PrincipalArbol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		int[] listado;
		
		System.out.println("Ingrese el numero de nodos del arbol (entre 5 y 15): ");
		n = sc.nextInt();
		while(n>15 || n<5) {
			System.out.println("Numero fuera de rango, intentelo de nuevo");
			n=sc.nextInt();
		}
		listado = new int[n];
		Random rd = new Random();
		Arbol arbol = new Arbol();
		
		for(int i=0; i < listado.length; i++) {
			listado[i]=rd.nextInt(0, 20) + 1; //Genera numeros entre 1 y 20
			arbol.Insertar(listado[i]);
		}
		//PreOrden
		System.out.println("PRE ORDER");
		arbol.EjecutarPreOrder();
		System.out.println();
		//InOrder
		System.out.println("IN ORDER");
		arbol.EjecutarInOrder();
		System.out.println();
		//PostOrder
		System.out.println("POST ORDER");
		arbol.EjecutarPostOrder();
		System.out.println();
		
		System.out.println("Longitud de Camino Interno (LCI): " + arbol.calcularLCI());
        System.out.println("Longitud de Camino Externo (LCE): " + arbol.calcularLCE());
		
		
	}

}
