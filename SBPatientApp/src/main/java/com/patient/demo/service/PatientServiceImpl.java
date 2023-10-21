package com.patient.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.demo.entity.Patient;
import com.patient.demo.exception.BusinessException;
import com.patient.demo.repo.PatientRepo;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepo patientRepo;

	public Patient createPatient(Patient patient) {

		
			if(patient.getName().isEmpty()||patient.getName().length()==0) {
				throw new BusinessException("601","Please send proper name ,If it's blank");
			}
		
			try {
		Patient savePatient = patientRepo.save(patient);
		return savePatient;
			
		}catch (IllegalArgumentException e) {
			throw new BusinessException("602","given Employee is null "+e.getMessage());
		}catch(Exception e) {
			throw new BusinessException("603","something went wrong in Service layer while saving Patient"+e.getMessage());
		}
	}

	@Override
	public List<Patient> getAllPatients() {
		
		List<Patient> patList=null;
		try {
			patList=patientRepo.findAll();
			if(patList.isEmpty()) 
				throw new BusinessException("604","Hey list is empty , I have not print anything");
				
			
			
		}catch(Exception e) {
				throw new BusinessException("605","Something went wrong in service layer while fetching all employees"+e.getMessage());
			}
			
		return patList;
		}
	@Override
	public Patient getPatById(int patId) {
		try {
		
		return patientRepo.findById(patId).get();
	}catch(IllegalArgumentException e) {
		throw new BusinessException("606","given employee id is null,Please send some id to search"+e.getMessage());
	}
		catch(java.util.NoSuchElementException e1) {
			throw new BusinessException("607","given employee id does not exist in DB "+e1.getMessage());
		}
	}

	public void deletePatById(int patId) {
		try {
			patientRepo.deleteById(patId);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("608","given employee id is null ,Please send some id to be deleted"+e.getMessage());
		}
		
		
	}

	
}
