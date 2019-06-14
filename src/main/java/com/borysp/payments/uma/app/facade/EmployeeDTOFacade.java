package com.borysp.payments.uma.app.facade;

import com.borysp.payments.uma.app.controller.employee.dto.EmployeeDTO;
import com.borysp.payments.uma.app.service.employee.crud.EmployeeCRUDService;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class EmployeeDTOFacade {

    private final EmployeeCRUDService employeeCRUDService;

    public EmployeeDTOFacade(EmployeeCRUDService employeeCRUDService) {
        this.employeeCRUDService = employeeCRUDService;
    }


    public Collection<EmployeeDTO> returnAllEmployess() {
        return employeeCRUDService.fetchAll()
                .stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }

}
