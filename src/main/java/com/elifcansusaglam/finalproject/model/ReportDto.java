package com.elifcansusaglam.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@AllArgsConstructor
@Data
public class ReportDto {

    private Date startDate;
    private Date endDate;
    private int profit;
    private int loss;
    private String insuranceAgency;
    private String insuranceName;
    private int id;

}
