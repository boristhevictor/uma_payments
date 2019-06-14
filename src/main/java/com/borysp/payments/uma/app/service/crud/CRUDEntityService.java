package com.borysp.payments.uma.app.service.crud;

import com.borysp.payments.uma.app.model.Employee;

public interface CRUDEntityService<E, K> {

    E fetch(Integer id);

    E save(Employee employee);

    /*Update method could be used for propagating properties from a detached entity*/
    E update(Integer id, Employee employee);

    /*Experiment with a fluent service for removal chaining*/
    CRUDEntityService<E, K> delete(Integer id);

}
