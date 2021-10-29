package com.rvmagrini.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	
	@NotBlank(message = "Department Name is mandatory")
	private String departmentName;
	
	@NotBlank(message = "Department Address is mandatory")
	private String departmentAddress;
	
	@Length(max=5, min=5, message = "Department Code must have 5 characters")
	private String departmentCode;

}
