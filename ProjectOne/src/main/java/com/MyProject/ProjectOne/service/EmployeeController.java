package com.MyProject.ProjectOne.service;

import com.MyProject.ProjectOne.model.Employee;
import com.MyProject.ProjectOne.repo.EmployeeRepo;
import com.MyProject.ProjectOne.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> list = employeeService.FindAllEmployees();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> FindEmployee(@PathVariable("id") Long id ){
         Employee found = employeeService.FindEmployeeByID(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> AddEmployee(@RequestBody Employee employee){
        Employee employeetemp = employeeService.AddEmplyoee(employee);
        return new ResponseEntity<>(employeetemp,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> UpdateEmployee(@RequestBody Employee employee){
        Employee employeetemp = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employeetemp,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteEmployee(@PathVariable("id") Long id){
         employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
