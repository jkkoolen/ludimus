package eu.ludimus.web.ticket;


import java.math.BigDecimal;

public enum VAT {
    VAT_21(21),
    VAT_6(6),
    VAT_0(0);

    private BigDecimal value;
    private VAT(int value) {
        this.value = new BigDecimal(value);
    }

    public BigDecimal getValue() {
        return value;
    }
}
