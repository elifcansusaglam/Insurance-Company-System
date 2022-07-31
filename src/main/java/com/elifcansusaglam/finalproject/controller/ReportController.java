package com.elifcansusaglam.finalproject.controller;

import com.elifcansusaglam.finalproject.model.CompareInsuranceDto;
import com.elifcansusaglam.finalproject.model.ReportDto;
import com.elifcansusaglam.finalproject.service.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;


import java.util.*;

@Controller
public class ReportController {
    ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {

        this.reportService = reportService;
    }
    @RequestMapping("/reports")
    public ModelAndView getReportPage(){

        return new ModelAndView("reports","reports",reportService.getAllReports());
    }

    @RequestMapping("/allReports")
    public ModelAndView getReportsPage(){
        List<ReportDto> reportList = reportService.findAllReport();
        return new ModelAndView("allReports","allReports",reportList);
    }

    @RequestMapping("/compare")
    public ModelAndView getComparePage(){
        List<CompareInsuranceDto> compareList = reportService.findAllInsuranceCompareData();
        return new ModelAndView("compare","compare",compareList);
    }

}
