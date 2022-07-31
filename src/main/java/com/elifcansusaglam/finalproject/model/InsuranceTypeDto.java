package com.elifcansusaglam.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@AllArgsConstructor
@Data
public class InsuranceTypeDto {

    private String insuranceName;
    private BigInteger profit;
    private BigInteger loss;

}
