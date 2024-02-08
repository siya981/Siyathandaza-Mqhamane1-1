package com.enviro.assessment.grad001.siyathandazamqhamane.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvestorCreationResponse {
    private String correlationId;
    private String message;

    private Long investorId;
    public static InvestorCreationResponse createInvestorCreationResponse(String correlationId, String message, Long investorId){
        return InvestorCreationResponse.builder()
                .correlationId(correlationId)
                .message(message)
                .investorId(investorId)
                .build();
    }
}
