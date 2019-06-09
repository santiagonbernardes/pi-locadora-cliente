package br.com.senaigo.locadora.utils.formularioUtils;

import br.com.senaigo.locadora.excecoes.ValidacaoException;
import br.com.senaigo.locadora.utils.Utils;

import javax.swing.*;

public class CampoDeTexto extends CampoDeFormulario <String> {

	public CampoDeTexto(JLabel labelDoCampo, JTextField componenteDoCampo, boolean isObrigatorio, ValidacaoTexto validacao) throws ValidacaoException {
		super(labelDoCampo, componenteDoCampo, isObrigatorio, validacao);
	}

	public CampoDeTexto(JLabel labelDoCampo, JFormattedTextField componenteDoCampo, boolean isObrigatorio) throws ValidacaoException {
		super(labelDoCampo, componenteDoCampo, isObrigatorio, ValidacaoTexto.SEM_VALIDACAO_COM_REGEX);
	}

	protected CampoDeTexto(JLabel labelDoCampo, JTextField componenteDoCampo, boolean isObrigatorio, ValidacaoFloat validacao) throws ValidacaoException {
		super(labelDoCampo, componenteDoCampo, isObrigatorio, validacao);
	}


	@Override
	protected String leiaDadosDoComponente(JComponent componente) {
		JTextField componenteDeTexto = (JTextField) componente;

		String dadosTratados = Utils.obtenhaStringTratadaDeCampoDoFormulario(componenteDeTexto);

		return dadosTratados;
	}
}
