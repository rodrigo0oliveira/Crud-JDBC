package model.services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Dao.DaoFactory;
import model.Dao.DepartmentDao;
import model.Exceptions.DomainException;
import model.entities.Department;
import utils.Utils;


public class ServiceDepartment {
	
	private static DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	
	public static void insertNewDepartment() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Digite o nome do novo departamento: ");
			String departmentName = sc.next();
			
			Department department = new Department(null,departmentName);
			String result = departmentDao.insert(department);
			
			System.out.println(result);
			
		}
		catch(InputMismatchException e) {
			throw new DomainException(e.getMessage()); 
		}
		
		
	}
	
	public static void updateDepartment() {
		try {
			Scanner sc = new Scanner(System.in);
			
			int id = Utils.readInt("Digite o id que deseja atualizar:");
			System.out.print("Digite o novo nome do departamento: ");
			
			String departmentName = sc.next();
			Department department = new Department(id,departmentName);
			String result = departmentDao.update(department);
			
			System.out.println(result);
		}
		catch(InputMismatchException e) {
			throw new DomainException(e.getMessage());
		}
	}
	
	public static void deleteByIdDepartment() {
			Scanner sc = new Scanner(System.in);
			int id = Utils.readInt("Digite o id do departamento que deseja remover:");
			String result = departmentDao.deleteById(id);
			
			System.out.println(result);
			
	}
	
	public static void findByIdDepartment() {
		Scanner sc = new Scanner(System.in);
		int id = Utils.readInt("Digite o id do departamento que deseja buscar:");
		Department department = departmentDao.findById(id);
		
		if(department!=null) {
			System.out.println("Departamento encontrado : "+department);
		}
		else {
			System.out.println("Departamento não encontrado com esse código!");
		}
		
	}
	
	public static void findAllDepartments() {
		
		List<Department> listDepartments = new ArrayList<Department>();
		listDepartments = departmentDao.findAll();
		
		for(Department department : listDepartments) {
			System.out.println(department);
		}
	}
}
