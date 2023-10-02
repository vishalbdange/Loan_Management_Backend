package com.example.loan_management_backend_new;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.loan_management_backend_new.entities.Employee;
import com.example.loan_management_backend_new.repositories.EmployeeRepository;
import com.example.loan_management_backend_new.services.EmployeeServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void getAllEmployeeTest() {
    	Employee employee1 = new Employee(12345, "12345", "priyanka", "female", 22, 10000.00, "pri123@mail.com",
				LocalDate.of(2018, 11, 10), "7584663746");
		Employee employee2 = new Employee(22345, "122345", "radhika", "female", 32, 11000.00, "rad123@mail.com",
				LocalDate.of(2019, 11, 10), "8584663746");
		Employee employee3 = new Employee(32345, "32345", "mansi", "female", 22, 10000.00, "mans123@mail.com",
				LocalDate.of(2020, 11, 10), "9584663746");

		List<Employee> emps = Arrays.asList(employee1, employee2, employee3);

		
        when(employeeRepository.findAll()).thenReturn(emps);

        List<Employee> retrievedemps = employeeService.getAllEmployees();
        assertEquals(emps.size(), retrievedemps.size());
        for (int i = 0; i < emps.size(); i++) {
            Employee expectedemp = emps.get(i);
            Employee retrievedemp = retrievedemps.get(i);
            assertEquals(expectedemp.getEmployeeId(), retrievedemp.getEmployeeId());
            assertEquals(expectedemp.getEmployeePassword(), retrievedemp.getEmployeePassword());
            assertEquals(expectedemp.getEmployeeName(), retrievedemp.getEmployeeName());
            assertEquals(expectedemp.getGender(), retrievedemp.getGender());
         // assertEquals(expectedemp.getSalary(), retrievedemp.getSalary());
            assertEquals(expectedemp.getEmail(),retrievedemp.getEmail());
            assertEquals(expectedemp.getDoj(), retrievedemp.getDoj());
            assertEquals(expectedemp.getMobile(), retrievedemp.getMobile());
            
            
        }
        
        verify(employeeRepository, times(1)).findAll();
    }
    
   
    @Test
    public void getByIdTest() {
        int employeeId = 1000;
        Employee employee = new Employee(1000, "password", "pravin", "male", 52, 450000.00, "pra123@mail.com",
				LocalDate.of(2015, 12, 12), "9921665546");
		 
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        Employee retrievedEmployee = employeeService.getEmployeeById(employeeId);  
        //assertTrue(retrievedEmployee.isPresent());
        assertEquals(employee.getEmployeeId(), retrievedEmployee.getEmployeeId());
        assertEquals(employee.getEmployeePassword(), retrievedEmployee.getEmployeePassword());
        assertEquals(employee.getEmployeeName(), retrievedEmployee.getEmployeeName());
        assertEquals(employee.getGender(), retrievedEmployee.getGender());
     // assertEquals(expectedemp.getSalary(), retrievedemp.getSalary());
        assertEquals(employee.getEmail(),retrievedEmployee.getEmail());
        assertEquals(employee.getDoj(), retrievedEmployee.getDoj());
        assertEquals(employee.getMobile(), retrievedEmployee.getMobile());
    //  assertEquals(employee.getBalance(), retrievedAccount.get().getBalance());
        //assertEquals(account.getAccount_status(),retrievedAccount.get().getAccount_status());
        verify(employeeRepository, times(1)).findById(employeeId);
    }

    @Test
    public void removeUserTest() {
    	Employee emp = new Employee(2, "xxx", "tanvi", "female", 32, 67000.00, "tanvi@mail.com",
				LocalDate.of(2021, 9, 9), "8897856473");
    	employeeService.removeEmployee(emp);
        verify(employeeRepository, times(1)).delete(emp);
    }
    @Test
    public void addEmployeeTest() {
    	Employee empnew = new Employee(8000, "98765", "arush", "male", 25, 850000.00, "arush@mail.com",
				LocalDate.of(2016, 11, 12), "9876554612");
        when(employeeRepository.save(any(Employee.class))).thenReturn(empnew);
        
        Employee savedEmployee = employeeService.addEmployee(empnew);
        assertNotNull(savedEmployee);
        assertEquals(empnew.getEmployeeId(), savedEmployee.getEmployeeId());
        assertEquals(empnew.getEmployeePassword(), savedEmployee.getEmployeePassword());
        assertEquals(empnew.getEmployeeName(), savedEmployee.getEmployeeName());
        assertEquals(empnew.getGender(), savedEmployee.getGender());
     // assertEquals(expectedemp.getSalary(), retrievedemp.getSalary());
        assertEquals(empnew.getEmail(),savedEmployee.getEmail());
        assertEquals(empnew.getDoj(), savedEmployee.getDoj());
        assertEquals(empnew.getMobile(), savedEmployee.getMobile());
  
        verify(employeeRepository, times(1)).save(eq(empnew));
    }

}