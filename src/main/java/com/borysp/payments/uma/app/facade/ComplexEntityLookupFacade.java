package com.borysp.payments.uma.app.facade;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public interface ComplexEntityLookupFacade<E, M, R> {


    /** Composite query will translate a collection of the simple path query parameters:
     *
     *  {  "param1=X,Y&param2=B", "param1=H&param2=B,A" }
     *
     *  into:
     *
     *  select E where
     *    ((param1=X or param1=Y) and param2=B)
     *    OR
     *    (param1=H  and (param2=B or param2=A))
     *
     * @param mapper is used to provide a mapped result
     *
     * @return List<R> mapped by mapper
     * */
    List<R> findByCompositeQuery(Collection<M> compositeQuery, Function<? super E, R> mapper);

    List<E> findByCompositeQuery(Collection<M> compositeQuery);

    /** Simple query will translate path parameters:
     *
     *  ?param1=X,Y&param2=B into: select E where (param1=X or param1=Y) and param2=B
     *
     * @param mapper is used to provide a mapped result
     *
     * @return List<R> mapped by mapper
     * */
    List<R> findBySimpleQuery(Collection<M> simpleQuery, Function<? super E, R> mapper);
    
    List<E> findBySimpleQuery(Collection<M> simpleQuery);
    
}
