package com.borysp.payments.uma.app.service.crud.employee.crud;

import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.repository.jpa.employee.EmployeeRepository;
import com.borysp.payments.uma.app.service.crud.employee.EmployeeService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeService employeeService;

    @Test
    public void fetchesEmployeeById() {
        //given
        int id = 0;
        //when
        employeeService.fetch(id);
        //then
        Mockito.verify(employeeRepository, Mockito.only()).findById(id);
    }

    @Test
    public void savesAnEmployee() {
        //given
        Employee employee = new Employee("Adrien", "Monk");
        //when
        employeeService.save(employee);
        //then
        Mockito.verify(employeeRepository, Mockito.only()).save(employee);
    }

    @Test
    public void updatesAnEmployee() {
        //given
        int id=0;
        Employee employee = new Employee("Adrien", "Monk").setGrade(1).setSalary(25000);
        //when
        Mockito.doReturn(Optional.of(new Employee())).when(employeeRepository).findById(id);
        Employee result = employeeService.update(id, employee).get();
        //then
        Mockito.verify(employeeRepository, Mockito.times(1)).findById(id);
        Assertions.assertThat(result)
                .hasFieldOrPropertyWithValue("grade", 1)
                .hasFieldOrPropertyWithValue("salary", 25000)
                .hasFieldOrPropertyWithValue("name", "Adrien")
                .hasFieldOrPropertyWithValue("surname", "Monk");
    }

    @Test
    public void deletesAnEmployee() {
        //given
        int id1 = 0;
        int id2 = 1;
        int id3 = 2;
        //when
        employeeService
                .delete(id1)
                .delete(id2)
                .delete(id3);
        //then
        Mockito.verify(employeeRepository).deleteById(id1);
        Mockito.verify(employeeRepository).deleteById(id2);
        Mockito.verify(employeeRepository).deleteById(id3);
        Mockito.verifyNoMoreInteractions(employeeRepository);
    }
}