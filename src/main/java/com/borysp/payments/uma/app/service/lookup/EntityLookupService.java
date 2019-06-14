package com.borysp.payments.uma.app.service.lookup;

import com.borysp.payments.uma.app.model.Employee;

import java.util.List;
import java.util.function.Function;

/** Marker service interface for Employee lookups via EmployeeLookupParamsModel*/
public interface EntityLookupService<E, M, R> {

    /** Path query lookup translates path parameters:
     *
     *  ?param1=X,Y&param2=B into: select E where (param1=X or param1=Y) and param2=B
     *
     * @param mapper is used to provide a mapped result
     * @return List<R> mapped by mapper
     * */
    List<R> findByPathQuery(M simpleQuery, Function<? super E, R> mapper);
    
    List<? extends Employee> findByPathQuery(M simpleQuery);
    
}
