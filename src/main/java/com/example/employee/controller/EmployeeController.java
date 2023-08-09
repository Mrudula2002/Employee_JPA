package com.example.employee.controller;

import com.example.employee.Entity.Employee;
import com.example.employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
     public EmployeeService employeeService;
    //get employees data REST API
    @GetMapping("/getEmployees")
    public List getEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable  int id)
    {
       Optional<Employee> RequiredEmp = employeeService.getEmployeeById(id);
        if (RequiredEmp != null) {
            return ResponseEntity.ok(RequiredEmp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

  @GetMapping("/getByName/{employeeName}")
      public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String employeeName) {
        List<Employee> records = employeeService.getEmployeeByName(employeeName);
        if (records != null) {
            return ResponseEntity.ok(records);
        } else {
            return ResponseEntity.notFound().build();
        }
      }


    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/updateEmployees/{id}")
    public Object updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        Object UpdatedDetails = employeeService.updateEmployee(id,updatedEmployee);
       return UpdatedDetails;
    }

    @PatchMapping("/updateName/{id}")
    public ResponseEntity<Employee> updateName(@PathVariable int id, @RequestBody Employee updatedUser) {
        Employee user = employeeService.updateName(id, updatedUser);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/updateEmail/{id}")
    public Object updateMail(@PathVariable int id, @RequestBody Employee employeeMail){
        Object saved=employeeService.updateEmployeeEmail(id,employeeMail);
        return saved;
    }

    @PatchMapping("/updateSalary/{id}")
    public Object updateSalary(@PathVariable (value = "id") int  id1,@RequestBody Employee employee)
    {
        Object updated= employeeService.updateEmployeeSalary(id1,employee);
        return updated;
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") int id){
    return employeeService.deleteEmployee(id);

}

}
