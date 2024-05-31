package controller;

import java.util.Scanner;

import model.services.ServiceDepartment;
import model.services.ServiceSeller;
import utils.Utils;
import views.All.Views;
import views.Department.ViewsDepartment;
import views.Seller.ViewsSeller;

public class Controller {
	
	
	public static void controllerProject() {
	
		Scanner sc = new Scanner(System.in);
		
		final String viewsAll = Views.option();
		final String viewsDepartment = ViewsDepartment.viewMenu();
		final String viewsSeller = ViewsSeller.viewMenu();
		
		System.out.println(viewsAll);
		char opcion = sc.next().toUpperCase().charAt(0);
		while(opcion!='E') {
			
			if(opcion == 'D') {
				System.out.println(viewsDepartment);
				int option = Utils.readInt("Digite uma opção : ");
				
				switch (option) {
					case 1:
						ServiceDepartment.insertNewDepartment();
						break;
					case 2:
						ServiceDepartment.updateDepartment();
						break;
					case 3:
						ServiceDepartment.deleteByIdDepartment();
						break;
					case 4:
						ServiceDepartment.findByIdDepartment();
						break;
					case 5:
						ServiceDepartment.findAllDepartments();
						break;
					default:
						System.out.println("Opção inválida!\n");
						System.out.println(viewsDepartment);
						opcion = sc.next().toUpperCase().charAt(0);
				}
		
			}
			
			else if(opcion == 'S') {
				System.out.println(viewsSeller);
				int option = Utils.readInt("Digite uma opção : ");
				
				switch(option) {
					case 1:
						ServiceSeller.insertSeller();
						break;
					case 2:
						ServiceSeller.updateSeller();
						break;
					case 3:
						ServiceSeller.deleteByIdSeller();
						break;
					case 4:
						ServiceSeller.findByIdSeller();
						break;
					case 5:
						ServiceSeller.findByDepartmentSeller();
						break;
					case 6:
						ServiceSeller.findAllSeller();
						break;
					default:
						System.out.println("Opção inválida!\n");
						System.out.println(viewsSeller);
						opcion = sc.next().toUpperCase().charAt(0);

				}
			}
			else {
				System.out.println("Opção inválida. Digite uma noca opção!");
				System.out.println(viewsAll);
				opcion = sc.next().toUpperCase().charAt(0);
			}
			
			System.out.println(viewsAll);
			opcion = sc.next().toUpperCase().charAt(0);
		}
	
		
		
		sc.close();
	}
}

