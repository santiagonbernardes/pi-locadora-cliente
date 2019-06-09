package br.com.senaigo.locadora.utils.formularioUtils;

import br.com.senaigo.locadora.excecoes.ValidacaoException;

public interface ValidacaoComRegex {

	abstract String obtenhaRegexParaValidacao();
	abstract String informeComoValidacaoDeveriaSer();

}
