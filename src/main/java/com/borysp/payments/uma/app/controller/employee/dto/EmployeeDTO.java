package com.borysp.payments.uma.app.controller.employee.dto;

import com.borysp.payments.uma.app.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    int id;
    int grade;
    int salary;
    String name;
    String surname;

    public EmployeeDTO(Employee employee) {
        this.setId(employee.id())
                .setGrade(employee.grade())
                .setSalary(employee.salary())
                .setName(employee.name())
                .setSurname(employee.surname());
    }

}
