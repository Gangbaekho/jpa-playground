package com.jinsoo.remindjpa.repository;

import com.jinsoo.remindjpa.model.Course;
import com.jinsoo.remindjpa.model.Review;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class OnetoManyTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnetoManyTests.class);

    @Autowired
    private EntityManager entityManager;

    @Test
    @DirtiesContext
    public void insertWithCourse(){

        Review review = new Review();
        review.setContent("dummy content");
        entityManager.persist(review);

        Course course = new Course();
        course.setCourseName("dummy course name");
        course.addReview(review);
        entityManager.persist(course);

        entityManager.flush();

        Course selectedCourse = entityManager.find(Course.class,1L);
        LOGGER.info("selected course ==> {}", selectedCourse);
    }

    @Test
    @DirtiesContext
    public void insertWithReview(){

        Course course = new Course();
        course.setCourseName("dummy course name");
        entityManager.persist(course);

        Review review = new Review();
        review.setContent("dummy content");
        review.setCourse(course);
        entityManager.persist(review);

        entityManager.flush();

        Course selectedCourse = entityManager.find(Course.class,1L);
        LOGGER.info("selected course ==> {}",selectedCourse);
    }

}
