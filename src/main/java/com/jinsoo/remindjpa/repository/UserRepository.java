package com.jinsoo.remindjpa.repository;

import com.jinsoo.remindjpa.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll(){

        TypedQuery<User> namedQuery = entityManager.createNamedQuery("find_all_users",User.class);
        return namedQuery.getResultList();
    }

    public User findById(Long id){

        User user = entityManager.find(User.class,id);
        return user;
    }

    public void insertUser(User user){

        if(Objects.isNull(user.getId())) {
            entityManager.persist(user);
        }else{
            entityManager.merge(user);
        }
    }
}
