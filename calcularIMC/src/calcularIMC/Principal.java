package calcularIMC;
public class Principal {

	public static void main(String[] args) {
		Paciente joao = new Paciente(1.50, 50.0);
		Paciente maria = new Paciente(1.78, 96.0);
		Paciente jose = new Paciente(2.00, 100.00);

		System.out.println(String.format("IMC de %s que corresponde %s", joao.calcularIMC(), joao.diagnostico()));
		System.out.println(String.format("IMC de %s que corresponde %s", maria.calcularIMC(), maria.diagnostico()));
		System.out.println(String.format("IMC de %s que corresponde %s", jose.calcularIMC(), jose.diagnostico()));
	}
}
