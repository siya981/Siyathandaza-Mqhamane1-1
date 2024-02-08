package com.enviro.assessment.grad001.siyathandazamqhamane.entity;


import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "investor")
public class Investor {
    @Id
    @Column(name="investor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long investorId;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="genderType")
    private String gender;
    @Column(name="age")
    private int age;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="email_address")
    private String emailAddress;
    @Column(name="fax_number")
    private int faxNumber;
    @Column(name="street")
    private String street;
    @Column(name="suburb")
    private String suburb;
    @Column(name="city")
    private String city;
    @Column(name="postal_code")
    private int postal_code;




}
