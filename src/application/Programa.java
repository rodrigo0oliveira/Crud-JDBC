package application;

import model.Dao.DaoFactory;
import model.Dao.SellerDao;
import model.entities.Seller;

public class Programa {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("Teste - Seller find by id : ");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);

	}

}
