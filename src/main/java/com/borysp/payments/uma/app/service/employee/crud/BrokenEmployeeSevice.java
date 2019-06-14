package com.borysp.payments.uma.app.service.employee.crud;

import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.service.crud.CRUDEntityService;
import org.springframework.stereotype.Service;

@Service
public class BrokenEmployeeSevice implements EmployeeCRUDService {

    @Override
    public Employee fetch(Integer id) {
        throw new RuntimeException("Unable to fetch");
    }

    @Override
    public Employee save(Employee employee) {
        throw new RuntimeException("Unable to save");
    }

    @Override
    public Employee update(Employee employee) {
        throw new RuntimeException("Unable to update");
    }

    @Override
    public CRUDEntityService<Employee, Integer> delete(Integer id) {
        throw new RuntimeException("Unable to delete");
    }
}