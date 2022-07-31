package com.elifcansusaglam.finalproject;

import com.elifcansusaglam.finalproject.model.Agency;

import com.elifcansusaglam.finalproject.service.AgencyServiceIml;
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
public class AgencyServiceTest {
    @Autowired
    AgencyServiceIml agencyServiceIml;

    @Test
    public void getAllAgencyTest(){

        List<Agency> agencyList=agencyServiceIml.getAllAgency();
        assertThat(agencyList.size()).isEqualTo(9);
    }





}