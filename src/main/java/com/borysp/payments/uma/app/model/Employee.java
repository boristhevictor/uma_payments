package com.borysp.payments.uma.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@Entity
@Data
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

    private Integer id;
    private int grade;
    private int salary;
    @NonNull private String name;
    @NonNull private String surname;

}
