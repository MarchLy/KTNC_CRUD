package com.example.testcrud.service;

import com.example.testcrud.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
    }

    public void updateEmployee(Employee emp, int id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                employeeList.set(i, emp);
                return;
            }
        }
    }

    public void deleteEmployee(int id) {
        employeeList.removeIf(emp -> emp.getId() == id);
    }

    public Employee searchEmployee(int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public List<Employee> getAll() {
        return employeeList;
    }
}
