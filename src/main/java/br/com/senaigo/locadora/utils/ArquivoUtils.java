package br.com.senaigo.locadora.utils;

import java.io.File;
import java.io.IOException;

public class ArquivoUtils {

	public static void garantaExistenciaDeDiretorio(String caminhoParaDiretorio) {
		File file = new File(caminhoParaDiretorio);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
}
