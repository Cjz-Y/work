package com.ruangong.work.Repository;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

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


}
