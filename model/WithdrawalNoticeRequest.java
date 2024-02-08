package com.enviro.assessment.grad001.siyathandazamqhamane.model;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.enviro.assessment.grad001.siyathandazamqhamane.util.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Data
@Builder
@AllArgsConstructor
public class WithdrawalNoticeRequest {


    @NotBlank(message = "Invalid  correlationId: Empty correlationId")
    private String correlationId;
    @NotNull
    private Long investorId;
    @NotNull
    private ProductType product_type;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal withDrawalAmount;

}
