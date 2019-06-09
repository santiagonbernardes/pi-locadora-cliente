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
	NOME_MARCA_CATEGORIA() {
		@Override
		public String obtenhaRegexParaValidacao() {
			return "^[-'a-zA-ZÀ-ÖØ-öø-ÿ\\s]{1,15}$";
		}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return "* Até 15 caracteres;\n" +
					"* Letras (A-z permitindo acentuações);\n" +
					"* Cedilha (ç);\n" +
					"* Hífen (-);\n" +
					"* Apóstrofo (‘).";
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
	},

	NOME_COMPLETO_PADRAO() {
		@Override
		public String obtenhaRegexParaValidacao() {
			return "^[-'a-zA-ZÀ-ÖØ-öø-ÿ\\s]{1,50}$";
		}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return "* Até 50 caracteres;\n" +
					"* Letras (A-z permitindo acentuações);\n" +
					"* Cedilha (ç);\n" +
					"* Hífen (-);\n" +
					"* Apóstrofo (‘).";
		}
	},
	DATA() {
		@Override
		public String obtenhaRegexParaValidacao() {
			return "^\\d{1,2}?\\/\\d{1,2}?\\/\\d{4}?$";
		}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return "* Somente números (0-9);\n" +
					"* Formato dd/MM/yyyy (dia/mês/ano).";
		}
	},
	LOGRADOURO() {
		@Override
		public String obtenhaRegexParaValidacao() {
			return "^[-'0-9a-zA-ZÀ-ÖØ-öø-ÿ\\s]{1,30}$";
		}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return "* Até 30 caracteres;\n" +
					"* Letras (A-z permitindo acentuações);\n" +
					"* Números (0-9);\n" +
					"* Cedilha (ç);\n" +
					"* Hífen (-);\n" +
					"* Apóstrofo (‘).";
		}
	},
	NOME_MODELO() {
		@Override
		public String obtenhaRegexParaValidacao() {
			return "^[-'0-9a-zA-ZÀ-ÖØ-öø-ÿ\\s]{1,15}$";
		}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return "* Até 15 caracteres;\n" +
					"* Letras (A-z permitindo acentuações);\n" +
					"* Números (0-9);\n" +
					"* Cedilha (ç);\n" +
					"* Hífen (-);\n" +
					"* Apóstrofo (‘).";
		}
	},
	NUMERO_ENDERECO() {
		@Override
		public String obtenhaRegexParaValidacao() {
			return "^[-0-9a-zA-Z\\s]{1,6}$";
		}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return "* Até 6 caracteres;\n" +
					"* Letras (A-z);\n" +
					"* Números (0-9);\n" +
					"* Hífen (-).";
		}
	},
	CIDADE() {
		@Override
		public String obtenhaRegexParaValidacao() {
			return "^[-'a-zA-ZÀ-ÖØ-öø-ÿ\\s]{1,20}$";
		}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return "* Até 20 caracteres;\n" +
					"* Letras (A-z permitindo acentuações);\n" +
					"* Cedilha (ç);\n" +
					"* Hífen (-);\n" +
					"* Apóstrofo (‘).";
		}
	},
	COMPLEMENTO_ENDERECO() {
		@Override
		public String obtenhaRegexParaValidacao() {
			return "^[-\\.,'0-9a-zA-ZÀ-ÖØ-öø-ÿ\\s]{1,30}$";
		}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return "* Até 30 caracteres;\n" +
					"* Letras (A-z permitindo acentuações);\n" +
					"* Números (0-9);\n" +
					"* Cedilha (ç);\n" +
					"* Hífen (-);\n" +
					"* Vírgula (,);\n" +
					"* Ponto Final (.);\n" +
					"* Apóstrofo (‘).";
		}
	},
	BAIRRO_ENDERECO() {
		@Override
		public String obtenhaRegexParaValidacao() {
			return "^[-\\.'0-9a-zA-ZÀ-ÖØ-öø-ÿ\\s]{1,30}$";
		}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return "* Até 30 caracteres;\n" +
					"* Letras (A-z permitindo acentuações);\n" +
					"* Números (0-9);\n" +
					"* Cedilha (ç);\n" +
					"* Hífen (-);\n" +
					"* Ponto Final (.);\n" +
					"* Apóstrofo (‘).";
		}
	},
        RAZAO_SOCIAL() {
            @Override
		public String obtenhaRegexParaValidacao() {
			return "^[-'0-9a-zA-ZÀ-ÖØ-öø-ÿ\\s]{1,50}$";
		}

		@Override
		public String informeComoValidacaoDeveriaSer() {
			return "* Até 50 caracteres;\n" +
					"* Letras (A-z permitindo acentuações);\n" +
                                        "* Números (0-9);\n" +
					"* Cedilha (ç);\n" +
					"* Hífen (-);\n" +
					"* Apóstrofo (‘).";
		}
        }


}
