package br.com.senaigo.locadora.utils.formularioUtils;

import br.com.senaigo.locadora.excecoes.ValidacaoException;

import javax.swing.*;

public class CampoInteiro extends CampoDeFormulario {

	public CampoInteiro(JLabel labelDoCampo, JComponent componente, boolean isObrigatorio, ValidacaoComRegex validacao) throws ValidacaoException {
		super(labelDoCampo, componente, isObrigatorio, validacao);
	}

	@Override
	protected Object leiaDadosDoComponente(JComponent componente) {
		return null;
	}
}
