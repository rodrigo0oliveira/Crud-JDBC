package model.Dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {
	
	String insert(Department department);
	
	String update(Department department);
	
	String deleteById(Integer id);
	
	Department findById(Integer id);
	
	List<Department> findAll();
	

}
