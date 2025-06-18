package cuentaRegresiva;

import java.util.Scanner;

public class PrincipalCuentaRegresiva {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=0;
		CuentaRegresiva cr = new CuentaRegresiva();
		System.out.println("CUENTA REGRESIVA");
		System.out.println("Ingrese n: ");
		n = sc.nextInt();
		cr.contar(n);
	}

}
