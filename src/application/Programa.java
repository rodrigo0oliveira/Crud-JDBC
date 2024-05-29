package application;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.Dao.DaoFactory;
import model.Dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("Teste 1- Seller find by id : ");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("--------");
		
		System.out.println("Teste 2- Seller find by department : ");
		List<Seller> listSeller = new ArrayList<Seller>();
		Department department = new Department(2,null);
		
		listSeller = sellerDao.findByDepartment(department);
		
		for(Seller obj : listSeller) {
			System.out.println(obj);
		}
		
		System.out.println("--------");
		
		System.out.println("Teste 3- find all : ");
		listSeller = sellerDao.findAll();
		
		for(Seller obj : listSeller) {
			System.out.println(obj);
		}
		
		System.out.println("--------");
		
		System.out.println("Teste 3- seller insert : ");
		listSeller = sellerDao.findAll();
		
		Seller seller2 = new Seller(null,"Rodrigo","rodrigo@gmail",new Date(0),4000.00,department);
		sellerDao.insert(seller2);
		System.out.println("Insert - new Seller : "+seller2.getId());

	}

}
