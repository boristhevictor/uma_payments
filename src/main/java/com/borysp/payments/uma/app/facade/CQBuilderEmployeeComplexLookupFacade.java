package com.borysp.payments.uma.app.facade;

import com.borysp.payments.uma.app.controller.employee.dto.EmployeeDTO;
import com.borysp.payments.uma.app.controller.employee.lookup.EmployeeLookupParamsModel;
import com.borysp.payments.uma.app.model.Employee;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Component
public class CQBuilderEmployeeComplexLookupFacade implements EmployeeDTOComplexLookupFacade {

    private EmployeeFacade employeeFacade;

    public CQBuilderEmployeeComplexLookupFacade(EmployeeFacade employeeFacade) {
        this.employeeFacade = employeeFacade;
    }

    @Override
    public List<EmployeeDTO> findByCompositeQuery(Collection<EmployeeLookupParamsModel> compositeQuery, Function<? super Employee, EmployeeDTO> mapper) {
        return null;
    }

    @Override
    public List<Employee> findByCompositeQuery(Collection<EmployeeLookupParamsModel> compositeQuery) {
        return null;
    }

    @Override
    public List<EmployeeDTO> findBySimpleQuery(Collection<EmployeeLookupParamsModel> simpleQuery, Function<? super Employee, EmployeeDTO> mapper) {
        return null;
    }

    @Override
    public List<Employee> findBySimpleQuery(Collection<EmployeeLookupParamsModel> simpleQuery) {
        return null;
    }
}
