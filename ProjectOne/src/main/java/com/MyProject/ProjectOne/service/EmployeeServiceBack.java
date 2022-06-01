package com.MyProject.ProjectOne.service;

import com.MyProject.ProjectOne.exceptions.UserNotFoundException;
import com.MyProject.ProjectOne.model.Employee;
import com.MyProject.ProjectOne.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceBack {
    private final EmployeeRepo employeeRepo;

    public EmployeeServiceBack(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee AddEmplyoee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> FindAllEmployees(){

        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public void deleteEmployee(long id){
        employeeRepo.deleteEmployeeById(id);
    }
    public Employee FindEmployeeByID(long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("USER NOT FOUND"));
    }
}
