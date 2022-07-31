package com.elifcansusaglam.finalproject.service;

import com.elifcansusaglam.finalproject.model.*;
import com.elifcansusaglam.finalproject.repository.ReportRepository;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceIml implements ReportService{

    ReportRepository reportRepository;

    @Autowired
    public ReportServiceIml(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }
    @Override
    public List<Report> getAllReports() {
        List<Report> reportList = reportRepository.findAll();
        return reportList;
    }

    @Override
    public List<ReportDto> findAllReport() {
        List<Map<String, Object>> map = reportRepository.findAllReport();
        List<ReportDto> reportDto = new ArrayList<ReportDto>();

        for (Map<String, Object> m : map) {
            ReportDto reportDto1 = new ReportDto(
                    (Date) m.get("start_date"),
                    (Date) m.get("end_date"),
                    (Integer) m.get("profit"),
                    (Integer) m.get("loss"),
                    (String) m.get("insurance_agency"),
                    (String) m.get("insurance_name"),
                    (Integer) m.get("id"));
            reportDto.add(reportDto1);
        }
        return reportDto;
    }

    @Override
    public List<CompareInsuranceDto> findAllInsuranceCompareData() {
        List<Map<String, Object>> map1=reportRepository.findAllInsuranceCompareData();
        List<CompareInsuranceDto> compareInsuranceDto = new ArrayList<CompareInsuranceDto>();
        for (Map<String, Object> m:map1){
            CompareInsuranceDto compareInsuranceDto1 =new CompareInsuranceDto(
                    (String)m.get("insurance_agency"),
                    (String)m.get("insurance_name"),
                    (BigInteger)m.get("total_profit"),
                    (BigInteger)m.get("total_loss"));
            compareInsuranceDto.add(compareInsuranceDto1);
        }
        return compareInsuranceDto;
    }
    @Override
    public List<CompareAgencyDto> findAllAgencyCompareData() {
        List<Map<String, Object>> map1=reportRepository.findAllAgencyCompareData();
        List<CompareAgencyDto> compareAgencyDto = new ArrayList<CompareAgencyDto>();
        for (Map<String, Object> m:map1){
            CompareAgencyDto compareAgencyDto1 =new CompareAgencyDto(
                    (String)m.get("insurance_agency"),
                    (BigInteger)m.get("total_profit"),
                    (BigInteger)m.get("total_loss"));
            compareAgencyDto.add(compareAgencyDto1);
        }
        return compareAgencyDto;
    }
    @Override
    public List<InsuranceTypeDto> findAllInsuranceTypeData() {
        List<Map<String, Object>> map=reportRepository.findAllInsuranceTypeData();
        List<InsuranceTypeDto> insuranceTypeDtos = new ArrayList<InsuranceTypeDto>();
        for (Map<String, Object> m:map){
            InsuranceTypeDto insuranceTypeDto =new InsuranceTypeDto(
                    (String)m.get("insurance_name"),
                    (BigInteger)m.get("total_profit"),
                    (BigInteger)m.get("total_loss"));
            insuranceTypeDtos.add(insuranceTypeDto);
        }
        return insuranceTypeDtos;
    }


}
