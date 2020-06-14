package com.borysp.payments.uma.app.controller.employee.dto;

import com.borysp.payments.uma.app.model.Employee;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeDTO {

    private int id;
    private int grade;
    private int salary;
    private String name;
    private String surname;

    public EmployeeDTO(Employee employee) {
        if(employee == null) {
            throw new IllegalArgumentException("Unable to create DTO from a null Employee");
        }
        this.setId(employee.getId())
            .setGrade(employee.getGrade())
            .setSalary(employee.getSalary())
            .setName(employee.getName())
            .setSurname(employee.getSurname());
    }

}
