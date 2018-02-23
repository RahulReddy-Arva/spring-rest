package com.rahul.repository;

import com.rahul.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


// Repository layer is used to communnicate with the database and get the data for the service layer to work with.

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    public List<Employee> findAll() {
        Employee e1 = new Employee();
        e1.setEmail("rarva@uncc.edu");
        e1.setFirstname("Rahul Reddy");
        e1.setLastname("Arva");

        Employee e2 = new Employee();
        e2.setEmail("aviswan2@uncc.edu");
        e2.setFirstname("Aditya");
        e2.setLastname("Viswanadha");

        return Arrays.asList(e1,e2);
    }

    public Employee findOne(String id) {
        Employee e1 = new Employee();
        e1.setEmail("rarva@uncc.edu");
        e1.setFirstname("Rahul Reddy");
        e1.setLastname("Arva");

        return e1;
    }

    public Employee findByEmail(String email) {
        return null;
    }

    public Employee create(Employee emp) {
        return null;
    }

    public Employee update(Employee emp) {
        return null;
    }

    public void delete(Employee emp) {

    }

}
