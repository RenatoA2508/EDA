package ejercicio1;

import java.util.Random;

public class PrincipalArbol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matriz = new int[3][3];
		//int[][] matriz2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 11}};
		Arbol arbol = new Arbol();
		Random rd = new Random();
		for(int i=0; i<matriz.length;i++) {
			for(int j=0; j<matriz[i].length;j++) {
				matriz[i][j]=rd.nextInt(1, 50);
				arbol.Insertar(matriz[i][j]);
			}
		}

		System.out.println();
		System.out.println("Arbol antes de eliminar (InOrden)");
		arbol.InOrden();
		
		int multiploTres =  arbol.InOrdenMultTres() ;
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
