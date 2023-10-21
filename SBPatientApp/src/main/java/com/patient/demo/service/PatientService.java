package com.patient.demo.service;

import java.util.List;

import com.patient.demo.entity.Patient;

public interface PatientService {

	public Patient createPatient(Patient patient);
	
	public List<Patient> getAllPatients();
	
	public Patient getPatById(int empId);
	public void deletePatById(int empId);
	
}
