package com.elifcansusaglam.finalproject.model;

import javax.persistence.*;
@Entity
@Table(name = "insurance_agency")
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="insurance_agency")
    private String insuranceAgency;
    @Column(name="insurance_name")
    private String insuranceName;

    public Agency() {
    }

    public Agency(int id, String insuranceAgency, String insuranceName) {
        this.id = id;
        this.insuranceAgency = insuranceAgency;
        this.insuranceName = insuranceName;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInsuranceAgency() {
        return insuranceAgency;
    }

    public void setInsuranceAgency(String insuranceAgency) {
        this.insuranceAgency = insuranceAgency;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }
    @Override
    public String toString() {
        return "Agency{" +
                "id=" + id +
                ", insuranceAgency='" + insuranceAgency + '\'' +
                ", insuranceName='" + insuranceName + '\'' +
                '}';
    }

}
