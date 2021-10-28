package com.rvmagrini.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rvmagrini.springboot.entity.Department;
import com.rvmagrini.springboot.service.DepartmentService;

@RestController
public class DepartmentController {
	
	private DepartmentService service;
	
	public DepartmentController(DepartmentService service) {
		this.service = service;
	}
	
	
	
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
		return service.saveDepartment(department);
		
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		return service.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
		return service.fetchDepartmentById(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		Department deletedDepartment = service.fetchDepartmentById(departmentId);
		service.deleteDepartmentById(departmentId);
		return "[Deleted] " + deletedDepartment;
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(
			@PathVariable("id") Long departmentId, 
			@RequestBody Department updatedDepartment) {
		
		return service.updateDepartment(departmentId, updatedDepartment);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		return service.fetchDepartmentByName(departmentName);
	}

}
