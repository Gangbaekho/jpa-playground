package com.jinsoo.remindjpa.repository;

import com.jinsoo.remindjpa.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll(){

        TypedQuery<User> namedQuery = entityManager.createNamedQuery("find_all_users",User.class);
        return namedQuery.getResultList();
    }
}
