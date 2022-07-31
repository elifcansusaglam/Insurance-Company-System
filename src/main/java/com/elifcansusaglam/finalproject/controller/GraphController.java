package com.elifcansusaglam.finalproject.controller;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.elifcansusaglam.finalproject.model.CompareAgencyDto;
import com.elifcansusaglam.finalproject.model.InsuranceTypeDto;
import com.elifcansusaglam.finalproject.model.ReportDto;
import com.elifcansusaglam.finalproject.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GraphController {

    ReportService reportService;

    @Autowired
    public GraphController(ReportService reportService) {

        this.reportService = reportService;
    }

    @GetMapping("/barGraph")
    public String barGraph(Model model) {
        List<InsuranceTypeDto> list = reportService.findAllInsuranceTypeData();
        Map<String, Integer> surveyMap = new LinkedHashMap<>();
        for(int i=0;i<list.size();i++){
            surveyMap.put(list.get(i).getInsuranceName(), list.get(i).getProfit().intValue());
            model.addAttribute("surveyMap", surveyMap);
        }
            return "barGraph";
    }

    @GetMapping("/lineChart")
    public String lineChart(Model model) {
        List<ReportDto> reportList = reportService.findAllReport();
        Map<String, Integer> lineMap = new LinkedHashMap<>();
        for(int i=0;i<reportList.size();i++){
            lineMap.put(reportList.get(i).getEndDate().toString(), reportList.get(i).getProfit());
            model.addAttribute("lineMap", lineMap);
        }
        List<ReportDto> reportList2 = reportService.findAllReport();
        Map<String, Integer> lineMap2 = new LinkedHashMap<>();
        for(int i=0;i<reportList2.size();i++){
            lineMap2.put(reportList2.get(i).getEndDate().toString(), reportList2.get(i).getLoss());
            model.addAttribute("lineMap2", lineMap2);
        }
        return "lineChart";

    }

    @GetMapping("/pieChart")
    public String pieChart(Model model) {
        List<CompareAgencyDto> list= reportService.findAllAgencyCompareData();
        model.addAttribute("pass",list.get(0).getProfit());
        model.addAttribute("fail",list.get(1).getProfit());
        model.addAttribute("xyz", list.get(2).getProfit());
        return "pieChart";
    }

}
