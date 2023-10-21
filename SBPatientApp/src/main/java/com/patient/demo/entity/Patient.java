package com.patient.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
    String name;
	String disease; 

}
