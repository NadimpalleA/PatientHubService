package com.patient.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.patient.demo.entity.Patient;
@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer>{

}
