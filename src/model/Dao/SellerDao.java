package model.Dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {
	
	String insert(Seller seller);
	
	String update(Seller seller);
	
	String deleteById(Integer id);
	
	Seller findById(Integer id);
	
	List<Seller> findByDepartment(Department department);
 	
	List<Seller> findAll();

}
