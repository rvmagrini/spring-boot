package com.rvmagrini.springboot.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.rvmagrini.springboot.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private TestEntityManager entityManager;
	
	
	@BeforeEach
	void setUp() {
		Department department = Department.builder()
				.departmentName("Engineering")
				.departmentAddress("Juri, 99")
				.departmentCode("EN-77")
				.build();
		
		entityManager.persist(department);
	}
	
	@Test
	public void whenFindByName_thenReturnDepartmentAddress() {
		Department department = departmentRepository.findByDepartmentNameIgnoreCase("Engineering");
		
		assertEquals(department.getDepartmentAddress(), "Juri, 99");
	}

}
