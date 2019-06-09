package br.com.senaigo.locadora.utils.formularioUtils;

import br.com.senaigo.locadora.excecoes.ValidacaoException;
import br.com.senaigo.locadora.utils.ArquivoUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CampoComImagem extends CampoDeFormulario<BufferedImage> {

	private String caminhoParaArquivo;

	public CampoComImagem(JLabel labelComImagem, String nomePastaArquivo) throws ValidacaoException {
		super(labelComImagem, labelComImagem);
		this.caminhoParaArquivo = crieCaminhoParaArquivo(nomePastaArquivo);
	}

	public String obtenhaCaminhoParaArquivo() {
		return this.caminhoParaArquivo;
	}

	@Override
	protected BufferedImage leiaDadosDoComponente(JComponent componente){
		JLabel componenteLabel = (JLabel) componente;
		ImageIcon icon = (ImageIcon) componenteLabel.getIcon();
		return icon == null ? null : extraiaImagemDoComponente(icon);
	}

	private String crieCaminhoParaArquivo(String nomePastaArquivo) {
		String caminhoDiretorio = "Repositório/" + nomePastaArquivo + "/";
		ArquivoUtils.garantaExistenciaDeDiretorio(caminhoDiretorio);
		String nomeArquivo = ArquivoUtils.obtenhaNomeAleatorioParaArquivo(10);
		return caminhoDiretorio + nomeArquivo + ".png";
	}

	private BufferedImage extraiaImagemDoComponente(ImageIcon icon) {
		Image imagemSemTratamento = icon.getImage();
		return (BufferedImage) imagemSemTratamento;
	}

	public void salveArquivo() throws IOException {

		File arquivoImagem = new File(caminhoParaArquivo);
		ImageIO.write(dadosDoCampo, "png", arquivoImagem);
	}


}
