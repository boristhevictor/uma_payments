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
        employeeCRUDService.save(new Employee("Mike", "Myers")).setSalary(3000).setGrade(2);
        employeeCRUDService.save(new Employee("Alfred", "Molina")).setSalary(10000).setGrade(4);
        employeeCRUDService.save(new Employee("Walter", "White")).setSalary(120000).setGrade(1);
        employeeCRUDService.save(new Employee("Hodor", "Hodor").setSalary(10000).setGrade(5));
        employeeCRUDService.save(new Employee("Lieb", "Shreider").setSalary(20000).setGrade(10));
        employeeCRUDService.save(new Employee("Arthur", "Doyle").setSalary(2000).setGrade(2));
        employeeCRUDService.save(new Employee("Johny", "Mnemonic").setGrade(11).setSalary(10000));
        employeeCRUDService.save(new Employee("Natalie", "Kidman")).setGrade(11).setSalary(20000);
        employeeCRUDService.save(new Employee("Michelle", "Hepburn").setGrade(5).setSalary(10000));
        employeeCRUDService.save(new Employee("Jane", "Krakowski").setSalary(2000).setGrade(2));
        employeeCRUDService.save(new Employee("Red", "Foreman").setSalary(4000).setGrade(3));
        employeeCRUDService.save(new Employee("Mina", "Hakinnen").setSalary(5000).setGrade(4));
    }
}
