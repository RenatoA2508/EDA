package factorialPila;

public class PrincipalPila {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero =  1;
		int resultado = FactorialConPila(numero);
		
		System.out.println("El factorial de "+ numero + " es: " +resultado);
	}
	public static int FactorialConPila(int n) {
		Pila pila1 = new Pila();
		//Apilar los valores desde n hasta 1
		while(n>0) {
			System.out.println("Apilando n: " + n);
			pila1.push(n);
			n--;
		}
		//Desapilar y calcular el factorial
		int resultado = 1;
		while(!pila1.esVacia()) {
			System.out.println("Multiplicando valores desapilados...");
			resultado =  resultado*pila1.pop();
			System.out.println("Resultado: "+resultado);
		}
		return resultado;
		
	}
}
