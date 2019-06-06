package br.com.senaigo.locadora.utils;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
		return Float.parseFloat(valor);
	}

	public static String convertaFloatParaStringComDuasCasasDecimais(float valor) {
		DecimalFormat formatador = new DecimalFormat();
		formatador.setMaximumFractionDigits(2);
		formatador.setMinimumFractionDigits(2);
		return formatador.format(valor).replace(",", ".");
	}

	public static List<String> obtenhaCampos(String dadosDoObjeto) {
		List<String> campos;
		campos = Arrays.asList(dadosDoObjeto.split(";"));
		return campos;
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

}
