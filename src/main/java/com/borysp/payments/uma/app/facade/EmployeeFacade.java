package com.borysp.payments.uma.app.facade;

import com.borysp.payments.uma.app.controller.employee.dto.EmployeeDTO;
import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.service.crud.employee.EmployeeCRUDService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class EmployeeFacade {

    private final EmployeeCRUDService employeeCRUDService;
    private ModelMapper modelMapper;

    public EmployeeFacade(EmployeeCRUDService employeeCRUDService, ModelMapper modelMapper) {
        this.employeeCRUDService = employeeCRUDService;
        this.modelMapper = modelMapper;
    }

    public List<Employee> returnAllEmployess() {
        return employeeCRUDService.fetchAll();
    }

    public <R> List<R> returnAllEmployess(Function<? super Employee, R> mapping) {
        return employeeCRUDService.fetchAll()
                .stream()
                .map(mapping)
                .collect(Collectors.toList());
    }

    public void deleteIfExistsWithId(Integer... deleteThis) {
        if(deleteThis!=null) {
            employeeCRUDService.deleteAll(Arrays.asList(deleteThis));
        }
    }

    public Employee fromDTO(EmployeeDTO dto){
        return modelMapper.map(dto, Employee.class);
    }

    public Optional<Employee> updateSingleEmployee(Integer id, Employee updated) {
        return employeeCRUDService.update(id, updated);
    }

    public Optional<Employee> returnSingleEmployee(Integer id) {
        return employeeCRUDService.fetch(id);
    }

    public <R> Optional<R> returnSingleEmployee(Integer id, Function<? super Employee, R> mapping) {
        Optional<Employee> fetched = employeeCRUDService.fetch(id);
        if(fetched.isEmpty()) {
            return Optional.empty();
        }
        return fetched.map(mapping);

    }

    public Employee createAnewEmployee(Employee createCandidate) {
        createCandidate.setId(null);
        return employeeCRUDService.save(createCandidate);
    }
}
