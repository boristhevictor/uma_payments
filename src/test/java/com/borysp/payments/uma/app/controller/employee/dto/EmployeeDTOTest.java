package com.borysp.payments.uma.app.controller.employee.dto;

import com.borysp.payments.uma.app.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDTOTest {

    @Test
    public void constructsFromEmployee() {
        //given
        Employee testEmployee = getTestEmployee();
        //when
        EmployeeDTO employeeDTO = new EmployeeDTO(testEmployee);
        //then
        Assertions.assertThat(employeeDTO)
            .hasFieldOrPropertyWithValue("id", testEmployee.getId())
            .hasFieldOrPropertyWithValue("grade", testEmployee.getGrade())
            .hasFieldOrPropertyWithValue("salary", testEmployee.getSalary())
            .hasFieldOrPropertyWithValue("name", testEmployee.getName())
            .hasFieldOrPropertyWithValue("surname", testEmployee.getSurname());
    }

    private Employee getTestEmployee() {
        return new Employee().setGrade(12).setSalary(10000).setId(1).setName("Johny").setSurname("Test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checksForNullEmployeeAsArgument() {
        //when
        new EmployeeDTO(null);
        //should throw Exception
    }

    @Test
    public void equalsAndHashcodeWorks() {
        //given
        Employee testEmployee = getTestEmployee();
        Employee otherTestEmployee = getTestEmployee().setSurname("Malkovic");
        //when
        Map<EmployeeDTO, String> testMap = new HashMap<>();
        testMap.put(new EmployeeDTO(testEmployee), "Used as key once");
        testMap.put(new EmployeeDTO(testEmployee), "Used as key twice");
        testMap.put(new EmployeeDTO(otherTestEmployee), "Used as key once");
        //should
        Assertions.assertThat(testMap)
            .containsEntry(new EmployeeDTO(testEmployee), "Used as key twice")
            .containsEntry(new EmployeeDTO(otherTestEmployee), "Used as key once")
            .doesNotContainEntry(new EmployeeDTO(testEmployee), "Used as key once");
    }
}