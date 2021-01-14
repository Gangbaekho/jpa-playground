package com.jinsoo.remindjpa.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentName;

//    Owning side를 student가 가지고 있다.
//    그렇기 때문에 Student table에 pass_port_id라는
//    column이 새로 생긴걸로 보면 된다.
    @OneToOne
    private PassPort passPort;

    @ManyToMany
    @JoinTable(name="STUDENT_COURSE",
    joinColumns = @JoinColumn(name="STUDENT_ID"), inverseJoinColumns = @JoinColumn(name="COURSE_ID"))
    private List<Course> courseList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public PassPort getPassPort() {
        return passPort;
    }

    public void setPassPort(PassPort passPort) {
        this.passPort = passPort;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void addCourse(Course course) {
        this.courseList.add(course);
    }

    public void removeCourse(Course course){
        this.courseList.remove(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
