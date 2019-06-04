package br.com.senaigo.locadora.comunicacao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienteTcp {

	private Socket socket;
	private static ClienteTcp instancia;


	private ClienteTcp() throws IOException {
		socket = new Socket("127.0.0.1", 7777);
	}

	public static ClienteTcp obtenhaInstancia() throws IOException {
		if (instancia == null) {
			instancia = new ClienteTcp();
		}
		return instancia;
	}

	public void enviarMensagem(String mensagem) throws IOException {
		System.out.println("Enviando mensagem: " + mensagem);
		DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
		saida.writeUTF(mensagem);
		saida.flush();
		System.out.println("Mensagem enviada.");
	}

	public String receberResposta() throws IOException {
		System.out.println("Aguardando resposta.");
		DataInputStream entrada = new DataInputStream(socket.getInputStream());
		String resposta = entrada.readUTF();
		System.out.println("Resposta recebida: " + resposta);
		return resposta;
	}
}
