package com.borysp.payments.uma.app;

import com.borysp.payments.uma.app.model.Employee;
import com.borysp.payments.uma.app.service.crud.employee.EmployeeCRUDService;
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
        employeeCRUDService.save(new Employee("Hodor", "Hodor").setSalary(10000).setGrade(5));
        employeeCRUDService.save(new Employee("Lieb", "Shreider").setSalary(20000).setGrade(10));
        employeeCRUDService.save(new Employee("Arthur", "Doyle").setSalary(2000).setGrade(2));
    }
}
