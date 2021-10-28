package com.rvmagrini.springboot.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.rvmagrini.springboot.entity.Department;
import com.rvmagrini.springboot.repository.DepartmentRepository;

@Service
public class DepartmentServiceImplementation implements DepartmentService {
	
	private DepartmentRepository repository;
	
	public DepartmentServiceImplementation(DepartmentRepository repository) {
		this.repository = repository;
	}
	

	@Override
	public Department saveDepartment(Department department) {
		return repository.save(department);
	}


	@Override
	public List<Department> fetchDepartmentList() {
		return repository.findAll();
	}


	@Override
	public Department fetchDepartmentById(Long departmentId) {
		return repository.findById(departmentId).get();
	}


	@Override
	public void deleteDepartmentById(Long departmentId) {
		repository.deleteById(departmentId);
	}


	@Override
	public Department updateDepartment(Long departmentId, Department updatedDepartment) {
		
		Department departmentDB = repository.findById(departmentId).get();
		
		if (repository.existsById(departmentId)) {
			
			if (Objects.nonNull(updatedDepartment.getDepartmentName()) &&
					!"".equalsIgnoreCase(updatedDepartment.getDepartmentName())) {
				departmentDB.setDepartmentName(updatedDepartment.getDepartmentName());
			}
			
			if (Objects.nonNull(updatedDepartment.getDepartmentAddress()) &&
					!"".equalsIgnoreCase(updatedDepartment.getDepartmentAddress())) {
				departmentDB.setDepartmentAddress(updatedDepartment.getDepartmentAddress());
			}
			
			if (Objects.nonNull(updatedDepartment.getDepartmentCode()) &&
					!"".equalsIgnoreCase(updatedDepartment.getDepartmentCode())) {
				departmentDB.setDepartmentCode(updatedDepartment.getDepartmentCode());
			}
			
		}
		
		return repository.save(departmentDB);
	}


	@Override
	public Department fetchDepartmentByName(String departmentName) {
		return repository.findByDepartmentNameIgnoreCase(departmentName);
	}

}
