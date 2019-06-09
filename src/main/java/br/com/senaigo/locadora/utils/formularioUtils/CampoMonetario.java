package br.com.senaigo.locadora.utils.formularioUtils;

import br.com.senaigo.locadora.excecoes.ValidacaoException;
import br.com.senaigo.locadora.utils.Utils;

import javax.swing.*;

public class CampoMonetario extends CampoDeTexto {

	public CampoMonetario(JLabel labelDoCampo, JTextField componenteDoCampo, boolean isObrigatorio, ValidacaoNumerica validacao) throws ValidacaoException {
		super(labelDoCampo, componenteDoCampo, isObrigatorio, validacao);
	}

	@Override
	protected void facaValidacoesAdicionaisSeNecessario(String objetoEmTexto) throws ValidacaoException {
		float valor = Utils.convertaStringParaFloat(objetoEmTexto);

		if (valor <= 0) {
			throw new ValidacaoException("O valor informado não pode ser menor ou igual a 0.");
		}
	}
}
