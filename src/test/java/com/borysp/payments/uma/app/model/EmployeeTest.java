package com.borysp.payments.uma.app.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class EmployeeTest {

    @Test
    public void representsAnEmployee() {
        Employee testEmployee = getTestEmployee(1, 0, "Cannon", "Fodder");
        Assertions.assertThat(testEmployee)
                .hasFieldOrPropertyWithValue("id", null)
                .hasFieldOrPropertyWithValue("grade", 1)
                .hasFieldOrPropertyWithValue("salary", 0)
                .hasFieldOrPropertyWithValue("name", "Cannon")
                .hasFieldOrPropertyWithValue("surname", "Fodder");
    }

    private Employee getTestEmployee(int grade, int salary, String name, String surname) {
        return new Employee()
                .setGrade(grade)
                .setSalary(salary)
                .setName(name)
                .setSurname(surname);
    }

    @Test
    public void equalsWorks() {
        Assertions.assertThat(getTestEmployee(1,1, "Mark", "Twain"))
            .isEqualTo(getTestEmployee(1,1, "Mark", "Twain"));
    }

    @Test
    public void hashCodeWorks() {
        Assertions.assertThat(getTestEmployee(1,1, "Mark", "Twain").hashCode())
                .isEqualTo(getTestEmployee(1,1, "Mark", "Twain").hashCode());
    }

    @Test
    public void toStringWorks() {
        Assertions.assertThat(getTestEmployee(1, 1, "Mark", "Twain").toString())
                .contains("Mark")
                .contains("Twain")
                .contains("salary")
                .contains("grade")
                .contains("name")
                .contains("surname")
                .contains("id");
    }

}