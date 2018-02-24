package com.rahul.entity;

import com.mysql.cj.api.mysqla.result.ColumnDefinition;

import javax.persistence.*;
import java.util.UUID;

// An entity tag represents that this value must be stored in database every time an instance is created for it.
// Every entity must have a primary Key in it which is represented by @Id tag.
@Entity
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "SELECT emp FROM Employee emp ORDER BY emp.email DESC"),
        @NamedQuery(name = "Employee.findByEmail", query = "SELECT emp FROM Employee emp WHERE emp.email=:paramEmail")
}
)
public class Employee {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;

    public Employee() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
