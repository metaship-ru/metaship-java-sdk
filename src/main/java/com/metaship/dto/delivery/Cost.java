package com.metaship.dto.delivery;

import java.math.BigDecimal;

public class Cost {
    private BigDecimal base;
    private BigDecimal service;
    private BigDecimal total;

    public BigDecimal getBase() {
        return base;
    }
    public void setBase(BigDecimal base) {
        this.base = base;
    }

    public BigDecimal getService() {
        return service;
    }
    public void setService(BigDecimal service) {
        this.service = service;
    }

    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "base=" + base +
                ", service=" + service +
                ", total=" + total +
                '}';
    }
}
