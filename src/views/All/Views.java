package views.All;

public class Views {
	
	public static String option() {
		StringBuilder sb = new StringBuilder();
		sb.append("----Cadastro,visualização e modificação de vendedores e departamentos---- \n");
		sb.append("Escolha uma opção \n");
		sb.append("\n");
		sb.append("D) Departamento \n");
		sb.append("S) Vendedor \n");
		sb.append("E) Fechar sistema \n");
		sb.append("\n");
		
		return sb.toString();
	}

}
