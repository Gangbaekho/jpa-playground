package com.jinsoo.remindjpa.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table
@NamedQuery(name="find_all_users", query="select u from User u")
public class User {

    @Id
    //음 여기에 뭔가 있었는데 까먹었네.
    @GeneratedValue
    private Long id;
    private String userName;
    private String userPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
