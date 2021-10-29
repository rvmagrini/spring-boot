package com.rvmagrini.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rvmagrini.springboot.entity.Department;
import com.rvmagrini.springboot.exception.DepartmentNotFoundException;
import com.rvmagrini.springboot.service.DepartmentService;

@RestController
public class DepartmentController {
	
	private DepartmentService service;
	
	public DepartmentController(DepartmentService service) {
		this.service = service;
	}
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) throws MethodArgumentNotValidException {
		LOGGER.info("Inside saveDepartment of DepartmentController");
		return service.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		LOGGER.info("Inside fetchDepartmentList of DepartmentController");
		return service.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		LOGGER.info("Inside fetchDepartmentById of DepartmentController");
		return service.fetchDepartmentById(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		LOGGER.info("Inside deleteDepartmentById of DepartmentController");
		Department deletedDepartment = service.fetchDepartmentById(departmentId);
		service.deleteDepartmentById(departmentId);
		return "[Deleted] " + deletedDepartment;
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(
			@PathVariable("id") Long departmentId, 
			@Valid @RequestBody Department updatedDepartment) throws DepartmentNotFoundException {
		LOGGER.info("Inside updateDepartment of DepartmentController");
		return service.updateDepartment(departmentId, updatedDepartment);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) throws DepartmentNotFoundException {
		LOGGER.info("Inside fetchDepartmentByName of DepartmentController");
		return service.fetchDepartmentByName(departmentName);
	}

}
