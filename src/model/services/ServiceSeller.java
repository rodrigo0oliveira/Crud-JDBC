package model.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.Dao.DaoFactory;
import model.Dao.SellerDao;
import model.Exceptions.DomainException;
import model.entities.Department;
import model.entities.Seller;
import utils.Utils;

public class ServiceSeller {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	
	private static SellerDao sellerDao = DaoFactory.createSellerDao();
	
	public static void insertSeller() {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		try {
			System.out.print("Digite o nome do vendedor: ");
			String name = sc.nextLine();
			System.out.print("Digite o e-mail do vendedor: ");
			String email = sc.nextLine();
			System.out.print("Digite a data de aniversário do vendedor (dd-MM-yyyy HH:mm:ss) :");
			String date = sc.nextLine();
			Date data = sdf.parse(date);
			sc.nextLine();
			System.out.print("Digite o salário do vendedor: ");
			Double baseSalary = sc.nextDouble();
			System.out.print("Digite o id do departamento do vendedor: ");
			int id = sc.nextInt();
			
			Department department = new Department(id,null);
			Seller seller = new Seller(null,name,email,data,baseSalary,department);
			
			String result = sellerDao.insert(seller);
			
			System.out.println(result);
			
		} catch (ParseException e) {
			throw new DomainException(e.getMessage());
		}
	}
	
	public static void updateSeller() {
		
		try {
			int id = Utils.readInt("Digite o id do vendedor que deseja atualizar: ");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Digite o nome do vendedor: ");
			String name = sc.nextLine();
			System.out.print("Digite o e-mail do vendedor: ");
			String email = sc.nextLine();
			System.out.print("Digite a data de aniversário do vendedor (dd-MM-yyyy HH:mm:ss) :");
			String date = sc.nextLine();
			Date data = sdf.parse(date);
			sc.nextLine();
			System.out.print("Digite o salário do vendedor: ");
			Double baseSalary = sc.nextDouble();
			System.out.print("Digite o id do departamento do vendedor: ");
			int sellerId = sc.nextInt();
			
			Department department = new Department(id,null);
			Seller seller = new Seller(id,name,email,data,baseSalary,department);
			
			String result = sellerDao.update(seller);
			
			System.out.println(result);
		}
		catch(ParseException e) {
			throw new DomainException(e.getMessage());
		}
	}
	
	public static void deleteByIdSeller() {
		int id = Utils.readInt("Digite o id do vendedor que deseja remover: ");
		String result = sellerDao.deleteById(id);
		
		System.out.println(result);
	}
	
	public static void findByIdSeller() {
		int id = Utils.readInt("Digite o id do vendedor que deseja buscar: ");
		Seller seller = sellerDao.findById(id);
		
		if(seller!=null) {
			System.out.println("Vendedor encontrado :"+seller);
		}
		else {
			System.out.println("Vendedor não encontrado!");
		}
	}
	
	public static void findByDepartmentSeller() {
		List<Seller> listSeller = new ArrayList<Seller>();
		
		int id = Utils.readInt("Digite o id do departamento que deseja buscar: ");
		
		listSeller = sellerDao.findByDepartment(new Department(id,null));
		
		if(listSeller.size()>0) {
			for (Seller seller : listSeller) {
				System.out.println(seller);
			}
		}
		else {
			System.out.println("Nao existem vendedores nesse departamento!");
		}
		
	}
	
	public static void findAllSeller() {
		List<Seller> listSeller = new ArrayList<Seller>();
		
		listSeller = sellerDao.findAll();
		
		if(listSeller.size()>0) {
			for (Seller seller : listSeller) {
				System.out.println(seller);
			}
		}
		else {
			System.out.println("Nao existem vendedores cadastrados!");
		}
		
		
	}

}
