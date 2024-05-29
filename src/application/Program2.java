package application;

import model.Dao.DaoFactory;
import model.Dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("-------------------");
		System.out.println("Teste 1 - insert department");
		Department department = new Department(null,"Produtos");
		departmentDao.insert(department);
		
		

	}

}
