package views.Department;

public class ViewsDepartment {
	
	public static String viewMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("---Opções departamento--- \n");
		sb.append("1) Inserir novo departamento \n");
		sb.append("2) Atualizar departamento \n");
		sb.append("3) Deletar por id \n");
		sb.append("4) Listar por id \n");
		sb.append("5) Listar todos os departamentos \n");
		
		return sb.toString();
	}

}
