package com.borysp.payments.uma.app.service.crud;

import com.borysp.payments.uma.app.model.Employee;

import java.util.Optional;

public interface CRUDEntityService<E, K> {

    /**@return Using an Optional so that we cover id not found**/
    Optional<Employee> fetch(Integer id);

    E save(Employee employee);

    /**Update method could be used for propagating properties from a detached entity
     * @return Optional empty when nothing was updated
     * */
    Optional<Employee> update(Integer id, Employee employee);

    /**Experiment with a fluent service for removal chaining*/
    CRUDEntityService<E, K> delete(Integer id);

}
