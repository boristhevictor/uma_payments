package com.borysp.payments.uma.app.controller.employee.lookup;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

public class EmployeeLookupParamsModelTest {

    @Test
    public void createsAnEmptyMapWhenNoParams() {
        //given
        EmployeeLookupParamsModel employeeLookupParamsModel = new EmployeeLookupParamsModel();
        //when
        Map<String, Set<String>> asMap = employeeLookupParamsModel.asMap();
        //should
        Assertions.assertThat(asMap).isEmpty();
    }

    @Test
    public void createsCorrectMapForParams() {
        //given
        EmployeeLookupParamsModel employeeLookupParamsModel = new EmployeeLookupParamsModel();

        HashSet<String> ids = new HashSet<>(Arrays.asList("1", "2", "3"));
        employeeLookupParamsModel.setId(ids);

        HashSet<String> grades = new HashSet<>(Arrays.asList("1", "2", "3"));
        employeeLookupParamsModel.setGrade(grades);

        HashSet<String> salaries = new HashSet<>(Arrays.asList("1000", "2000", "3000"));
        employeeLookupParamsModel.setSalary(salaries);

        HashSet<String> names = new HashSet<>(Arrays.asList("Mike", "Will", "Hosh"));
        employeeLookupParamsModel.setName(names);

        HashSet<String> surnames = new HashSet<>(Arrays.asList("Mikelson", "Wilson", "Hoshimoto"));
        employeeLookupParamsModel.setSurname(surnames);

        //when
        Map<String, Set<String>> asMap = employeeLookupParamsModel.asMap();
        //should
        Map<String, Set<String>> expectedMapping = new HashMap<>();
        expectedMapping.put("id", ids);
        expectedMapping.put("grade", grades);
        expectedMapping.put("salary", salaries);
        expectedMapping.put("name", names);
        expectedMapping.put("surname", surnames);

        Assertions.assertThat(asMap)
                .containsOnlyKeys(expectedMapping.keySet().toArray(new String[]{}))
                .containsAllEntriesOf(expectedMapping);
    }

    @Test
    public void shouldntLookupForAnEmptyModel() {
        //given
        EmployeeLookupParamsModel employeeLookupParamsModel = new EmployeeLookupParamsModel();
        //when
        boolean shouldLookup = employeeLookupParamsModel.shouldLookup();
        //should
        Assertions.assertThat(shouldLookup).isFalse();
    }

    @Test
    public void shouldLookupForNonEmptyModel() {
        //given
        EmployeeLookupParamsModel employeeLookupParamsModel = new EmployeeLookupParamsModel();
        employeeLookupParamsModel.setId(new HashSet<>(Arrays.asList("1","2","3")));

        EmployeeLookupParamsModel employeeLookupParamsModelGrades = new EmployeeLookupParamsModel();
        employeeLookupParamsModelGrades.setGrade(new HashSet<>(Arrays.asList("1","2","3")));

        EmployeeLookupParamsModel employeeLookupParamsModelSalary = new EmployeeLookupParamsModel();
        employeeLookupParamsModelSalary.setSalary(new HashSet<>(Arrays.asList("1000","2000","3000")));

        EmployeeLookupParamsModel employeeLookupParamsModelName = new EmployeeLookupParamsModel();
        employeeLookupParamsModelName.setName(new HashSet<>(Arrays.asList("Mike","Will","Hosh")));

        EmployeeLookupParamsModel employeeLookupParamsModelSurName = new EmployeeLookupParamsModel();
        employeeLookupParamsModelSurName.setSurname(new HashSet<>(Arrays.asList("Mikelson","Wilson","Hoshimoto")));

        //should
        Assertions.assertThat(employeeLookupParamsModel.shouldLookup()).isTrue();
        Assertions.assertThat(employeeLookupParamsModelGrades.shouldLookup()).isTrue();
        Assertions.assertThat(employeeLookupParamsModelSalary.shouldLookup()).isTrue();
        Assertions.assertThat(employeeLookupParamsModelName.shouldLookup()).isTrue();
        Assertions.assertThat(employeeLookupParamsModelSurName.shouldLookup()).isTrue();

    }

}