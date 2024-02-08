package com.enviro.assessment.grad001.siyathandazamqhamane.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreationResponse {
    private String correlationId;
    private String message;
    private Long productId;
    public static ProductCreationResponse createProductCreationResponse(String correlationId, String message, Long productId){
        return ProductCreationResponse.builder()
                .correlationId(correlationId)
                .message(message)
                .productId(productId)
                .build();
    }

}
