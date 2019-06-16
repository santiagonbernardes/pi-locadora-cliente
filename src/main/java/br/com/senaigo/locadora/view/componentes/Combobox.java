package br.com.senaigo.locadora.view.componentes;

import br.com.senaigo.locadora.excecoes.ValidacaoException;
import br.com.senaigo.locadora.utils.formularioUtils.ValidacaoTexto;

import javax.swing.*;

public class Combobox<T> {

	private JComboBox<T> componente;
	private JLabel label;
	private boolean obrigatorio;
	private boolean unico;
	private ValidacaoTexto validacao;

	public Combobox(JComboBox<T> componente, JLabel label, boolean obrigatorio, boolean unico, ValidacaoTexto validacao) {
		this.componente = componente;
		this.label = label;
		this.obrigatorio = obrigatorio;
		this.unico = unico;
		this.validacao = validacao;
	}

	public boolean isObrigatorio() {
		return obrigatorio;
	}

	public boolean isUnico() {
		return unico;
	}

	public ValidacaoTexto getValidacao() {
		return validacao;
	}

	public T obtenhaDados() {
		int index = componente.getSelectedIndex();
		return componente.getItemAt(index);
	}

	public boolean valideObrigatorio() {
		T objeto = obtenhaDados();
		return objeto != null;
	}

	public String obtenhaMsgObrigatorio() {
		String nomeCombo = label.getText().trim().replace(":", "");
		return "O campo " + nomeCombo + "é obrigatório!";
	}

	public String obtenhaMsgUnico() {
		String nomeCombo = label.getText().trim().replace(":", "");
		return "O campo " + nomeCombo + "é único!";
	}
}
