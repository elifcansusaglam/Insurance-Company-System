package com.elifcansusaglam.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@AllArgsConstructor
@Data
public class CompareAgencyDto {
    private String insuranceAgency;
    private BigInteger profit;
    private BigInteger loss;
}
