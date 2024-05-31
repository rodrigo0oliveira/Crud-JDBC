package views.All;

public class Views {
	
	public static String option() {
		StringBuilder sb = new StringBuilder();
		sb.append("Choose an option you want to check \n");
		sb.append("\n");
		sb.append("D) Department \n");
		sb.append("S) Seller \n");
		sb.append("E) Exit the sistem");
		
		return sb.toString();
	}

}
