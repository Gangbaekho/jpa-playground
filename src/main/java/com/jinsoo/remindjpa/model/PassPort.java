package com.jinsoo.remindjpa.model;

import javax.persistence.*;

@Entity
@Table
public class PassPort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passPortId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassPortId() {
        return passPortId;
    }

    public void setPassPortId(String passPortId) {
        this.passPortId = passPortId;
    }

    @Override
    public String toString() {
        return "PassPort{" +
                "id=" + id +
                ", passPortId='" + passPortId + '\'' +
                '}';
    }
}
