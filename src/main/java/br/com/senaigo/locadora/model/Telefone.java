package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.utils.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Telefone {

	//Atributos
	private int ddd;
	private int numero;

	//Construtores
	public Telefone() {
		super();
		this.ddd = 0;
		this.numero = 0;
	}

	//Getters e Setters
	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	//Métodos Próprios
	public static Telefone obtenhaInstancia(String telefoneFormatado) {
		//Regex para pegar só o ddd: (?<=\()\d{2}(?=\))
		Pattern padraoDdd = Pattern.compile("(?<=\\()\\d{2}(?=\\))");
		Matcher matcherDDD = padraoDdd.matcher(telefoneFormatado);
		int ddd = 0;

		if (matcherDDD.find()) {
			ddd = Utils.convertaStringParaInt(matcherDDD.group());
		}


		Pattern padraoNumero = Pattern.compile("(?<=\\))\\d{4,5}\\-\\d{4}");
		Matcher matcherNumero = padraoNumero.matcher(telefoneFormatado);
		int numero = 0;
		if (matcherNumero.find()) {
			numero = Utils.convertaStringParaInt(matcherNumero.group().replace("-", ""));
		}


		Telefone telefoneRetorno = new Telefone();
		telefoneRetorno.setDdd(ddd);
		telefoneRetorno.setNumero(numero);
		return telefoneRetorno;
	}

	@Override
	public String toString() {
		String numeroSemFormatacao = String.valueOf(numero);
		int tamanho = numeroSemFormatacao.length();
		String retorno;

		if(tamanho < 8 || tamanho > 9) {
			retorno = "";
		} else {
			String digitosAntesHifen = tamanho == 8 ? numeroSemFormatacao.substring(0, 4) : numeroSemFormatacao.substring(0, 5);
			String digitosAposHifen = tamanho == 8 ? numeroSemFormatacao.substring(4) : numeroSemFormatacao.substring(5);
			String numeroFormatado = digitosAntesHifen + "-" + digitosAposHifen;
			retorno = "(" + this.ddd + ")" + numeroFormatado;
		}

		return retorno;
	}
}
