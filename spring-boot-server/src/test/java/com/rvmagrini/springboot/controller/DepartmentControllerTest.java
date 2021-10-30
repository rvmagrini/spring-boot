package com.rvmagrini.springboot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.rvmagrini.springboot.entity.Department;
import com.rvmagrini.springboot.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	
	private Department department;

	@BeforeEach
	void setUp() {
		department = Department.builder()
				.departmentName("Mechanical")
				.departmentAddress("Juri, 458")
				.departmentCode("MC-58")
				.departmentId(1L)
				.build();
	}

	@Test
	public void saveDepartment() throws Exception {
		Department inputDepartment = Department.builder()
				.departmentName("Mechanical")
				.departmentAddress("Juri, 458")
				.departmentCode("MC-58")
				.build();
		
		Mockito.when(departmentService.saveDepartment(inputDepartment))
			.thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/departments")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "    \"departmentName\": \"Mechanical\",\r\n"
						+ "    \"departmentAddress\": \"Juri, 458\",\r\n"
						+ "    \"departmentCode\": \"MC-58\"\r\n"
						+ "  }"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	
	@Test
	public void fetchDepartmentById() throws Exception {
		Mockito.when(departmentService.fetchDepartmentById(1L))
			.thenReturn(department);
		
		mockMvc.perform(get("/departments/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.departmentName")
						.value(department.getDepartmentName()));
		
	}

}
