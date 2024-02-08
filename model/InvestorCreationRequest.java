package com.enviro.assessment.grad001.siyathandazamqhamane.model;


import com.enviro.assessment.grad001.siyathandazamqhamane.util.GenderType;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;

@Data
@Builder
public class InvestorCreationRequest {
    @NotNull
    @Builder.Default
    private OffsetDateTime requestDateTime = OffsetDateTime.now();

    @NotBlank(message = "Invalid  correlationId: Empty correlationId")
    private String correlationId;

    @NotBlank
    @Size(min=2, max=40, message = "Invalid first Name: Must be of 2 - 30 characters")
    private String firstName;

    @NotBlank
    @Size(min=2, max=40, message = "Invalid last Name: Must be of 2 - 30 characters")
    private String lastName;

    @NotNull
    private GenderType gender;

    @NotNull
    @Min(value = 1, message = "Invalid Age: Equals to zero or Less than zero")
    @Max(value = 110, message = "Invalid Age: Exceeds 110 years")
    private int age;

    @NotBlank
    @Size(min=2, max=40, message = "Invalid street: Must be of 2 - 40 characters")
    private String street;

    @NotBlank
    @Size(min=2, max=40, message = "Invalid suburb: Must be of 2 - 40 characters")
    private String suburb;

    @NotBlank
    @Size(min=2, max=40, message = "Invalid city: Must be of 2 - 40 characters")
    private String city;
    @NotNull
    @Pattern(regexp = "\\d{4}", message = "Invalid postal code. It should be a 4-digit number.")
    private String postalCode;


    @NotBlank(message = "Invalid Phone number: Empty PhoneNumber")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    private String PhoneNumber;
    @Email(message = "Invalid email")
    private String emailAddress;
    private int faxNumber;

}
