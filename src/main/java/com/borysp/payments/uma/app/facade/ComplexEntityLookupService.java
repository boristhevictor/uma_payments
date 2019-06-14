package com.borysp.payments.uma.app.facade;

import java.util.List;
import java.util.function.Function;

public interface ComplexEntityLookupService<E, M, R> {

    /** Simple query will translate path parameters:
     *
     *  ?param1=X,Y&param2=B into: select E where (param1=X or param1=Y) and param2=B
     *
     * @param mapper is used to provide a mapped result
     *
     * @return List<R> mapped by mapper
     * */
    List<R> findBySimpleQuery(M simpleQuery, Function<? super E, R> mapper);
    
    List<E> findBySimpleQuery(M simpleQuery);
    
}
