package com.borysp.payments.uma.app.controller.employee;

import com.borysp.payments.uma.app.controller.employee.dto.EmployeeDTO;
import com.borysp.payments.uma.app.facade.EmployeeFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeFacade employeeDTOFacade;

    public EmployeeController(EmployeeFacade employeeDTOFacade) {
        this.employeeDTOFacade = employeeDTOFacade;
    }

    @GetMapping({"/",""})
    public List<EmployeeDTO> getAll() {
        return employeeDTOFacade.returnAllEmployess(EmployeeDTO::new);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Integer>> delete(@PathVariable("id") Integer id) {
        employeeDTOFacade.deleteForId(id);
        return ResponseEntity.ok(Collections.singletonMap("id", id));
    }

}
