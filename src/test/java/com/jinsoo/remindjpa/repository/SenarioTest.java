package com.jinsoo.remindjpa.repository;

import com.jinsoo.remindjpa.model.PassPort;
import com.jinsoo.remindjpa.model.Student;
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
public class SenarioTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SenarioTest.class);

    @Autowired
    private EntityManager entityManager;

    @Test
    @DirtiesContext
    public void insertStudentWithPassPort(){

        PassPort passPort = new PassPort();
        passPort.setPassPortId("NN103");
        entityManager.persist(passPort);

        Student student = new Student();
        student.setStudentName("dummyStudent");
        student.setPassPort(passPort);
        entityManager.persist(student);


        Student selectedStudent = entityManager.find(Student.class,1L);
        LOGGER.info("selectedStudent ==> {}", selectedStudent);
    }

    @Test
    @DirtiesContext
    public void mappedByTest(){

        PassPort passPort = new PassPort();
        passPort.setPassPortId("NN103");
        entityManager.persist(passPort);

        Student student = new Student();
        student.setStudentName("dummyStudent");
        student.setPassPort(passPort);
        entityManager.persist(student);

        entityManager.flush();

        PassPort selectedPassPort = entityManager.find(PassPort.class,1L);
        LOGGER.info("selectedPassPort ==> {}", selectedPassPort);
        LOGGER.info("Student related with this pass port ==> {}",selectedPassPort.getStudent());

    }
}
