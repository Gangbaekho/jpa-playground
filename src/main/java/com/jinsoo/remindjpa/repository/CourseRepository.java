package com.jinsoo.remindjpa.repository;

import com.jinsoo.remindjpa.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Object> findAllWithCommonQuery(){

        Query query = entityManager.createQuery("select c from Course c");
        List courseList = query.getResultList();
        return courseList;
    }

    public List<Course> findAllWithTypedQuery(){

        TypedQuery<Course> typedQuery = entityManager.createQuery("select c from Course c", Course.class);
        List<Course> courseList = typedQuery.getResultList();
        return courseList;
    }

    public List<Course> findAll_where(){

        TypedQuery<Course> typedQuery = entityManager.createQuery("select c from Course c where c.courseName like '%two'", Course.class);
        List<Course> courseList = typedQuery.getResultList();

        return courseList;
    }

    public List<Course> findAllCourseStartsWithDummy(){
        TypedQuery<Course> query = entityManager.createNamedQuery("all_course_starts_with_dummy",Course.class);
        List<Course> result = query.getResultList();
        return result;
    }

    public List<Course> findAllCourseContainsSpecial(){
        TypedQuery<Course> query = entityManager.createNamedQuery("all_course_contains_special",Course.class);
        List<Course> result = query.getResultList();
        return result;
    }

    public void saveCourse(Course course){

        if(Objects.isNull(course.getId())){
            entityManager.persist(course);
        }else{
            entityManager.merge(course);
        }
    }

}
