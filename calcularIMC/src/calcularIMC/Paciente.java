package calcularIMC;

public class Paciente {
    Double altura, peso;

    public Paciente(Double altura, Double peso) {
        this.altura = altura;
        this.peso = peso;
    }

    public double calcularIMC() {
        if (peso <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Peso e altura devem ser maiores que 0 (zero)");
        }

        return peso / (altura * altura);
    }

    public String diagnostico() {
        return IMC.getDiagnostico(calcularIMC());
    }

    enum IMC {
        BAIXO_PESO_MUITO_GRAVE(-999999999, 16.00, "Baixo peso muito grave = IMC abaixo de 16 kg/m²"),
        BAIXO_PESO_GRAVE(16.00, 17.00, "Baixo peso grave = IMC entre 16 e 16,99 kg/m²"),
        BAIXO_PESO(17.00, 18.50, "Baixo peso = IMC entre 17 e 18,49 kg/m²"),
        PESO_NORMAL(18.50, 25.00, "Peso normal = IMC entre 18,50 e 24,99 kg/m²"),
        SOBREPESO(25.00, 30.00, "Sobrepeso = IMC entre 25 e 29,99 kg/m²"),
        OBESIDADE_GRAU_I(30.00, 35.00, "Obesidade grau I = IMC entre 30 e 34,99 kg/m²"),
        OBESIDADE_GRAU_II(35.00, 40.00, "Obesidade grau II = IMC entre 35 e 39,99 kg/m²"),
        OBESIDADE_GRAU_III(40.00, 999999999, "Obesidade grau III (obesidade mórbida) = IMC maior que 40 kg/m²");

        IMC(double superior, double inferior, String label) {
            limiteSuperior = superior;
            limiteInferior = inferior;
            informacao = label;
        }

        private double limiteSuperior;
        private double limiteInferior;
        private String informacao;

        static String getDiagnostico(double imc) {
        	
            String resultado = "Não foi possível calcular IMC.";
            for (IMC escala : IMC.values()) {
                if (imc >= escala.limiteSuperior && imc < escala.limiteInferior) {
                    resultado = escala.informacao;
                }
            }

            return resultado;
        }
    }
}
