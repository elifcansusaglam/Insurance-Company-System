package com.elifcansusaglam.finalproject.repository;

import com.elifcansusaglam.finalproject.model.Report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    @Query(value = "SELECT r.start_date,r.end_date,r.profit,r.loss,a.insurance_name,a.insurance_agency ,a.id FROM   insurance_agency a Inner Join insurance_report r  ON r.insurance_id=a.id ORDER BY r.end_date", nativeQuery = true)
    List<Map<String, Object>>  findAllReport();

    @Query(value = "SELECT  a.insurance_agency ,a.insurance_name, SUM(r.profit) as total_profit,SUM(r.loss) as total_loss FROM  insurance_agency a INNER JOIN insurance_report r  ON r.insurance_id=a.id GROUP BY a.insurance_agency, a.insurance_name ORDER BY a.insurance_agency ", nativeQuery = true)
    List<Map<String, Object>>  findAllInsuranceCompareData();

    @Query(value = "SELECT  a.insurance_agency , SUM(r.profit) as total_profit,SUM(r.loss) as total_loss FROM  insurance_agency a INNER JOIN insurance_report r  ON r.insurance_id=a.id GROUP BY a.insurance_agency ORDER BY a.insurance_agency ", nativeQuery = true)
    List<Map<String, Object>>  findAllAgencyCompareData();

    @Query(value = " SELECT a.insurance_name,SUM(r.profit) AS total_profit ,SUM(r.loss) AS total_loss FROM  insurance_agency a Inner Join insurance_report r  ON r.insurance_id=a.id Group by a.insurance_name; ", nativeQuery = true)
    List<Map<String, Object>>  findAllInsuranceTypeData();


}
