package br.com.senaigo.locadora.model;

public enum SituacaoLocacao {
    
    ABERTO(1, "Aberto"),
    FECHADA(2, "Fechada"),
    CANCELADA(3, "Cancelada");
 
    private int valor;
    private String descricao;

    SituacaoLocacao(int valor, String descricao) {
       this.valor = valor;
       this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }    
}
