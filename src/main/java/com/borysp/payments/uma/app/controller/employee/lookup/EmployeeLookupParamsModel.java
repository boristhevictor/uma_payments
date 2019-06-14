package com.borysp.payments.uma.app.controller.employee.lookup;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.util.Pair;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
public class EmployeeLookupParamsModel {

    Set<String> id;
    Set<String> grade;
    Set<String> salary;
    Set<String> surname;
    Set<String> name;

    public Map<String, Set<String>> asMap() {
        return Stream.of(
            Pair.of("id", id),
            Pair.of("grade", grade),
            Pair.of("salary", salary),
            Pair.of("surname", surname),
            Pair.of("name", name))
        .collect(Collectors.toMap(Pair::getFirst, Pair::getSecond));

    }
}
