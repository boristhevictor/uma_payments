package com.borysp.payments.uma.app.controller.employee.lookup;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@Getter
@Setter
public class EmployeeLookupParamsModel {

    private Set<String> id;
    private Set<String> grade;
    private Set<String> salary;
    private Set<String> surname;
    private Set<String> name;

    public Map<String, Set<String>> asMap() {
        Map<String, Set<String>> result = new HashMap<>();
        Stream.of(
            param("id", id),
            param("grade", grade),
            param("salary", salary),
            param("surname", surname),
            param("name", name))
        .filter(p -> p.getSecond().isPresent() && p.getSecond().get().size() > 0)
        .forEach(p -> result.put(p.getFirst(), p.getSecond().get()));
        return result;
    }

    private Pair<String, Optional<Set<String>>> param(String criterion, Set<String> bounds) {
        return Pair.of(criterion, Optional.ofNullable(bounds));
    }

    public boolean shouldLookup() {
        return asMap().size() > 0;
    }

}
