package br.com.senaigo.locadora.utils.formularioUtils;

import br.com.senaigo.locadora.excecoes.ValidacaoException;
import br.com.senaigo.locadora.utils.Utils;

import javax.swing.*;

public class CampoId extends CampoDeFormulario<Integer> {

	public CampoId(JLabel labelDoCampo, JTextField componenteDoCampo) throws ValidacaoException {
		super(labelDoCampo, componenteDoCampo, false, ValidacaoTexto.SEM_VALIDACAO_COM_REGEX);
	}

	@Override
	protected Integer leiaDadosDoComponente(JComponent componente) {
		JTextField componenteTexto = (JTextField) componente;
		String dadosEmTexto = Utils.obtenhaStringTratadaDeCampoDoFormulario(componenteTexto);
		return dadosEmTexto.isEmpty() ? 0 : Utils.convertaStringParaInt(dadosEmTexto);
	}
}
