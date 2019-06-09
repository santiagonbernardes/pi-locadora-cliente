package br.com.senaigo.locadora.utils.formularioUtils;

public enum ValidacaoTexto implements ValidacaoComRegex {

	SEM_VALIDACAO_COM_REGEX() {
		@Override
		public String obtenhaRegexParaValidacao() {
			return null;
		}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return null;
		}
	},
	NOME_MARCA_CATEGORIA(){
		@Override
		public String obtenhaRegexParaValidacao() {
			return "^[-'a-zA-ZÀ-ÖØ-öø-ÿ\\s]{1,15}$";
		}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return 	"* Até 15 caracteres;\n" +
					"* Letras (A-z permitindo acentuações válidas em português);\n" +
					"* Cedilha (ç);\n" +
					"* Hífen (-);\n" +
					"* Apóstrofe (‘).";
		}
	},
	CARRO_KM() {
		@Override
		public String obtenhaRegexParaValidacao() {
			return "^\\d{0,7}$";
		}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return "* Até 7 dígitos;\n" +
					"* Somente números (0-9).";
		}
	}


}
