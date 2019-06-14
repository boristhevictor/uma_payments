package com.borysp.payments.uma.app.service.employee.crud;

import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.service.crud.CRUDEntityService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeCRUDService extends CRUDEntityService<Employee, Integer> {

    List<Employee> fetchAll();

    void deleteAll(List<Integer> deleteThese);

}
