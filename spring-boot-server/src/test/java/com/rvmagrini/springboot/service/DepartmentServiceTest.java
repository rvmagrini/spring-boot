package com.rvmagrini.springboot.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rvmagrini.springboot.entity.Department;
import com.rvmagrini.springboot.exception.DepartmentNotFoundException;
import com.rvmagrini.springboot.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() throws Exception {
		Department department = Department.builder()
				.departmentName("IT")
				.departmentAddress("Juri 45")
				.departmentCode("IT-88")
				.departmentId(1L)
				.build();
		
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
		.thenReturn(department);
		
	}

	@Test
	public void whenValidDepartmentName_thenDepartmentShouldBeFound() throws DepartmentNotFoundException {
		String departmentName = "IT";
		Department found = departmentService.fetchDepartmentByName(departmentName);
		
		assertEquals(departmentName, found.getDepartmentName());
	}

}
