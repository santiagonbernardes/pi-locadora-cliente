package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.utils.DataUtils;
import br.com.senaigo.locadora.utils.Utils;

import java.time.LocalDate;
import java.util.List;

import static br.com.senaigo.locadora.utils.Utils.convertaStringParaInt;
import static br.com.senaigo.locadora.utils.Utils.obtenhaCampos;

public class Locacao implements PersisteDados {

	private int id;
	private Cliente cliente;
	private Veiculo veiculo;
	private Motorista motorista;
	private LocalDate dataDaLocacao;
	private LocalDate dataPrevistaParaDevolucao;
	private LocalDate dataDaDevolucao;
	private int kmVeiculoLocacao;
	private int kmVeiculoDevolucao;
	private LocalDate dataVencimentoCnh;
	private String caminhoParaArquivoCnh;
	private SituacaoLocacao situacao;
	private float valorCaucao;
	private float valorFinalLocacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public LocalDate getDataDaLocacao() {
        return dataDaLocacao;
    }

    public void setDataDaLocacao(LocalDate dataDaLocacao) {
        this.dataDaLocacao = dataDaLocacao;
    }

    public LocalDate getDataPrevistaParaDevolucao() {
        return dataPrevistaParaDevolucao;
    }

    public void setDataPrevistaParaDevolucao(LocalDate dataPrevistaParaDevolucao) {
        this.dataPrevistaParaDevolucao = dataPrevistaParaDevolucao;
    }

    public LocalDate getDataDaDevolucao() {
        return dataDaDevolucao;
    }

    public void setDataDaDevolucao(LocalDate dataDaDevolucao) {
        this.dataDaDevolucao = dataDaDevolucao;
    }

    public int getKmVeiculoLocacao() {
        return kmVeiculoLocacao;
    }

    public void setKmVeiculoLocacao(int kmVeiculoLocacao) {
        this.kmVeiculoLocacao = kmVeiculoLocacao;
    }

    public int getKmVeiculoDevolucao() {
        return kmVeiculoDevolucao;
    }

    public void setKmVeiculoDevolucao(int kmVeiculoDevolucao) {
        this.kmVeiculoDevolucao = kmVeiculoDevolucao;
    }

    public LocalDate getDataVencimentoCnh() {
        return dataVencimentoCnh;
    }

    public void setDataVencimentoCnh(LocalDate dataVencimentoCnh) {
        this.dataVencimentoCnh = dataVencimentoCnh;
    }

    public String getCaminhoParaArquivoCnh() {
        return caminhoParaArquivoCnh;
    }

    public void setCaminhoParaArquivoCnh(String caminhoParaArquivoCnh) {
        this.caminhoParaArquivoCnh = caminhoParaArquivoCnh;
    }

