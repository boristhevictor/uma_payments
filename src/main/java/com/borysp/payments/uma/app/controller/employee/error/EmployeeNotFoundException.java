package com.borysp.payments.uma.app.controller.employee.error;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Integer id) {
        super("Employee not found given the id: " + id);
    }

}
