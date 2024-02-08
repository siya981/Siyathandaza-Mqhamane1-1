package com.enviro.assessment.grad001.siyathandazamqhamane.model;

import com.enviro.assessment.grad001.siyathandazamqhamane.util.ProductType;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Data
@Builder
@AllArgsConstructor
public class ProductCreationRequest {

    @NotNull
    @Builder.Default
    private OffsetDateTime requestDateTime = OffsetDateTime.now();
    @NotBlank(message = "Invalid  correlationId: Empty correlationId")
    private String correlationId;

    @NotNull
    private Long investorId;
    @NotNull
    private ProductType product_type;
    @NotNull
    @Size(min=2, max=40, message = "Invalid name: Must be of 2 - 40 characters")
    private String name;
    @NotNull
    @DecimalMin("0.00")
    private BigDecimal amount;
}
