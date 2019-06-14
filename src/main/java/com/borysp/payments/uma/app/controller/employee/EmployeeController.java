package com.borysp.payments.uma.app.controller.employee;

import com.borysp.payments.uma.app.controller.employee.dto.EmployeeDTO;
import com.borysp.payments.uma.app.facade.EmployeeDTOFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeDTOFacade employeeDTOFacade;

    public EmployeeController(EmployeeDTOFacade employeeDTOFacade) {
        this.employeeDTOFacade = employeeDTOFacade;
    }

    @GetMapping({"/",""})
    public Collection<EmployeeDTO> getAll() {
        return employeeDTOFacade.returnAllEmployess();
    }

}
