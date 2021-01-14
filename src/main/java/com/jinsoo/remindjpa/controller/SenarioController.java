package com.jinsoo.remindjpa.controller;

import com.jinsoo.remindjpa.model.Course;
import com.jinsoo.remindjpa.model.PassPort;
import com.jinsoo.remindjpa.model.Review;
import com.jinsoo.remindjpa.model.Student;
import com.jinsoo.remindjpa.repository.CourseRepository;
import com.jinsoo.remindjpa.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@RestController
@Transactional
public class SenarioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SenarioController.class);

    @Autowired
    private EntityManager em;

//    아래의 테스트들로 인해서, Review에서 Course를 저정해야지
//    올바르게 foreign key들이 잘 저장되는 것을 확인하였음.
//    그럼 애초에 Course에다가 addReview라는 method를 왜 만든거지.
//    어짜피 안먹히잖아. 그건 좀 더 알아봐야겠다.

    @GetMapping("/test33")
    public void oneToManyTestOne(){

        Course course = new Course();
        course.setCourseName("dummy course name");
        em.persist(course);

        Review review = new Review();
        review.setCourse(course);
        review.setContent("dummy content");
        em.persist(review);

    }

    @GetMapping("test44")
    public void oneToManyTestTwo(){

        Review review = new Review();
        review.setContent("dummy content test 2");
        em.persist(review);

        Course course = new Course();
        course.setCourseName("dummy course name 2");
        course.addReview(review);
        em.persist(course);
    }

    @GetMapping("/test55")
    public void oneToManyTestThree(){

        Course course = em.find(Course.class,1L);
        LOGGER.info("course ==> {}",course);
    }

    @GetMapping("/test66")
    public void manyToManyTestInsertTest(){

        PassPort passPort = new PassPort();
        passPort.setPassPortId("RANDOM123");
        em.persist(passPort);

        Course course = new Course();
        course.setCourseName("dummy course name");
        em.persist(course);

        Student student = new Student();
        student.setStudentName("dummy student name");
        student.setPassPort(passPort);
        student.addCourse(course);
        em.persist(student);

    }

}
