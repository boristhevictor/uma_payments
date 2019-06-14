package com.borysp.payments.uma.app.service.employee.crud;

import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.service.crud.CRUDEntityService;

import java.util.List;

public interface EmployeeCRUDService extends CRUDEntityService<Employee, Integer> {

    List<Employee> fetchAll();

}
