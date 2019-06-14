package com.borysp.payments.uma.app.facade;

import com.borysp.payments.uma.app.controller.employee.dto.EmployeeDTO;
import com.borysp.payments.uma.app.controller.employee.lookup.EmployeeLookupParamsModel;
import com.borysp.payments.uma.app.model.Employee;

public interface EmployeeDTOComplexLookupFacade extends ComplexEntityLookupFacade<Employee, EmployeeLookupParamsModel, EmployeeDTO>{

}
