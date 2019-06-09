package br.com.senaigo.locadora.utils.formularioUtils;

import br.com.senaigo.locadora.excecoes.ValidacaoException;
import br.com.senaigo.locadora.utils.Utils;

import javax.swing.*;

public class CampoDeTexto extends CampoDeFormulario <String> {

	public CampoDeTexto(JLabel labelDoCampo, JTextField componenteDoCampo, boolean isObrigatorio, ValidacaoTexto validacao) throws ValidacaoException {
		super(labelDoCampo, componenteDoCampo, isObrigatorio, validacao);
	}

	protected CampoDeTexto(JLabel labelDoCampo, JTextField componenteDoCampo, boolean isObrigatorio, ValidacaoNumerica validacao) throws ValidacaoException {
		super(labelDoCampo, componenteDoCampo, isObrigatorio, validacao);
	}


	@Override
	protected String leiaDadosDoComponente(JComponent componente) {
		JTextField componenteDeTexto = (JTextField) componente;

		String dadosTratados = Utils.obtenhaStringTratadaDeCampoDoFormulario(componenteDeTexto);

		return dadosTratados;
	}
}
