package com.patient.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.patient.demo.service.PatientServiceImpl;
import com.patient.demo.entity.Patient;
import com.patient.demo.exception.BusinessException;
import com.patient.demo.exception.ControllerException;
@RestController
@RequestMapping("/code")
public class PatientController {

	@Autowired
	PatientServiceImpl patientServiceImpl;
	
	@Autowired
	Environment environment;
	
	@GetMapping("/message")
	public String getmessage() {
		return environment.getProperty("welcome.message");
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createPatient(@RequestBody Patient patient){
		try {

			Patient addPatient=patientServiceImpl.createPatient(patient);
			return new ResponseEntity<Patient>(addPatient,HttpStatus.CREATED);
		}catch(BusinessException e) {
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessaage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST); 
		}catch(Exception e1) {
			ControllerException ce=new ControllerException("610","Something went wrong in Controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST); 
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Patient>> getAllPatients(){
		
		List<Patient> listOfPatients=patientServiceImpl.getAllPatients();
		return new ResponseEntity<List<Patient>>(listOfPatients,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/pat/{patId}")
	public ResponseEntity<?> getPatById(@PathVariable("patId") int patId){
		
		
		
		try {

			Patient patient=patientServiceImpl.getPatById(patId);
			return new ResponseEntity<Patient>(patient,HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessaage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST); 
		}catch(Exception e1) {
			ControllerException ce=new ControllerException("611","Something went wrong in Controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST); 
		}
		
		
	}
	
	@DeleteMapping("/delete/{patId}")
	public ResponseEntity<Void> deletePatById(@PathVariable("patId") int patId){
		patientServiceImpl.deletePatById(patId);
		return new  ResponseEntity<Void>(HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
		
		Patient updatedPatient=patientServiceImpl.createPatient(patient);
		return new ResponseEntity<Patient>(updatedPatient,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/")
	public String home() {
		return "<h1>welcome</h>";
	}
	@GetMapping("/user")
	public String user() {
		return "<h1> Hi User</h>";
	}
	@GetMapping("/admin")
	public String admin() {
		return "<h1>Hi Admin</h>";
	}
	
	
	
	
}
