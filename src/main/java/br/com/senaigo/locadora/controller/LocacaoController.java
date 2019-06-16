package br.com.senaigo.locadora.controller;

import br.com.senaigo.locadora.excecoes.ValidacaoException;
import br.com.senaigo.locadora.model.*;
import br.com.senaigo.locadora.persistencia.Operacao;
import br.com.senaigo.locadora.utils.DataUtils;
import br.com.senaigo.locadora.utils.Utils;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class LocacaoController {

    private Locacao locacao;
    private ClienteTcpController controllerCliente;

    public LocacaoController(Locacao locacao, ClienteTcpController controllerCliente) throws ValidacaoException {
        this.locacao = locacao;
        this.locacao.setValorCaucao(calculeCaucao());
        this.controllerCliente = controllerCliente;
    }

    private float calculeCaucao() throws ValidacaoException {
        return obtenhaValorTotalLocacao() * 2;
    }

    public void execute(Locacao locacao, Operacao operacao) throws Exception {
        LocalDate dataVencimentoCnh = locacao.getDataVencimentoCnh();
        LocalDate dataPrevistaDev = locacao.getDataPrevistaParaDevolucao();
        Estado estadoVeiculo = locacao.getVeiculo().getEstado();
        Motorista motorista = locacao.getMotorista();

        if(isCnhVencida(dataVencimentoCnh)) {
            throw new ValidacaoException("A CNH está vencida!");
        }

        if(isCnhVencidaNaDevolucao(dataVencimentoCnh, dataPrevistaDev)) {
            throw new ValidacaoException("A CNH vencerá antes da devolução do veículo!");
        }

        if(estadoVeiculo != Estado.LIVRE) {
            throw new ValidacaoException("O veiculo não pode ser locado pois está " + estadoVeiculo.getDescricao() + "!");
        }

        if(motorista.getId() == 0) {
            String id = controllerCliente.execute(motorista, Operacao.INCLUIR);
            motorista.setId(Utils.convertaStringParaInt(id));
        }

        locacao.setSituacao(SituacaoLocacao.ABERTO);
        locacao.getVeiculo().setEstado(Estado.LOCADO);
        controllerCliente.execute(locacao, operacao);
    }

    private boolean isCnhVencida(LocalDate dataVencimentoCnh) {
        LocalDate dataHoje = LocalDate.now();
        return dataHoje.isAfter(dataVencimentoCnh);
    }

    private boolean isCnhVencidaNaDevolucao(LocalDate dataVencimentoCnh, LocalDate dataPrevistaDevolucao) {
        return dataPrevistaDevolucao.isAfter(dataVencimentoCnh);
    }

    
    public String obtenhaRelatorioPgtoLocacao() throws ValidacaoException {
        StringBuilder relatorio = new StringBuilder();
        
        relatorio.append("Relatório da locação\n");
        relatorio.append("Data de início: ").append(DataUtils.convertaLocalDateParaStringFormatada(locacao.getDataDaLocacao())).append("\n");
        relatorio.append("Data prevista para devolução: ").append(DataUtils.convertaLocalDateParaStringFormatada(locacao.getDataPrevistaParaDevolucao())).append("\n");
        relatorio.append("Quantidade de diárias: ").append(obtenhaQtdDias()).append("\n");
        String valorDiaria = Utils.convertaFloatParaStringComDuasCasasDecimais(locacao.getVeiculo().getCategoria().getValorDiarioLocacao());
        relatorio.append("Valor da diária: R$").append(valorDiaria).append("\n");
        String valorLocacao = Utils.convertaFloatParaStringComDuasCasasDecimais(obtenhaValorTotalLocacao());
        relatorio.append("Valor total da locação: R$").append(valorLocacao).append("\n");
        String valorCaucao = Utils.convertaFloatParaStringComDuasCasasDecimais(locacao.getValorCaucao());
        relatorio.append("Valor da caução: R$").append(valorCaucao).append("\n\n\n");
        
        relatorio.append("Deseja efetuar o pagamento de R$").append(valorCaucao).append(" agora?");
        return relatorio.toString();        
    }
    
    private long obtenhaQtdDias() {
        LocalDate dataLocacao = locacao.getDataDaLocacao();
        LocalDate dataPrevistaDev = locacao.getDataPrevistaParaDevolucao();

        return DAYS.between(dataLocacao, dataPrevistaDev);
    }
    
    private float obtenhaValorTotalLocacao() throws ValidacaoException {
        long duracaoLocacao = obtenhaQtdDias();
        if(duracaoLocacao <= 0) {
            throw new ValidacaoException("Duração da locação é inválida.");
        }
        return locacao.getVeiculo().getCategoria().getValorDiarioLocacao() * duracaoLocacao;
    }
}
