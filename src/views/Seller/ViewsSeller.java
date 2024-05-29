package views.Seller;

public class ViewsSeller {
	
	
	public String viewMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("---Seller options--- \n");
		sb.append("1) Insert new seller \n");
		sb.append("2) Update seller \n");
		sb.append("3) Delete by id \n");
		sb.append("4) Find by id \n");
		sb.append("5) Find by department \n"); 
		sb.append("6) Find all sellers \n");
		
		return sb.toString();
	}
	
	
}
