package com.borysp.payments.uma.app.service.lookup.employee;

import com.borysp.payments.uma.app.controller.employee.lookup.EmployeeLookupParamsModel;
import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.repository.jpa.employee.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class EmployeeLookupService<R> implements EmployeeComplexLookupService<R> {

    private EmployeeRepository employeeRepository;

    public EmployeeLookupService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<R> findByPathQuery(EmployeeLookupParamsModel simpleQuery, Function<? super Employee, R> mapper) {
        return findByPathQuery(simpleQuery).stream().map(mapper).collect(Collectors.toList());
    }

    @Override
    public List<? extends Employee> findByPathQuery(EmployeeLookupParamsModel simpleQuery) {
        return employeeRepository.findWithCriteria(simpleQuery.asMap());
    }

}
