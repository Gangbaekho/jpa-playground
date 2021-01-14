package com.jinsoo.remindjpa.repository;

import com.jinsoo.remindjpa.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Objects;

@Repository
@Transactional
public class ReviewRepository {

    @Autowired
    private EntityManager entityManager;

    public void saveReview(Review review){
        if(Objects.isNull(review.getId())){
            entityManager.persist(review);
        }else {
            entityManager.merge(review);
        }
    }
}
