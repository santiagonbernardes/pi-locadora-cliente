package br.com.senaigo.locadora.utils.formularioUtils;

import br.com.senaigo.locadora.excecoes.ValidacaoException;

import javax.swing.*;

public class CampoEmail extends CampoDeTexto {

	public CampoEmail(JLabel labelDoCampo, JTextField componenteDoCampo, boolean isObrigatorio) throws ValidacaoException {
		super(labelDoCampo, componenteDoCampo, isObrigatorio, ValidacaoTexto.SEM_VALIDACAO_COM_REGEX);
		System.out.println("E-mail não validado");
	}

	@Override
	protected void facaValidacoesAdicionaisSeNecessario(String objetoEmTexto) throws ValidacaoException {
		if(objetoEmTexto.length() > 64) {
			throw new ValidacaoException("Um e-mail pode ter no máximo 64 caracteres!");
		}
	}
}
