package com.jinsoo.remindjpa.repository;

import com.jinsoo.remindjpa.model.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

@SpringBootTest
public class CourseRepositoryTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseRepositoryTests.class);

    @Autowired
    private CourseRepository courseRepository;

    @Test
    @DirtiesContext
    public void findAllCourseTestWithCommonQuery(){

        Course courseOne = new Course();
        courseOne.setCourseName("course one");
        courseRepository.saveCourse(courseOne);

        Course courseTwo = new Course();
        courseTwo.setCourseName("course two");
        courseRepository.saveCourse(courseTwo);

        List<Object> courseList = courseRepository.findAllWithCommonQuery();
        LOGGER.info("courseList ==> {}",courseList);
    }

    @Test
    @DirtiesContext
    public void findAllCourseTestWithTypedQuery(){

        Course courseOne = new Course();
        courseOne.setCourseName("course one");
        courseRepository.saveCourse(courseOne);

        Course courseTwo = new Course();
        courseTwo.setCourseName("course two");
        courseRepository.saveCourse(courseTwo);

        List<Course> courseList = courseRepository.findAllWithTypedQuery();
        LOGGER.info("courseList ==> {}",courseList);
    }

    @Test
    @DirtiesContext
    public void findAllCoursesContainsTwoWord(){

        Course courseOne = new Course();
        courseOne.setCourseName("course one");
        courseRepository.saveCourse(courseOne);

        Course courseTwo = new Course();
        courseTwo.setCourseName("course two");
        courseRepository.saveCourse(courseTwo);

        List<Course> courseList = courseRepository.findAll_where();
        LOGGER.info("courseList ==> {}",courseList);
    }

    @Test
    @DirtiesContext
    public void updateTimeStampAndCreationTimeStampCheck(){

        Course courseOne = new Course();
        courseOne.setCourseName("course one");
        courseRepository.saveCourse(courseOne);

        Course courseTwo = new Course();
        courseTwo.setCourseName("course two");
        courseRepository.saveCourse(courseTwo);

        List<Course> courseList = courseRepository.findAll_where();
        LOGGER.info("courseList ==> {}",courseList);
    }


}
