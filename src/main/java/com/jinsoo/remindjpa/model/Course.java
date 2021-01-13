package com.jinsoo.remindjpa.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@NamedQueries(value = {
        @NamedQuery(name="all_course_starts_with_dummy", query="select c from Course c where c.courseName like 'dummy%'"),
        @NamedQuery(name="all_course_contains_special", query="select c from Course c where c.courseName like '%special%'")
})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;

//    update가 될 때 마다 자동 갱신 해줄 수 있도록
//    만드는 그런 Annotation이라고 생각하면 된다.
    @UpdateTimestamp
    private LocalDateTime updatedDateTime;

//    creation이 될 떄 자동으로
//    LocalDateTime을 찍어주는 그런 Annotation.
//    이런것들을 위해서 굳이 update query를 사용하지 않아도
//    되는게 장점이 되겠군.
    @CreationTimestamp
    private LocalDateTime createdDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", updatedDateTime=" + updatedDateTime +
                ", createdDateTime=" + createdDateTime +
                '}';
    }
}
