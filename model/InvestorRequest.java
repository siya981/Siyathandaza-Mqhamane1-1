package com.enviro.assessment.grad001.siyathandazamqhamane.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.*;

import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
public class InvestorRequest {
    @NotNull
    @Builder.Default
    private OffsetDateTime requestDateTime = OffsetDateTime.now();
    @NotBlank(message = "Invalid  correlationId: Empty correlationId")
    private String correlationId;
    @NotNull
    private Long investorId;



}
