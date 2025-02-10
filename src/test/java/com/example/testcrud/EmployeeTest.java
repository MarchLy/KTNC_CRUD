package com.example.testcrud;


import com.example.testcrud.entity.Employee;
import com.example.testcrud.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class EmployeeTest {
    EmployeeService service;

    @BeforeEach
    public void setup() {
        service = new EmployeeService();
    }

    @Test
    public void testAddValid() {
        Employee emp = new Employee(1, "John Doe", "IT", 5000);
        service.addEmployee(emp);
        assertEquals(1, service.getAll().size());
    }

    @Test
    public void testUpdateValid() {
        Employee emp = new Employee(1, "John Doe", "IT", 5000);
        service.addEmployee(emp);
        Employee updatedEmp = new Employee(1, "John Smith", "HR", 6000);
        service.updateEmployee(updatedEmp, 1);
        assertEquals("John Smith", service.getAll().get(0).getName());
    }

    @Test
    public void testDeleteValid() {
        Employee emp = new Employee(1, "John Doe", "IT", 5000);
        service.addEmployee(emp);
        service.deleteEmployee(1);
        assertEquals(0, service.getAll().size());
    }

    @Test
    public void testSearchValid() {
        Employee emp = new Employee(1, "John Doe", "IT", 5000);
        service.addEmployee(emp);
        Employee foundEmp = service.searchEmployee(1);
        assertNotNull(foundEmp);
    }
}
