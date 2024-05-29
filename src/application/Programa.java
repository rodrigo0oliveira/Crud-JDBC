package application;

import java.util.ArrayList;
import java.util.List;

import model.Dao.DaoFactory;
import model.Dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Programa {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("Teste 1- Seller find by id : ");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("");
		
		System.out.println("Teste 2- Seller find by department : ");
		List<Seller> listSeller = new ArrayList<Seller>();
		Department department = new Department(2,null);
		
		listSeller = sellerDao.findByDepartment(department);
		
		for(Seller obj : listSeller) {
			System.out.println(obj);
		}

	}

}
