package br.com.senaigo.locadora.utils;

import br.com.senaigo.locadora.excecoes.ValidacaoException;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Utils {

	public static int convertaStringParaInt(String valor) {
		return Integer.parseInt(valor);
	}

	public static long convertaStringParaLong(String valor) {
		return Long.parseLong(valor);
	}

	public static float convertaStringParaFloat(String valor) {
		float valorConvertido;
		try {
			valorConvertido = Float.parseFloat(valor);
		} catch (NumberFormatException e) {
			throw new RuntimeException("O valor informado não é numérico.");
		}
		return valorConvertido;
	}

	public static String convertaFloatParaStringComDuasCasasDecimais(float valor) {
		DecimalFormat formatador = new DecimalFormat();
		formatador.setMaximumFractionDigits(2);
		formatador.setMinimumFractionDigits(2);
		formatador.setGroupingUsed(false);
		return formatador.format(valor).replace(",", ".");
	}

	public static List<String> obtenhaCampos(String dadosDoObjeto) {
		List<String> campos;
		campos = Arrays.asList(dadosDoObjeto.split(";", -1));
		return campos;
	}

	public static String obtenhaStringTratadaDeCampoDoFormulario(JTextField campoDoFormulario) {
		String campoNaoTratado;
		if(campoDoFormulario instanceof JFormattedTextField) {
			String valor = (String) ((JFormattedTextField) campoDoFormulario).getValue();
			campoNaoTratado = valor == null ? "" : valor.trim();
		} else {
			campoNaoTratado = campoDoFormulario.getText().trim();
		}
		return removaExcessoDeEspacosEmBrancoEntrePalavras(campoNaoTratado);
	}

	public static float obtenhaValorMonetarioDeCampoDoFormulario(JTextField campoDoFormulario) throws ValidacaoException {
		String campoNaoTratado = campoDoFormulario.getText().trim();
		String campoTratado = removaExcessoDeEspacosEmBrancoEntrePalavras(campoNaoTratado);
		try {
			 return campoTratado.isEmpty() ? 0 : convertaStringParaFloat(campoTratado);
		} catch (NumberFormatException erro) {
			throw new ValidacaoException("O valor informado não é numérico!");
		}
	}

	public static void mostreAdvertencia(Exception excecao, String titulo) {
		JOptionPane.showMessageDialog(null, excecao.getMessage(), titulo, JOptionPane.WARNING_MESSAGE);
	}

	public static void mostreAdvertenciaValidacao (Exception excecao) {
		String titulo = "Informações inválidas!";
		mostreAdvertencia(excecao, titulo);
	}

	public static void mostreAdvertenciaTelaEdicao(Exception excecao) {
		String titulo = "Erro ao preencher formulário para edição!";
		mostreAdvertencia(excecao, titulo);
	}
	public static void mostreAdvertenciaPreenchimentoGrid(Exception excecao) {
		String titulo = "Erro ao preencher grid!";
		mostreAdvertencia(excecao, titulo);
	}

	private static String removaExcessoDeEspacosEmBrancoEntrePalavras(String campo) {
		return campo.replaceAll("(?<=.)\\s{2,}", " ");
	}

}
