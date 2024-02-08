package com.enviro.assessment.grad001.siyathandazamqhamane.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class InvestorProduct {
    private Long product_id;
    private String product_type;
    private BigDecimal balance;
    private String name;
}
