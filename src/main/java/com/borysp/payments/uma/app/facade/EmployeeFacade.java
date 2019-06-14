package com.borysp.payments.uma.app.facade;

import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.service.employee.crud.EmployeeCRUDService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class EmployeeFacade {

    private final EmployeeCRUDService employeeCRUDService;

    public EmployeeFacade(EmployeeCRUDService employeeCRUDService) {
        this.employeeCRUDService = employeeCRUDService;
    }

    public List<Employee> returnAllEmployess() {
        return employeeCRUDService.fetchAll();
    }

    public <R> List<R> returnAllEmployess(Function<? super Employee, R> mapping) {
        return employeeCRUDService.fetchAll()
                .stream()
                .map(mapping)
                .collect(Collectors.toList());
    }

    public void deleteForId(Integer... deleteThis) {
        if(deleteThis!=null) {
            employeeCRUDService.deleteAll(Arrays.asList(deleteThis));
        }
    }
}
