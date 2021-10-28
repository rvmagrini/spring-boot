package com.rvmagrini.springboot.service;

import java.util.List;

import com.rvmagrini.springboot.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long departmentId);

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department updatedDepartment);

	public Department fetchDepartmentByName(String departmentName);

}
