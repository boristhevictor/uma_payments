package com.borysp.payments.uma.app.repository.criteriaSupporting;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class CriteriaSupportingAbstractRepository<E> implements CriteriaSupportingRepository<E> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<? extends E> findWithCriteria(Map<String, Set<String>> paramsMap) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<? extends E> query = criteriaBuilder.createQuery(getEntityClass());
        Root<? extends E> root = query.from(getEntityClass());
        Predicate[] allCriteriaPredicates = preparePredicates(paramsMap, criteriaBuilder, root);
        query.where(allCriteriaPredicates);
        return entityManager.createQuery(query).getResultList();
    }

    private Predicate[] preparePredicates(Map<String, Set<String>> paramsMap, CriteriaBuilder criteriaBuilder, Root<? extends E> root) {
        return paramsMap.entrySet()
            .stream()
            .map(criterion -> prepareBounds(criteriaBuilder, root.get(criterion.getKey()), criterion.getValue()))
            .toArray(Predicate[]::new);
    }

    private Predicate prepareBounds(CriteriaBuilder criteriaBuilder, Path<E> path, Set<String> bounds) {
        return criteriaBuilder.or(bounds.stream()
                .map(b -> criteriaBuilder.equal(path, b))
                .toArray(Predicate[]::new));
    }

    protected abstract Class<? extends E> getEntityClass();

}
