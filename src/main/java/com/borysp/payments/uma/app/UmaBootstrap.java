package com.borysp.payments.uma.app;

import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.service.employee.crud.EmployeeCRUDService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UmaBootstrap implements ApplicationRunner {

    private EmployeeCRUDService employeeCRUDService;

    UmaBootstrap(EmployeeCRUDService employeeCRUDService) {
        this.employeeCRUDService = employeeCRUDService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        employeeCRUDService.save(new Employee("Harrison", "Ford"));
    }

}
