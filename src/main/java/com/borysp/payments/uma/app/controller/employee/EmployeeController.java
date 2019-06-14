package com.borysp.payments.uma.app.controller.employee;

import com.borysp.payments.uma.app.controller.employee.dto.EmployeeDTO;
import com.borysp.payments.uma.app.facade.EmployeeFacade;
import com.borysp.payments.uma.app.model.Employee;
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

    @GetMapping({"/{id}"})
    public ResponseEntity<EmployeeDTO> getSingle(@PathVariable("id") Integer id) {
        return employeeDTOFacade.returnSingleEmployee(id, EmployeeDTO::new)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> updateSingle(@RequestBody EmployeeDTO updated, @PathVariable("id") Integer id) {
        Employee employee = employeeDTOFacade.fromDTO(updated);
        return employeeDTOFacade.updateSingleEmployee(id, employee)
                .map(e -> ResponseEntity.ok(new EmployeeDTO(e)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Integer>> delete(@PathVariable("id") Integer id) {
        employeeDTOFacade.deleteForId(id);
        return ResponseEntity.ok(wrapId(id));
    }

    private Map<String, Integer> wrapId(@PathVariable("id") Integer id) {
        return Collections.singletonMap("id", id);
    }

}
