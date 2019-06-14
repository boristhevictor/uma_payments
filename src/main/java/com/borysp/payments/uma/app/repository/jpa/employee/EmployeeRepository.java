package com.borysp.payments.uma.app.repository.jpa.employee;

import com.borysp.payments.uma.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeCriteriaSupportingRepository {
    /** JPARepository + CriteriaSupporting = able to from criteria queries from attributes */
}
