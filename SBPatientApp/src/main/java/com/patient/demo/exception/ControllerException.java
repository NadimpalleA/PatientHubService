package com.patient.demo.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ControllerException {

	private static final long serialVersionUID=1L;
	private String errorCode;
	private String errorMessaage;
}
