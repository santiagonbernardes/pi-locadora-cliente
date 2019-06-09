package br.com.senaigo.locadora.utils.formularioUtils;

import br.com.senaigo.locadora.excecoes.ValidacaoException;

import javax.swing.*;

public class CampoComboBox<T> extends CampoDeFormulario {

	public CampoComboBox(JLabel labelDoCampo, JComboBox componente) throws ValidacaoException {
		super(labelDoCampo, componente);
	}

	@Override
	protected T leiaDadosDoComponente(JComponent componente) {
		JComboBox componenteComboBox = (JComboBox) componente;

		T objeto = (T) componenteComboBox.getSelectedItem();
		return objeto;
	}
}
