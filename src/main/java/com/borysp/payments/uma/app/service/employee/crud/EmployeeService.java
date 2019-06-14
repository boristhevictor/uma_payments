package com.borysp.payments.uma.app.service.employee.crud;

import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.repository.crud.EmployeeRepository;
import com.borysp.payments.uma.app.service.crud.CRUDEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.*;

@Service
@Primary
@Transactional
@Slf4j
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
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        log.debug("Fetched: {}", foundEmployee.isPresent()? foundEmployee.get() : "nothing for id: " + id);
        return foundEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        log.debug("Creating employee: {}", employee );
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
            log.debug("Updating employee from: {}, to: {}", updateCandidate.get(), employee );
            Employee updatedEmployee = updateCandidate.get();
            updatedEmployee.setName(employee.getName())
                    .setSurname(employee.getSurname())
                    .setSalary(employee.getSalary())
                    .setGrade(employee.getGrade());
        }
        return updateCandidate;
    }

    @Override
    public CRUDEntityService<Employee, Integer> delete(Integer id) {
        log.debug("Deleting Employee with Id: {}", id);
        employeeRepository.deleteById(id);
        return this;
    }

    @Override
    public List<Employee> fetchAll() {
        List<Employee> allEmployees = employeeRepository.findAll();
        log.debug("Fetched: {}", allEmployees);
        return allEmployees;
    }

    @Override
    public void deleteAll(List<Integer> deleteThese) {
        List<Employee> deleteCandidates = employeeRepository.findAllById(deleteThese);
        log.debug("Deleting: {}", deleteCandidates);
        employeeRepository.deleteAll(deleteCandidates);
    }
}