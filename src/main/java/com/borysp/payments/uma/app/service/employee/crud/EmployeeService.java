package com.borysp.payments.uma.app.service.employee.crud;

import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.repository.crud.EmployeeRepository;
import com.borysp.payments.uma.app.service.crud.CRUDEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService implements EmployeeCRUDService {

    private EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee fetch(Integer id) {
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    @Transactional
    public Employee update(Integer id, Employee employee) {
        return null;
    }

    @Override
    public CRUDEntityService<Employee, Integer> delete(Integer id) {
        return null;
    }
}
