package com.rvmagrini.springboot.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.rvmagrini.springboot.entity.Department;
import com.rvmagrini.springboot.exception.DepartmentNotFoundException;
import com.rvmagrini.springboot.repository.DepartmentRepository;

@Service
public class DepartmentServiceImplementation implements DepartmentService {
	
	private DepartmentRepository repository;
	
	public DepartmentServiceImplementation(DepartmentRepository repository) {
		this.repository = repository;
	}
	

	@Override
	public Department saveDepartment(Department department) throws MethodArgumentNotValidException {
		return repository.save(department);
	}


	@Override
	public List<Department> fetchDepartmentList() {
		return repository.findAll();
	}


	@Override
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		
		Optional<Department> department = repository.findById(departmentId);
		
		if (!department.isPresent()) {
			throw new DepartmentNotFoundException("Department not found.");
		}
		
		return department.get();
	}


	@Override
	public void deleteDepartmentById(Long departmentId) {
		repository.deleteById(departmentId);
	}


	@Override
	public Department updateDepartment(Long departmentId, Department updatedDepartment) throws DepartmentNotFoundException {
		
		Optional<Department> departmentDB = repository.findById(departmentId);
		
		if (!departmentDB.isPresent()) {
			throw new DepartmentNotFoundException("Department not found.");
		}
			
		if (Objects.nonNull(updatedDepartment.getDepartmentName()) &&
				!"".equalsIgnoreCase(updatedDepartment.getDepartmentName())) {
			departmentDB.get().setDepartmentName(updatedDepartment.getDepartmentName());
		}
			
		if (Objects.nonNull(updatedDepartment.getDepartmentAddress()) &&
				!"".equalsIgnoreCase(updatedDepartment.getDepartmentAddress())) {
			departmentDB.get().setDepartmentAddress(updatedDepartment.getDepartmentAddress());
		}
			
		if (Objects.nonNull(updatedDepartment.getDepartmentCode()) &&
				!"".equalsIgnoreCase(updatedDepartment.getDepartmentCode())) {
			departmentDB.get().setDepartmentCode(updatedDepartment.getDepartmentCode());
		}		
		
		return repository.save(departmentDB.get());
	}


	@Override
	public Department fetchDepartmentByName(String departmentName) throws DepartmentNotFoundException {
		
		Optional<Department> department = Optional.ofNullable(repository.findByDepartmentNameIgnoreCase(departmentName));
		
		if (!department.isPresent()) {
			throw new DepartmentNotFoundException("Department not found.");
		}
		
		return department.get();
	}

}
