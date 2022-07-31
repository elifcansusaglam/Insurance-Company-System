package com.elifcansusaglam.finalproject.service;

import com.elifcansusaglam.finalproject.model.Agency;
import com.elifcansusaglam.finalproject.repository.AgencyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyServiceIml implements AgencyService{

    AgencyRepository agencyRepository;

    @Autowired
    public AgencyServiceIml(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public List<Agency> getAllAgency() {
        List<Agency> agencyList = agencyRepository.findAll();
        return agencyList;
    }

}