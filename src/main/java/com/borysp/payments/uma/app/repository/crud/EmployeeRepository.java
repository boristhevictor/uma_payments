package com.borysp.payments.uma.app.repository.crud;

import com.borysp.payments.uma.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
