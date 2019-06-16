package br.com.senaigo.locadora.utils.formularioUtils;

import br.com.senaigo.locadora.excecoes.ValidacaoException;

import javax.swing.*;

public abstract class CampoDeFormulario <T> {

	protected String nomeDoCampo;
	protected T dadosDoCampo;
	protected boolean isObrigatorio;
	protected ValidacaoComRegex validacao;
	protected final String msgCampoObrigatorio;


	protected CampoDeFormulario(JLabel labelDoCampo, JComponent componente) throws ValidacaoException {
		this.nomeDoCampo = obtenhaNomeDoCampo(labelDoCampo);
		this.isObrigatorio = true;
		this.validacao = ValidacaoTexto.SEM_VALIDACAO_COM_REGEX;
		msgCampoObrigatorio = "O campo \"" + nomeDoCampo +"\" deve ser informado! (Obrigatório)";
		dadosDoCampo = obtenhaDadosDoComponenteValidados(componente);
	}

	protected CampoDeFormulario(JLabel labelDoCampo, JComponent componente, boolean isObrigatorio, ValidacaoComRegex validacao) throws ValidacaoException {
		this.nomeDoCampo = obtenhaNomeDoCampo(labelDoCampo);
		this.isObrigatorio = isObrigatorio;
		this.validacao = validacao;
		msgCampoObrigatorio = "O campo \"" + nomeDoCampo +"\" deve ser informado! (Obrigatório)";
		this.dadosDoCampo = this.obtenhaDadosDoComponenteValidados(componente);
	}
        
        protected CampoDeFormulario(JLabel labelDoCampo, JComponent componente, boolean isObrigatorio) throws ValidacaoException {
		this.nomeDoCampo = obtenhaNomeDoCampo(labelDoCampo);
		this.isObrigatorio = isObrigatorio;
		this.validacao = ValidacaoTexto.SEM_VALIDACAO_COM_REGEX;
		msgCampoObrigatorio = "O campo \"" + nomeDoCampo +"\" deve ser informado! (Obrigatório)";
		this.dadosDoCampo = this.obtenhaDadosDoComponenteValidados(componente);
	}

	private T obtenhaDadosDoComponenteValidados(JComponent componente) throws ValidacaoException {
		T objeto = leiaDadosDoComponente(componente);
		boolean objetoIsTexto = objeto instanceof String;
		String objetoEmTexto = "";
		if(objetoIsTexto) {
			objetoEmTexto = (String) objeto;
		}

		if(this.isObrigatorio) {
			valideEntradaObrigatoria(objeto, objetoIsTexto);
			valideTexto(objetoEmTexto, objetoIsTexto);
		}

		if(!objetoEmTexto.isEmpty()) {
			valideTexto(objetoEmTexto, true);
		}

		facaValidacoesAdicionaisSeNecessario(objetoEmTexto);

		return objeto;
	}

	private void valideTexto(String objetoEmTexto, boolean objetoIsTexto) throws ValidacaoException {
		if(objetoIsTexto && validacao != ValidacaoTexto.SEM_VALIDACAO_COM_REGEX) {
			String regex = this.validacao.obtenhaRegexParaValidacao();

			if(!objetoEmTexto.matches(regex)) {
				String cabecalhoErro = "O campo \"" +nomeDoCampo + "\" é inválido! Siga o padrão abaixo:\n";
				String msgErro = cabecalhoErro + this.validacao.informeComoValidacaoDeveriaSer();
				throw new ValidacaoException(msgErro);
			}
		}
	}

	protected abstract T leiaDadosDoComponente(JComponent componente);

	public T getDadosDoCampo() {
		return this.dadosDoCampo;
	}

	protected void facaValidacoesAdicionaisSeNecessario(String objetoEmTexto)throws ValidacaoException{

	}

	private String obtenhaNomeDoCampo(JLabel labelDoCampo) {
		return labelDoCampo.getText().trim().replace(":", "");
	}

	private void valideEntradaObrigatoria(T objeto, boolean objetoIsTexto) throws ValidacaoException {
		boolean entradaValida = true;

		if(objeto == null) {
			 entradaValida = false;
		}

		if (entradaValida && objetoIsTexto) {
			String objetoEmTexto = (String) objeto;
			entradaValida = !objetoEmTexto.isEmpty();
		}

		if(!entradaValida) {
			throw new ValidacaoException(msgCampoObrigatorio);
		}
	}

}
