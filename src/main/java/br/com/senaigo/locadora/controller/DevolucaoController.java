package br.com.senaigo.locadora.controller;

import br.com.senaigo.locadora.model.Locacao;
import br.com.senaigo.locadora.utils.Utils;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;


public class DevolucaoController {
    
    private Locacao locacao;
    
    public DevolucaoController(Locacao locacao) {
        this.locacao = locacao;
    }

    public String getMensagem() {
        StringBuilder msg = new StringBuilder();
        msg.append(obtenhaMsgCaucao()).append("\n");
        msg.append(obtenhaMsgLocacaoSemMulta()).append("\n");
        msg.append(obtenhaMsgValorDiaria()).append("\n");

        long diasAtraso = obtenhaDiasAtraso();
        if(diasAtraso > 0) {
            msg.append(obtenhaMsgDiasAtraso(diasAtraso)).append("\n");
            msg.append(obtenhaMsgTotalSeMulta(diasAtraso)).append("\n");
        }

        long diasAntecedencia = obtenhaDiasAntecedencia();
        if(diasAntecedencia > 0) {
            msg.append(obtenhaMsgDiasAntecedencia(diasAntecedencia)).append("\n");
            msg.append(obtenhaMsgTotalSeDesconto(diasAntecedencia)).append("\n");
        }

        float total = obtenhaValorASerPago();

        msg.append(obtenhaMsgTotalASerPago(total)).append("\n\n\n");


        String totalFormatado = Utils.convertaFloatParaStringComDuasCasasDecimais(total);
        msg.append("Deseja devolver a caução e efetuar o pagamento de R$" + totalFormatado + "?");
        return msg.toString();
    }

    private String obtenhaMsgCaucao() {
        String caucaoFormatada = Utils.convertaFloatParaStringComDuasCasasDecimais(locacao.getValorCaucao());
        return "Total pago como caução: R$" + caucaoFormatada;
    }

    private String obtenhaMsgLocacaoSemMulta() {
        float locacaoSemMulta = obtenhaLocacaoSemMulta();
        String valorFormatado = Utils.convertaFloatParaStringComDuasCasasDecimais(locacaoSemMulta);
        return "Total da locação: R$" + valorFormatado;
    }

    private String obtenhaMsgValorDiaria() {
        String valorFormatado = Utils.convertaFloatParaStringComDuasCasasDecimais(locacao.getVeiculo().getCategoria().getValorDiarioLocacao());
        return "Valor da diária : R$" + valorFormatado;
    }

    private String obtenhaMsgDiasAtraso(long diasAtraso) {
        return "Dias de atraso na devolução: " + diasAtraso;
    }

    private String obtenhaMsgTotalSeMulta(long diasAtraso) {
        float totalComMulta = obtenhaTotalComMulta(diasAtraso);
        String totalFormatado = Utils.convertaFloatParaStringComDuasCasasDecimais(totalComMulta);
        return "Valor total a ser pago com " + diasAtraso + " dias de atraso: R$" + totalFormatado;
    }

    private String obtenhaMsgDiasAntecedencia(long diasAntecedencia) {
        return "Dias de antecedência na devolução: " + diasAntecedencia;
    }

    private String obtenhaMsgTotalSeDesconto(long diasAntecedencia) {
        float totalComDesconto = obtenhaTotalComDesconto(diasAntecedencia);
        String totalFormatado = Utils.convertaFloatParaStringComDuasCasasDecimais(totalComDesconto);
        return "Valor total a ser pago com " + diasAntecedencia + "dias de antecedência: R$" + totalFormatado;
    }

    private String obtenhaMsgTotalASerPago(float total) {
        String totalFormatado = Utils.convertaFloatParaStringComDuasCasasDecimais(total);
        return "Total a ser pago: R$" + totalFormatado;
    }

    private float obtenhaLocacaoSemMulta() {
        return locacao.getValorCaucao() / 2;
    }

    private float obtenhaTotalComMulta(long diasAtraso) {
        float valorDiaria = locacao.getVeiculo().getCategoria().getValorDiarioLocacao();
        float diariaComMulta = valorDiaria * 1.1f;
        float totalDaMulta = diariaComMulta * diasAtraso;
        float totalComMulta = obtenhaLocacaoSemMulta() + totalDaMulta;
        return totalComMulta;
    }

    private float obtenhaTotalComDesconto(long diasAntecedencia) {
        float valorDiaria = locacao.getVeiculo().getCategoria().getValorDiarioLocacao();
        float valorDevolvido = valorDiaria * 0.9f;
        float totalDevolvido = valorDevolvido * diasAntecedencia;
        float totalComDesconto = obtenhaLocacaoSemMulta() - totalDevolvido;
        return totalComDesconto;
    }

    private long obtenhaDiasAtraso() {
        LocalDate dataPrevistaDevolucao = locacao.getDataPrevistaParaDevolucao();
        LocalDate dataDaDevolucao = locacao.getDataDaDevolucao();
        return DAYS.between(dataPrevistaDevolucao, dataDaDevolucao);
    }

    private long obtenhaDiasAntecedencia() {
        LocalDate dataPrevistaDevolucao = locacao.getDataPrevistaParaDevolucao();
        LocalDate dataDaDevolucao = locacao.getDataDaDevolucao();
        return DAYS.between(dataDaDevolucao, dataPrevistaDevolucao);
    }

    public float obtenhaValorASerPago() {
        float total;
        long diasAtraso = obtenhaDiasAtraso();
        long diasAntecedencia = obtenhaDiasAntecedencia();
        if(diasAtraso > 0) {
            total = obtenhaTotalComMulta(diasAtraso);
        } else if (diasAntecedencia > 0) {
            total = obtenhaTotalComDesconto(diasAntecedencia);
        } else {
            total = obtenhaLocacaoSemMulta();
        }
        return total;
    }
    
}
