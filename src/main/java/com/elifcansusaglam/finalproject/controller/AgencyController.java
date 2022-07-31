package com.elifcansusaglam.finalproject.controller;

import com.elifcansusaglam.finalproject.service.AgencyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AgencyController {
    AgencyService agencyService;

    @Autowired
    public AgencyController(AgencyService agencyService) {

        this.agencyService = agencyService;
    }
    @RequestMapping("/agency")
    public ModelAndView getAgencyPage(){
        return new ModelAndView("agency","agency",agencyService.getAllAgency());
    }


}
