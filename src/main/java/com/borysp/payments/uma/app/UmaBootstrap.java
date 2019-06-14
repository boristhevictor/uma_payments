package com.borysp.payments.uma.app;

import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.service.employee.crud.EmployeeCRUDService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("bootstrap")
public class UmaBootstrap implements CommandLineRunner {

    private EmployeeCRUDService employeeCRUDService;

    UmaBootstrap(EmployeeCRUDService employeeCRUDService) {
        this.employeeCRUDService = employeeCRUDService;
    }

    @Override
    public void run(String... args) throws Exception {
        employeeCRUDService.save(new Employee("Mike", "Myers"));
        employeeCRUDService.save(new Employee("Alfred", "Molina"));
        employeeCRUDService.save(new Employee("Walter", "White"));
    }
}
