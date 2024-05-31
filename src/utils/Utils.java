package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Exceptions.DomainException;

public class Utils {
	

	public static Integer readInt(String msg) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.print(msg);
				int num = sc.nextInt();
				return num;
			}
			catch(InputMismatchException e) {
				System.out.println("Valor inválido,digite um novo valor!");
				sc.nextLine();
			}
		}
	
	}

}
