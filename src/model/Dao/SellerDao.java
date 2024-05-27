package model.Dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {
	
	void insert(Seller seller);
	
	void update(Seller seller);
	
	public void deleteById(Integer id);
	
	public Seller findById(Integer id);
	
	public List<Seller> findAll();

}
