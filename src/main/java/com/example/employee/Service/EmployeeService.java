package com.example.employee.Service;

import com.example.employee.Entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
     @Autowired
    public EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        List<Employee> values=  employeeRepository.findAll();
        if(values.isEmpty()){
            return Collections.emptyList();
        }
        return values;
    }

    public Optional<Employee> getEmployeeById(int id)
    {
        Optional<Employee> Employee1 = employeeRepository.findById(id);
        if(Employee1.isEmpty()) {
            System.out.print(" ID not found");
        }
        return Employee1;
    }

    public List<Employee> getEmployeeByName(String employeeName) {

       return employeeRepository.findByName(employeeName);

    }

    public Employee addEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
      // return savedEmployee;
    }


    public Object updateEmployee(int id, Employee updatedEmployee) {
        // Fetch the existing employee entity by its ID
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(id);

        if (existingEmployeeOptional.isPresent()) {
            // Update the fields of the fetched entity with the data from the updatedEmployee
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setSalary(updatedEmployee.getSalary());

            // Save the updated entity
           return  employeeRepository.save(existingEmployee);
        } else {
           return "ID not found";


        }
    }

    public Employee updateName(int id, Employee updatedUser) {
        Employee existingUser = employeeRepository.findById(id).get();
        if (existingUser.getName() != null) {
            existingUser.setName(updatedUser.getName());
        }
        return employeeRepository.save(existingUser);
    }


      public Object updateEmployeeEmail(int id, Employee employeeMail){
            Employee ExistingEmployee1= employeeRepository.findById(id).get();
            if(ExistingEmployee1.getEmail()!=null)
            {
                ExistingEmployee1.setEmail(employeeMail.getEmail());
             return employeeRepository.save(ExistingEmployee1);
        }
        else
           return "ID not found";
    }

    public Object updateEmployeeSalary(int id, Employee employee){
        Optional<Employee> emp = employeeRepository.findById(id);
        if (emp.isPresent()) {
            Employee ExistingEmployee1 = emp.get();
            ExistingEmployee1.setSalary(employee.getSalary());
             return employeeRepository.save(ExistingEmployee1);
        }
        else
            return "Id not found!";
    }

    public String deleteEmployee(int id)
    {
        if(employeeRepository.existsById(id)){
        employeeRepository.deleteById(id);
        return "Employee Details Deleted!";}
        else {
            return "Id doesn't exist";
        }
    }

}
