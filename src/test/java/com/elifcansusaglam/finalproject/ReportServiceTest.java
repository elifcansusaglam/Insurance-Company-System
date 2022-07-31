package com.elifcansusaglam.finalproject;


import com.elifcansusaglam.finalproject.model.*;
import com.elifcansusaglam.finalproject.service.ReportService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=Application.class)
public class ReportServiceTest {
    @Autowired
    ReportService reportService;

    @Test
    public void getAllReportTest(){
        List<Report> reportList=reportService.getAllReports();
        assertThat(reportList.size()).isEqualTo(100);
    }
    @Test
    public void findAllReportTest(){
        List<ReportDto> reportDto = reportService.findAllReport();
        assertThat(reportDto.size()).isGreaterThan(0);
        assertThat(reportDto.get(0).getEndDate()).isEqualTo("2021-03-18");
        assertThat(reportDto.get(0).getStartDate()).isEqualTo("2020-03-31");
        assertThat(reportDto.get(0).getProfit()).isEqualTo(99475);
        assertThat(reportDto.get(0).getLoss()).isEqualTo(2293);
        assertThat(reportDto.get(0).getInsuranceAgency()).isEqualTo("A insurance");
        assertThat(reportDto.get(0).getInsuranceName()).isEqualTo("Health");
    }
    @Test
    public void findAllInsuranceCompareTest(){
        List<CompareInsuranceDto> compareInsuranceDto = reportService.findAllInsuranceCompareData();
        assertThat(compareInsuranceDto.size()).isGreaterThan(0);
        assertThat(compareInsuranceDto.get(0).getInsuranceAgency()).isEqualTo("A insurance");
        assertThat(compareInsuranceDto.get(0).getInsuranceName()).isEqualTo("Car");
        assertThat(compareInsuranceDto.get(0).getProfit()).isEqualTo(1020972);
        assertThat(compareInsuranceDto.get(0).getLoss()).isEqualTo(44756);
    }
    @Test
    public void findAllAgencyCompareTest(){
        List<CompareAgencyDto> findAllAgencyCompareData =reportService.findAllAgencyCompareData();
        assertThat(findAllAgencyCompareData.size()).isGreaterThan(0);
        assertThat(findAllAgencyCompareData.get(0).getInsuranceAgency()).isEqualTo("A insurance");
        assertThat(findAllAgencyCompareData.get(0).getProfit()).isEqualTo(2978837);
        assertThat(findAllAgencyCompareData.get(0).getLoss()).isEqualTo(142833);
        assertThat(findAllAgencyCompareData.size()).isEqualTo(3);
    }

    @Test
    public void findAllInsuranceTypeTest(){
        List<InsuranceTypeDto> findAllInsuranceTypeData =reportService.findAllInsuranceTypeData();
        assertThat(findAllInsuranceTypeData.size()).isGreaterThan(0);
        assertThat(findAllInsuranceTypeData.get(0).getInsuranceName()).isEqualTo("Car");
        assertThat(findAllInsuranceTypeData.get(0).getProfit()).isEqualTo(1426312);
        assertThat(findAllInsuranceTypeData.get(0).getLoss()).isEqualTo(71353);
        assertThat(findAllInsuranceTypeData.size()).isEqualTo(3);
    }

}
