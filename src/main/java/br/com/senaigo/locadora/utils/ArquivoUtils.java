package br.com.senaigo.locadora.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;

public class ArquivoUtils {

	public static void garantaExistenciaDeDiretorio(String caminhoParaDiretorio) {
		File file = new File(caminhoParaDiretorio);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	public static String obtenhaNomeAleatorioParaArquivo(int tamanho) {
		final String caracteresValidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder nomeAleatorio = new StringBuilder();
		for(int i = 0; i < tamanho; i++) {
			int posicaoDoCaracter = (int)(Math.random() * caracteresValidos.length());
			nomeAleatorio.append(caracteresValidos.charAt(posicaoDoCaracter));
		}
		return nomeAleatorio.toString();
	}
}
