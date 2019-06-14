package com.borysp.payments.uma.app.controller.employee.lookup;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeLookupParamsModel {

    List<String> id;
    List<String> grade;
    List<String> salary;
    List<String> surname;
    List<String> name;
}
