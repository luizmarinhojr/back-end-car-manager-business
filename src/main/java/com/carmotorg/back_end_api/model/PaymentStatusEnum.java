package com.carmotorg.back_end_api.model;

public enum PaymentStatusEnum {
    AGUARDANDO_PAGAMENTO ("Aguardando pagamento"),
    AGUARDANDO_PARTE_PAGAMENTO ("Aguardando parte do pagamento"),
    AGUARDANDO_PIX ("Aguardando PIX"),
    AGUARDANDO_CARTAO ("Aguardando cartão"),
    AGUARDANDO_TRANSFERENCIA ("Aguardando transferência"),
    PAGO_NO_PIX ("Pago no PIX"),
    PAGO_NO_CARTAO ("Pago no cartão"),
    PAGO_CRIPTOMOEDA ("Pago com criptomoeda"),
    PAGO ("Pago"),
    PAGO_PARCIALMENTE ("Pago parcialmente"),
    NAO_PAGO ("Não pago");

    private final String name;

    PaymentStatusEnum(String name) {
        this.name = name;
    }
}
