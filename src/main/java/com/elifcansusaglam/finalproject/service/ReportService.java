package com.elifcansusaglam.finalproject.service;

import com.elifcansusaglam.finalproject.model.*;

import java.util.List;

public interface ReportService {

    List<Report> getAllReports();
    List<ReportDto> findAllReport();

    List<CompareInsuranceDto> findAllInsuranceCompareData();
    List<CompareAgencyDto> findAllAgencyCompareData();

    List<InsuranceTypeDto> findAllInsuranceTypeData();


}