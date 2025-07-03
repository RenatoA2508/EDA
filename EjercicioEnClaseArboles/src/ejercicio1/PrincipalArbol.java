package ejercicio1;

import java.util.Random;

public class PrincipalArbol {

	public static void main(String[] args) {

		int[][] matriz = new int[3][3];

		Arbol arbol = new Arbol();
		Random rd = new Random();
		//Se rellena la matriz y luego el arbol
		for(int i=0; i<matriz.length;i++) {
			for(int j=0; j<matriz[i].length;j++) {
				matriz[i][j]=rd.nextInt(1, 50);
				arbol.Insertar(matriz[i][j]);
			}
		}

		System.out.println();
		System.out.println("Arbol antes de eliminar (InOrden)");
		arbol.InOrden();
		//Recursivamente, se busca el primer multiplo de tres, segun el recorrido InOrder
		int multiploTres =  arbol.primerMultiploDeTres() ;
		if( multiploTres == -1) {
			System.out.println("No hay multiplos de tres");
		}else {
			arbol.Eliminar(multiploTres);
		}
		
		System.out.println();
		System.out.println("Arbol despues de eliminar (InOrden)");
		arbol.InOrden();
	}

}
