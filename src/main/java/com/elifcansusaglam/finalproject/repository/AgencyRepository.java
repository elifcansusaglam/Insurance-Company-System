package com.elifcansusaglam.finalproject.repository;

import com.elifcansusaglam.finalproject.model.Agency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Integer> {

}
