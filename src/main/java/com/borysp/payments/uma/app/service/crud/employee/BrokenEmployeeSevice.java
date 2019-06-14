package com.borysp.payments.uma.app.service.crud.employee;

import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.service.crud.CRUDEntityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/** This service spams Exceptions and is intended to test error handling when things go awry*/

@Service
@Profile("failTests")
public class BrokenEmployeeSevice implements EmployeeCRUDService {

    @Override
    public Optional<Employee> fetch(Integer id) {
        throw new RuntimeException("Unable to fetch");
    }

    @Override
    public Employee save(Employee employee) {
        throw new RuntimeException("Unable to save");
    }

    @Override
    public Optional<Employee> update(Integer id, Employee employee) {
        throw new RuntimeException("Unable to update");
    }

    @Override
    public CRUDEntityService<Employee, Integer> delete(Integer id) {
        throw new RuntimeException("Unable to delete");
    }

    @Override
    public List<Employee> fetchAll() {
        throw new RuntimeException("Unable to fetch all");
    }

    @Override
    public void deleteAll(List<Integer> deleteThese) {
        throw new RuntimeException("Unable to delete these");
    }
}
