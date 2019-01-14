package com.ruangong.work.Repository.common;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

public class SimpleGeneralRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements GeneralRepository<T, ID> {

    private final EntityManager entityManager;

    public SimpleGeneralRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.entityManager = entityManager;
    }

    public SimpleGeneralRepository(Class<T> domainClass, EntityManager em, EntityManager entityManager) {
        super(domainClass, em);
        this.entityManager = entityManager;
    }

    private SessionFactory getSessionFactory(){
        SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
        return sessionFactory;
    }

    private Session getSession(){
        Session session = entityManager.unwrap(Session.class);
        return session;
    }

//    @Override
//    public List<Map<String, Object>> findThroughHql(String hql, int firstResult, int maxResults, Map<String, Object> valuesMap) {
//        Query query = createQuery(hql, firstResult, maxResults, valuesMap);
//
//        List<Map<String, Object>> dataList = null;
//
//        if (query != null) {
//            dataList = query.list();
//        }
//
//        return dataList;
//    }


    protected Query createQuery(String hql, int firstResult, int maxResults, Map<String, Object> valuesMap) {
        if (StringUtils.isBlank(hql)) {
            return null;
        }

        Query query = getSession().createQuery(hql);

        if (!valuesMap.isEmpty()) {
            for (Map.Entry<String, Object> entry : valuesMap.entrySet()) {
                String name = entry.getKey();
                Object value = entry.getValue();

                if (value instanceof Collection) {// 集合
                    query.setParameterList(name, (Collection) value);
                } else if (value instanceof Object[]) {// 数组
                    query.setParameterList(name, (Object[]) value);
                } else {
                    query.setParameter(name, value);
                }

            }
        }

        if (firstResult >= 0) {
            query.setFirstResult(firstResult);
        }

        if (maxResults >= 0) {
            query.setMaxResults(maxResults);
        }

        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);



        return query;
    }


}
