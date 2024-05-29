package views.Department;

public class ViewsDepartment {
	
	public String viewMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("---Department options--- \n");
		sb.append("1) Insert new department \n");
		sb.append("2) Update department \n");
		sb.append("3) Delete by id \n");
		sb.append("4) Find by id \n");
		sb.append("5) Find all departments \n");
		
		return sb.toString();
	}

}
