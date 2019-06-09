package br.com.senaigo.locadora.utils.formularioUtils;

public enum ValidacaoNumerica implements ValidacaoComRegex {

	VALORES_MONETARIOS_CATEGORIA() {
		@Override
		public String obtenhaRegexParaValidacao() {
			return "^[0-9]{0,4}?($|\\.[0-9]{1,2}$)";
		}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return "* Apenas números (0-9);\n" +
					"* Separador '.';\n" +
					"* Até 6 dígitos (Até 4 antes do ponto e até 2 após);\n" +
					"* Valor mínimo: 0.01;\n" +
					"* Valor máximo: 9999.99.";
		}
	};
}
