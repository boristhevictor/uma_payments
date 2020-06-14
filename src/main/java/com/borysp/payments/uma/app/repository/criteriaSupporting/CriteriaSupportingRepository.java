package com.borysp.payments.uma.app.repository.criteriaSupporting;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CriteriaSupportingRepository<E> {

    List<? extends E> findWithCriteria(Map<String, Set<String>> paramsMap);

}
