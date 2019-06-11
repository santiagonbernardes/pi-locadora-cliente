package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;
import java.time.LocalDate;

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
    public void monteObjeto(String dadosDoObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String desmonteObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
