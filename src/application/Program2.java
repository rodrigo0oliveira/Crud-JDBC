package application;

import java.util.ArrayList;
import java.util.List;

import model.Dao.DaoFactory;
import model.Dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		/*
		 * System.out.println("-------------------");
		 * System.out.println("Teste 1 - insert department"); Department department =
		 * new Department(null,"Produtos"); departmentDao.insert(department);
		 */
		
		/*
		 * System.out.println("-------------------");
		 * System.out.println("Teste 2 - update department"); departmentDao.update(new
		 * Department(11,"Roupas"));
		 */

		/*
		 * System.out.println("-------------------");
		 * System.out.println("Teste 3 - delete by id department");
		 * departmentDao.deleteById(12);
		 */

		/*
		 * System.out.println("-------------------");
		 * System.out.println("Teste 4 - find by id department"); Department department
		 * = departmentDao.findById(1); System.out.println(department);
		 */
		
		System.out.println("-------------------");
		System.out.println("Teste 5 - findAll department");
		List<Department> listDepartment = new ArrayList<Department>();
		listDepartment = departmentDao.findAll();
		
		for(Department obj : listDepartment) {
			System.out.println(obj);
		}
		
		

	}

}
