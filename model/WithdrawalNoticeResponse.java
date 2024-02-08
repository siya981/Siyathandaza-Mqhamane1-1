package com.enviro.assessment.grad001.siyathandazamqhamane.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawalNoticeResponse {
    private String correlationId;
    private String message;
    private Long withdrawalId;
    private Long investorId;
    private String productType;
    private BigDecimal withdrawalAmount;
    private LocalDate withdrawalDate;


    public static WithdrawalNoticeResponse createWithdrawalNoticeResponse(String correlationId, String message,Long withdrawalId){
        return WithdrawalNoticeResponse.builder()
                .correlationId(correlationId)
                .message(message)
                .withdrawalId(withdrawalId)
                .build();
    }
}
