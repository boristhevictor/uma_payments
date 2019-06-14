package com.borysp.payments.uma.app.service.employee.crud;

import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.repository.crud.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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
        Employee employee = new Employee("Adrien", "Monk");
        //when
        Employee spiedResult = Mockito.spy(employeeService.update(id, employee));
        //then
        Mockito.verify(employeeRepository, Mockito.times(1)).findById(id);
        Mockito.verify(spiedResult, Mockito.times(1)).name("Adrien");
        Mockito.verify(spiedResult, Mockito.times(1)).surname("Monk");
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