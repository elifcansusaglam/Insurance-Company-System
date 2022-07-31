package com.elifcansusaglam.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@AllArgsConstructor
@Data
public class CompareInsuranceDto {
    private String insuranceAgency;
    private String insuranceName;
    private BigInteger profit;
    private BigInteger loss;
}
