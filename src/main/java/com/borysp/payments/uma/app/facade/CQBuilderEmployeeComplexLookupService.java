package com.borysp.payments.uma.app.facade;

import com.borysp.payments.uma.app.controller.employee.dto.EmployeeDTO;
import com.borysp.payments.uma.app.controller.employee.lookup.EmployeeLookupParamsModel;
import com.borysp.payments.uma.app.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class CQBuilderEmployeeComplexLookupService implements EmployeeDTOComplexLookupService {

    private EmployeeFacade employeeFacade;

    public CQBuilderEmployeeComplexLookupService(EmployeeFacade employeeFacade) {
        this.employeeFacade = employeeFacade;
    }

    @Override
    public List<EmployeeDTO> findBySimpleQuery(EmployeeLookupParamsModel simpleQuery, Function<? super Employee, EmployeeDTO> mapper) {
        return null;
    }

    @Override
    public List<Employee> findBySimpleQuery(EmployeeLookupParamsModel simpleQuery) {
        return null;
    }
}
