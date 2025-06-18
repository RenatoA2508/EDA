package cuentaRegresiva;

public class CuentaRegresiva {
	
	public void contar(int n) {
		if(n==0) {
			System.out.println("Empecemos!");
			return;
		}
		System.out.println(n);
		contar(n-1);
	}
}
