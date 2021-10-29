package com.rvmagrini.springboot.service;

import java.util.List;

import org.springframework.web.bind.MethodArgumentNotValidException;

import com.rvmagrini.springboot.entity.Department;
import com.rvmagrini.springboot.exception.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department) throws MethodArgumentNotValidException;

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department updatedDepartment) throws DepartmentNotFoundException;

	public Department fetchDepartmentByName(String departmentName) throws DepartmentNotFoundException;

}