    public SituacaoLocacao getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoLocacao situacao) {
        this.situacao = situacao;
    }

    public float getValorCaucao() {
        return valorCaucao;
    }

    public void setValorCaucao(float valorCaucao) {
        this.valorCaucao = valorCaucao;
    }

    public float getValorFinalLocacao() {
        return valorFinalLocacao;
    }

    public void setValorFinalLocacao(float valorFinalLocacao) {
        this.valorFinalLocacao = valorFinalLocacao;
    }



    @Override
    public String desmonteObjeto() {
        StringBuilder dadosDoObjeto = new StringBuilder();

        String nomeDaClasse = this.getClass().getSimpleName();

        dadosDoObjeto.append(nomeDaClasse).append(";");
        dadosDoObjeto.append(this.id).append(";");
        dadosDoObjeto.append(this.cliente.getClass().getSimpleName()).append("#");
        dadosDoObjeto.append(this.cliente.getId()).append(";");
        dadosDoObjeto.append(this.veiculo.getClass().getSimpleName()).append("#");
        dadosDoObjeto.append(this.veiculo.getId()).append(";");
        dadosDoObjeto.append(this.motorista.getClass().getSimpleName()).append("#");
        dadosDoObjeto.append(this.motorista.getId()).append(";");
        String dataLocacaoFormatada = DataUtils.convertaLocalDateParaStringFormatada(this.dataDaLocacao);
        String dataPrevistaDevFormatada = DataUtils.convertaLocalDateParaStringFormatada(this.dataPrevistaParaDevolucao);
        String dataDevFormatada = DataUtils.convertaLocalDateParaStringFormatada(this.dataDaDevolucao);
        dadosDoObjeto.append(dataLocacaoFormatada).append(";");
        dadosDoObjeto.append(dataPrevistaDevFormatada).append(";");
        dadosDoObjeto.append(dataDevFormatada).append(";");
        dadosDoObjeto.append(kmVeiculoLocacao).append(";");
        dadosDoObjeto.append(kmVeiculoDevolucao).append(";");
        String dataVencimentoCnhFormatada = DataUtils.convertaLocalDateParaStringFormatada(this.dataVencimentoCnh);
        dadosDoObjeto.append(dataVencimentoCnhFormatada).append(";");
        dadosDoObjeto.append(this.caminhoParaArquivoCnh).append(";");
        dadosDoObjeto.append(this.situacao.getValor()).append(";");
        String valorCaucaoFormatado = Utils.convertaFloatParaStringComDuasCasasDecimais(this.valorCaucao);
        String valorFinalLocacaoFormatado = Utils.convertaFloatParaStringComDuasCasasDecimais(this.valorFinalLocacao);
        dadosDoObjeto.append(valorCaucaoFormatado).append(";");
        dadosDoObjeto.append(valorFinalLocacaoFormatado);

        return dadosDoObjeto.toString();
    }

    @Override
    public void monteObjeto(String dadosDoObjeto) {
        List<String> campos = obtenhaCampos(dadosDoObjeto);

        this.id = convertaStringParaInt(campos.get(0));

        String dadosCliente = obtenhaDadosCliente(campos);
        Cliente cliente = new Cliente();
        cliente.monteObjeto(dadosCliente);
        this.cliente = cliente;

        String dadosVeiculo = obtenhaDadosVeiculo(campos);
        Veiculo veiculo = new Veiculo();
        veiculo.monteObjeto(dadosVeiculo);
        this.veiculo = veiculo;

        String dadosMotorista = obtenhaDadosMotorista(campos);
        Motorista motorista = new Motorista();
        motorista.monteObjeto(dadosMotorista);
        this.motorista = motorista;

        this.dataDaLocacao = DataUtils.convertaStringParaLocalDate(campos.get(48));
        this.dataPrevistaParaDevolucao = DataUtils.convertaStringParaLocalDate(campos.get(49));
        this.dataDaDevolucao = DataUtils.convertaStringParaLocalDate(campos.get(50));
        this.kmVeiculoLocacao = Utils.convertaStringParaInt(campos.get(51));
        this.kmVeiculoDevolucao = Utils.convertaStringParaInt(campos.get(52));
        this.dataVencimentoCnh = DataUtils.convertaStringParaLocalDate(campos.get(53));
        this.caminhoParaArquivoCnh = campos.get(54);
        int valorSituacao = Utils.convertaStringParaInt(campos.get(55));
        this.situacao = SituacaoLocacao.valueOf(valorSituacao);
        this.valorCaucao = Utils.convertaStringParaFloat(campos.get(56));
        this.valorFinalLocacao = Utils.convertaStringParaFloat(campos.get(57));
    }

    private String obtenhaDadosCliente(List<String> campos) {
        StringBuilder dadosCliente = new StringBuilder();
        dadosCliente.append(campos.get(1)).append(";");
        dadosCliente.append(campos.get(2)).append(";");
        dadosCliente.append(campos.get(3)).append(";");
        dadosCliente.append(campos.get(4)).append(";");
        dadosCliente.append(campos.get(5)).append(";");
        dadosCliente.append(campos.get(6)).append(";");
        dadosCliente.append(campos.get(7)).append(";");
        dadosCliente.append(campos.get(8)).append(";");
        dadosCliente.append(campos.get(9)).append(";");
        dadosCliente.append(campos.get(10)).append(";");
        dadosCliente.append(campos.get(11)).append(";");
        dadosCliente.append(campos.get(12)).append(";");
        dadosCliente.append(campos.get(13)).append(";");
        dadosCliente.append(campos.get(14)).append(";");
        dadosCliente.append(campos.get(15)).append(";");
        dadosCliente.append(campos.get(16)).append(";");
        dadosCliente.append(campos.get(17));
        return dadosCliente.toString();
    }

    private String obtenhaDadosVeiculo(List<String> campos) {
        StringBuilder dadosVeiculo = new StringBuilder();
        dadosVeiculo.append(campos.get(18)).append(";");
        dadosVeiculo.append(campos.get(19)).append(";");
        dadosVeiculo.append(campos.get(20)).append(";");
        dadosVeiculo.append(campos.get(21)).append(";");
        dadosVeiculo.append(campos.get(22)).append(";");
        dadosVeiculo.append(campos.get(23)).append(";");
        dadosVeiculo.append(campos.get(24)).append(";");
        dadosVeiculo.append(campos.get(25)).append(";");
        dadosVeiculo.append(campos.get(26)).append(";");
        dadosVeiculo.append(campos.get(27)).append(";");
        dadosVeiculo.append(campos.get(28)).append(";");
        dadosVeiculo.append(campos.get(29)).append(";");
        dadosVeiculo.append(campos.get(30)).append(";");
        dadosVeiculo.append(campos.get(31)).append(";");
        dadosVeiculo.append(campos.get(32));
        return dadosVeiculo.toString();
    }

    private String obtenhaDadosMotorista(List<String> campos) {
        StringBuilder dadosMotorista = new StringBuilder();
        dadosMotorista.append(campos.get(33)).append(";");
        dadosMotorista.append(campos.get(34)).append(";");
        dadosMotorista.append(campos.get(35)).append(";");
        dadosMotorista.append(campos.get(36)).append(";");
        dadosMotorista.append(campos.get(37)).append(";");
        dadosMotorista.append(campos.get(38)).append(";");
        dadosMotorista.append(campos.get(39)).append(";");
        dadosMotorista.append(campos.get(40)).append(";");
        dadosMotorista.append(campos.get(41)).append(";");
        dadosMotorista.append(campos.get(42)).append(";");
        dadosMotorista.append(campos.get(43)).append(";");
        dadosMotorista.append(campos.get(44)).append(";");
        dadosMotorista.append(campos.get(45)).append(";");
        dadosMotorista.append(campos.get(46)).append(";");
        dadosMotorista.append(campos.get(47));
        return dadosMotorista.toString();
    }
}
