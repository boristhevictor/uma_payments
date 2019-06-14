package com.borysp.payments.uma.app.service.crud;

import com.borysp.payments.uma.app.model.Employee;

public interface CRUDEntityService<E, K> {

    E fetch(Integer id);

    E save(Employee employee);

    E update(Employee employee);

    /*Experiment with a fluent service for removal chaining*/
    CRUDEntityService<E, K> delete(Integer id);

}
