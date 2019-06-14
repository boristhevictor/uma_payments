package com.borysp.payments.uma.app.repository.crud;

import com.borysp.payments.uma.app.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
