package com.example.loan_management_backend_new;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.loan_management_backend_new.controller.EmployeeController;
import com.example.loan_management_backend_new.entities.Employee;
import com.example.loan_management_backend_new.services.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	private EmployeeServiceImpl employeeServiceProvider;
   
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}

	@Test
	public void getAllEmployeeTest() throws Exception {
		Employee employee1 = new Employee(12345, "12345", "priyanka", "female", 22, 10000.00, "pri123@mail.com",
				LocalDate.of(2018, 11, 10), "7584663746");
		Employee employee2 = new Employee(22345, "122345", "radhika", "female", 32, 11000.00, "rad123@mail.com",
				LocalDate.of(2019, 11, 10), "8584663746", "admin");
		Employee employee3 = new Employee(32345, "32345", "mansi", "female", 22, 10000.00, "mans123@mail.com",
				LocalDate.of(2020, 11, 10), "9584663746");

		List<Employee> emps = Arrays.asList(employee1, employee2, employee3);

		when(employeeServiceProvider.getAllEmployees()).thenReturn(emps);

		mockMvc.perform(get("/api/employees/getAll")).andExpect(status().isOk())
				.andExpect(jsonPath("$.length()", is(emps.size())))
				.andExpect(jsonPath("$[0].employeePassword", is(emps.get(0).getEmployeePassword())))
				.andExpect(jsonPath("$[1].employeePassword", is(emps.get(1).getEmployeePassword())))
				.andExpect(jsonPath("$[2].employeePassword", is(emps.get(2).getEmployeePassword())));

		verify(employeeServiceProvider, times(1)).getAllEmployees();
	}

	@Test
	public void getEmployeeByIdTest() throws Exception {
		Employee emp = new Employee(32345, "32345", "mansi", "female", 22, 10000.00, "mans123@mail.com",
				LocalDate.of(2020, 11, 10), "9584663746");
		int empId = 32345;
		// Optional<Employee> employeeOptional=Optional.of(emp);
		when(employeeServiceProvider.getEmployeeById(empId)).thenReturn(emp);
		mockMvc.perform(get("/api/employees/{id}", empId)).andExpect(status().isOk())
				.andExpect(jsonPath("$.employeePassword", is(emp.getEmployeePassword())))
				.andExpect(jsonPath("$.employeeName", is(emp.getEmployeeName())))
				.andExpect(jsonPath("$.gender", is(emp.getGender())))
				.andExpect(jsonPath("$.salary", is(emp.getSalary())))
				.andExpect(jsonPath("$.mobile", is(emp.getMobile())))
				// .andExpect(jsonPath("$.doj", is(emp.getDoj())))
				.andExpect(jsonPath("$.email", is(emp.getEmail())));

		verify(employeeServiceProvider, times(1)).getEmployeeById(empId);
	}

	/*
	 * @Test public void createEmployeeTest() throws Exception { Employee
	 * newEmployee = new Employee(2151483, "Abcd@123", "sid", "male", 52, 10000.00,
	 * "leen123@mail.com", null, "6584663746");
	 * 
	 * when(employeeServiceProvider.addEmployee(any(Employee.class))).thenReturn(
	 * newEmployee);
	 * 
	 * mockMvc.perform(post("/api/employees/add")
	 * .contentType(MediaType.APPLICATION_JSON) .content(new
	 * ObjectMapper().writeValueAsString(newEmployee))) .andExpect(status().isOk())
	 * .andExpect(jsonPath("$.employeePassword",is(newEmployee.getEmployeePassword()
	 * ))) .andExpect(jsonPath("$.employeeName", is(newEmployee.getEmployeeName())))
	 * .andExpect(jsonPath("$.salary", is(newEmployee.getSalary())))
	 * .andExpect(jsonPath("$.age", is(newEmployee.getAge())))
	 * .andExpect(jsonPath("$.gender", is(newEmployee.getGender())))
	 * .andExpect(jsonPath("$.employeeId", is(newEmployee.getEmployeeId())))
	 * .andExpect(jsonPath("$.mobile", is(newEmployee.getMobile())))
	 * .andExpect(jsonPath("$.doj", is(newEmployee.getDoj())))
	 * .andExpect(jsonPath("$.email", is(newEmployee.getEmail())));
	 * 
	 * verify(employeeServiceProvider, times(1)).addEmployee(newEmployee); }
	 * 
	 * @Test public void updateEmployeeTest() throws Exception { Employee
	 * existingEmployee = new Employee(1000, "35345", "sid", "male", 52, 10000.00,
	 * "leen123@mail.com", LocalDate.of(2018, 11, 10), "6584663746"); Employee
	 * updatedEmployee = new Employee(9938865, "35345", "sid", "male", 52, 10000.00,
	 * "leen123@mail.com", LocalDate.of(2017, 11, 10), "6584663746"); int employeeId
	 * = 1000;
	 * 
	 * when(employeeServiceProvider.getEmployeeById(employeeId)).thenReturn(
	 * existingEmployee);
	 * when(employeeServiceProvider.addEmployee(any())).thenReturn(updatedEmployee);
	 * 
	 * mockMvc.perform(put("/api/employees/update/{id}", employeeId)
	 * .contentType(MediaType.APPLICATION_JSON) .content(new
	 * ObjectMapper().writeValueAsString(updatedEmployee)))
	 * .andExpect(status().isOk())
	 * .andExpect(jsonPath("$.employeePassword",is(updatedEmployee.
	 * getEmployeePassword()))) .andExpect(jsonPath("$.salary",
	 * is(updatedEmployee.getSalary()))) .andExpect(jsonPath("$.age",
	 * is(updatedEmployee.getAge()))) .andExpect(jsonPath("$.gender",
	 * is(updatedEmployee.getGender()))) .andExpect(jsonPath("$.employeeName",
	 * is(updatedEmployee.getEmployeeName()))) .andExpect(jsonPath("$.employeeId",
	 * is(updatedEmployee.getEmployeeId()))) .andExpect(jsonPath("$.mobile",
	 * is(updatedEmployee.getMobile()))) .andExpect(jsonPath("$.doj",
	 * is(updatedEmployee.getDoj()))) .andExpect(jsonPath("$.email",
	 * is(updatedEmployee.getEmail())));
	 * 
	 * verify(employeeServiceProvider, times(1)).addEmployee(any()); }
	 */

	@Test
	public void deleteAccountTest() throws Exception {
		Employee todeleteEmployee = new Employee(87365, "38845", "sameer", "male", 52, 10000.00, "leen123@mail.com",
				LocalDate.of(2020, 10, 10), "9984663746");
		int empId = 87365;

		when(employeeServiceProvider.getEmployeeById(empId)).thenReturn(todeleteEmployee);

		mockMvc.perform(delete("/api/employees/remove/{id}", empId)).andExpect(status().isOk());

		verify(employeeServiceProvider, times(1)).removeEmployee(todeleteEmployee);
	}
}