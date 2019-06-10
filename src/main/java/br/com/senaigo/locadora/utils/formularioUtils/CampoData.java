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
			LocalDate data = DataUtils.convertaStringParaLocalDate(objetoEmTexto);
			if(data.getYear() < 1900) {
				throw new ValidacaoException("O ano não pode ser menor que 1900!");
			}
		} catch (DateTimeException erro) {
			throw new ValidacaoException("A data informada é inválida!");
		}
	}
}
