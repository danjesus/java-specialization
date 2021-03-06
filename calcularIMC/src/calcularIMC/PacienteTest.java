package calcularIMC;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;

public class PacienteTest {

	@Test(expectedExceptions=IllegalArgumentException.class)
	public void pesoOuAlturaInvalidosDeveRetornarUmaExcecao() {
		Paciente stub = new Paciente(0.0, 0.0);
		stub.diagnostico();	
	}
	
	@DataProvider(name="DiagnosticoDataProvider")
	public Object[][] criarDados()
	{
		return new Object[][] {
			{1.78, 96.0, "Obesidade grau I = IMC entre 30 e 34,99 kg/m²"},
			{1.10, 10.0, "Baixo peso muito grave = IMC abaixo de 16 kg/m²"},
			{1.10, 20.0, "Baixo peso grave = IMC entre 16 e 16,99 kg/m²"},
			{1.10, 22.0, "Baixo peso = IMC entre 17 e 18,49 kg/m²"},
			{1.10, 25.0, "Peso normal = IMC entre 18,50 e 24,99 kg/m²"},
			{1.10, 32.0, "Sobrepeso = IMC entre 25 e 29,99 kg/m²"},
			{1.10, 40.0, "Obesidade grau I = IMC entre 30 e 34,99 kg/m²"},
			{1.10, 45.0, "Obesidade grau II = IMC entre 35 e 39,99 kg/m²"},
			{1.10, 100.0, "Obesidade grau III (obesidade mórbida) = IMC maior que 40 kg/m²"},
		};
	}
	
	@Test(dataProvider= "DiagnosticoDataProvider")
	public void verificarDiagnotico(Double altura, Double peso, String resultadoEsperado)
	{
		Paciente paciente = new Paciente(altura, peso);
		assertEquals(resultadoEsperado, paciente.diagnostico());
	}
}
