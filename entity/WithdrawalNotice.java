package com.enviro.assessment.grad001.siyathandazamqhamane.entity;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "WithdrawalNotice")
public class WithdrawalNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long withdrawalId;
    @Column(name="investor_id")
    private Long investorId;
    @Column(name="product_type")
    private String productType;
    @Column(name="withdrawalAmount")
    private BigDecimal withdrawalAmount;
    @Column(name="withdrawal_Date")
    private LocalDate withdrawalDate;

}
