package com.borysp.payments.uma.app.repository.criteriaSupporting.employee;

import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.repository.criteriaSupporting.CriteriaSupportingAbstractRepository;
import org.springframework.stereotype.Component;

@Component
public class CriteriaSupportingEmployeeRepositoryImpl extends CriteriaSupportingAbstractRepository<Employee> implements CriteriaSupportingEmployeeRepository {

    @Override
    protected Class<? extends Employee> getEntityClass() {
        return Employee.class;
    }

}
