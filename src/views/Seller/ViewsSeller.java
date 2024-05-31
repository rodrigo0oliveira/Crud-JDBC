package views.Seller;

public class ViewsSeller {
	
	
	public static String viewMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("---Opções vendedor \n");
		sb.append("1) Inserir novo vendedor \n");
		sb.append("2) Atualizar vendedor \n");
		sb.append("3) Deletar por id \n");
		sb.append("4) Listar por id \n");
		sb.append("5) Listar por departamento \n"); 
		sb.append("6) Listar todos os vendedores \n");
		
		return sb.toString();
	}
	
	
}
