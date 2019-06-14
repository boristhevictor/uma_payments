package com.borysp.payments.uma.app.service.employee.crud;

import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.repository.crud.EmployeeRepository;
import com.borysp.payments.uma.app.service.crud.CRUDEntityService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Objects.*;

@Service
@Primary
@Transactional
public class EmployeeService implements EmployeeCRUDService {

    private EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<Employee> fetch(Integer id) {
        if(id==null) {
            return Optional.empty();
        }
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(requireNonNull(employee, "Null employee passed to save"));
    }

    @Override
    public Optional<Employee> update(Integer id, Employee employee) {
        Optional<Employee> updateCandidate;
        if(id==null || employee==null){
            return Optional.empty();
        } else {
            updateCandidate = employeeRepository.findById(id);
            return updateEmployee(updateCandidate, employee);
        }
    }

    private Optional<Employee> updateEmployee(Optional<Employee> updateCandidate, Employee employee) {
        if(updateCandidate.isPresent()) {
            Employee updatedEmployee = updateCandidate.get();
            updatedEmployee
                    .name(employee.name())
                    .surname(employee.surname())
                    .salary(employee.salary())
                    .grade(employee.grade());
        }
        return updateCandidate;
    }

    @Override
    public CRUDEntityService<Employee, Integer> delete(Integer id) {
        employeeRepository.deleteById(id);
        return this;
    }
}
