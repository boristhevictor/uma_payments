package com.borysp.payments.uma.app.service.lookup.employee;

import com.borysp.payments.uma.app.controller.employee.lookup.EmployeeLookupParamsModel;
import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.service.lookup.EntityLookupService;

public interface EmployeeComplexLookupService<R> extends EntityLookupService<Employee, EmployeeLookupParamsModel, R> {
    /** Marker service interface for Employee lookups via EmployeeLookupParamsModel*/
}
