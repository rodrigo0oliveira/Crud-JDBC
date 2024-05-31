package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Exceptions.DomainException;

public class Utils {
	
	@SuppressWarnings("resource")
	public static Integer readInt(String msg) {
		Scanner sc = new Scanner(System.in);
		boolean verification = true;
		while(verification==true) {
			try {
				System.out.print(msg);
				int num = sc.nextInt();
				
				return num;
			}
			catch(InputMismatchException e) {
				throw new DomainException("Error!Invalid type. ERROR: "+e.getMessage());
			}
		}
		return null;
	
	}

}
