package com.example.employee.Entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name ="Employees")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    //@Column(name="name")
    public String name;
    //@Column(name = "email")
    public String email;
    //@Column(name ="Salary")
    public int salary;


}
