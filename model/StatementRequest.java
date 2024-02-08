package com.enviro.assessment.grad001.siyathandazamqhamane.model;

import com.enviro.assessment.grad001.siyathandazamqhamane.util.ProductType;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.*;

import java.time.OffsetDateTime;
@Builder
@Data
public class StatementRequest {

    @NotNull
    @Builder.Default
    private OffsetDateTime requestDateTime = OffsetDateTime.now();
    @NotNull
    private String correlationId;
    @NotNull
    private Long investorId;
    @NotNull
    private ProductType product_type;
}
