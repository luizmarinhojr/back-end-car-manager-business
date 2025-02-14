package com.carmotorg.back_end_api.model;

public enum OrderStatusEnum {
    AGUARDANDO_ORCAMENTO,
    ORCAMENTO_FEITO,
    AGUARDANDO_APROVACAO_ORCAMENTO,
    AGUARDANDO_PAGAMENTO_PECA,
    AGUARDANDO_PAGAMENTO_SERVICO,
    AGUARDANDO_PECA,
    AGUARDANDO_AGENDAMENTO,
    AGENDADO,
    AGUARDANDO_CHEGADA,
    AGUARDANDO_VAGA,
    EM_EXECUCAO,
    NA_LANTERNAGEM,
    NA_PINTURA,
    NA_MECANICA,
    NA_ELETRICA,
    NA_MONTAGEM,
    EM_FINALIZACAO,
    PAUSADO,
    FINALIZADO,
    AGUARDANDO_RETIRADA,
    CONCLUIDO,
    CANCELADO;
}
