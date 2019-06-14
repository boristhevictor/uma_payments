package com.borysp.payments.uma.app.repository.criteriaSupporting.employee;

import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.repository.criteriaSupporting.CoreCriteriaSupportingRepository;
import org.springframework.stereotype.Component;

@Component
public class CoreCriteriaEmployeeRepository extends CoreCriteriaSupportingRepository<Employee> {

    @Override
    protected Class<? extends Employee> getEntityClass() {
        return Employee.class;
    }
}
