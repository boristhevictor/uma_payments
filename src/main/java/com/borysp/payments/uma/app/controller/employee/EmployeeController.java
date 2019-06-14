package com.borysp.payments.uma.app.controller.employee;

import com.borysp.payments.uma.app.controller.employee.dto.EmployeeDTO;
import com.borysp.payments.uma.app.controller.employee.error.EmployeeNotFoundException;
import com.borysp.payments.uma.app.controller.employee.lookup.EmployeeLookupParamsModel;
import com.borysp.payments.uma.app.facade.EmployeeDTOComplexLookupService;
import com.borysp.payments.uma.app.facade.EmployeeFacade;
import com.borysp.payments.uma.app.model.Employee;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeFacade employeeFacade;
    private final EmployeeDTOComplexLookupService employeeComplexLookupFacade;

    public EmployeeController(EmployeeFacade employeeFacade, EmployeeDTOComplexLookupService employeeComplexLookupFacade) {
        this.employeeFacade = employeeFacade;
        this.employeeComplexLookupFacade = employeeComplexLookupFacade;
    }

    @GetMapping({"/",""})
    public List<EmployeeDTO> findSimpleCondition(@Valid EmployeeLookupParamsModel pathQuery) {
        if(pathQuery!=null) {
            return employeeComplexLookupFacade.findBySimpleQuery(pathQuery, EmployeeDTO::new);
        }
        return employeeFacade.returnAllEmployess(EmployeeDTO::new);
    }

    @GetMapping(value = {"/",""}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDTO> findMultiCondition(@Valid List<EmployeeLookupParamsModel> model) {
        return employeeFacade.returnAllEmployess(EmployeeDTO::new);
    }

    @PostMapping
    public EmployeeDTO createSingle(@RequestBody EmployeeDTO created) {
        return new EmployeeDTO(employeeFacade.createAnewEmployee(employeeFacade.fromDTO(created)));
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<EmployeeDTO> getSingle(@PathVariable("id") Integer id) {
        return employeeFacade.returnSingleEmployee(id, EmployeeDTO::new)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> updateSingle(@RequestBody EmployeeDTO updated, @PathVariable("id") Integer id) {
        Employee employee = employeeFacade.fromDTO(updated);
        return employeeFacade.updateSingleEmployee(id, employee)
                .map(e -> ResponseEntity.ok(new EmployeeDTO(e)))
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Integer>> delete(@PathVariable("id") Integer id) {
        employeeFacade.deleteIfExistsWithId(id);
        return respondOKWithId(id);
    }

    private ResponseEntity<Map<String, Integer>> respondOKWithId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(Collections.singletonMap("id", id));
    }

}
