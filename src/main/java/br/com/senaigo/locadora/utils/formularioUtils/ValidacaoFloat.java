package br.com.senaigo.locadora.utils.formularioUtils;

public enum ValidacaoFloat implements ValidacaoComRegex {

	SETE_DIGITOS(5) {
		@Override
		public String obtenhaRegexParaValidacao() {return obtenhaRegexLimitandoDigitosAntesDoSeparador();}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return obtenhaMensagemPadrao();
		}
	},
	SEIS_DIGITOS(4) {
		@Override
		public String obtenhaRegexParaValidacao() {
			return obtenhaRegexLimitandoDigitosAntesDoSeparador();
		}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return obtenhaMensagemPadrao();
		}
	};

	protected final String regex;
	protected final int qtdDigitosAntesSeparador;

	ValidacaoFloat(int qtdDigitosAntesSeparador) {
		this.qtdDigitosAntesSeparador = qtdDigitosAntesSeparador;
		this.regex = obtenhaRegexLimitandoDigitosAntesDoSeparador();
	}

	protected String obtenhaRegexLimitandoDigitosAntesDoSeparador() {
		return "^[0-9]{0," + this.qtdDigitosAntesSeparador + "}?($|\\.[0-9]{1,2}$)";
	}

	protected String obtenhaMensagemPadrao() {
		int totalDeDigitos = qtdDigitosAntesSeparador + 2;
		String valorMinimo = obtenhaValorMinimo();
		String valorMaximo = obtenhaValorMaximo();
		return "* Apenas números (0-9);\n" +
				"* Separador '.';\n" +
				"* Até " + totalDeDigitos + " dígitos (Até "+qtdDigitosAntesSeparador+" antes do ponto e até 2 após);\n" +
				"* Valor mínimo: " + valorMinimo + ";\n" +
				"* Valor máximo: " + valorMaximo + ".";
	}

	protected String obtenhaValorMinimo() {
		String valorMinimo = "";

		valorMinimo += obtenhaRepeticaoDoParametro(0);

		valorMinimo += ".01";
		return valorMinimo;
	}

	protected String obtenhaValorMaximo() {
		String valorMaximo = "";

		valorMaximo += obtenhaRepeticaoDoParametro(9);

		valorMaximo += ".99";

		return valorMaximo;
	}

	protected String obtenhaRepeticaoDoParametro(int numeroRepetido) {
		StringBuilder repeticao = new StringBuilder();
		for (int i = 0; i < qtdDigitosAntesSeparador; i++) {
			repeticao.append(numeroRepetido);
		}
		return repeticao.toString();
	}
}
