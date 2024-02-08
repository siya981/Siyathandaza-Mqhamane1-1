package com.enviro.assessment.grad001.siyathandazamqhamane.entity;

import javax.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "InvestorProduct")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name = "investor_id")
    private long investorId;

    @Column(name="product_type")
    private String productType;

    @Column(name="name")
    private String name;

    @Column(name="balance")
    private BigDecimal balance;

}
