package br.com.senaigo.locadora.utils.formularioUtils;

import br.com.senaigo.locadora.excecoes.ValidacaoException;
import br.com.senaigo.locadora.utils.DataUtils;

import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;

public class CampoData extends CampoDeTexto {

	public CampoData(JLabel labelDoCampo, JFormattedTextField componente, boolean isObrigatorio) throws ValidacaoException {
		super(labelDoCampo, componente, isObrigatorio, ValidacaoTexto.DATA);
	}

	@Override
	protected void facaValidacoesAdicionaisSeNecessario(String objetoEmTexto) throws ValidacaoException {
		try{
			DataUtils.convertaStringParaLocalDate(objetoEmTexto);
		} catch (DateTimeException erro) {
			throw new ValidacaoException("A data informada é inválida!");
		}
	}
}
