package com.enviro.assessment.grad001.siyathandazamqhamane.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvestorResponse {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String street;
    private String suburb;
    private String city;
    private int postal_code;
    private String cellphone_number;
    private String email_address;
    private int fax_number;
    private List<InvestorProduct> productlist;
}
