package com.rahul.service;

import com.rahul.entity.Employee;
import com.rahul.exception.BadRequestException;
import com.rahul.exception.ResourceNotFoundException;
import com.rahul.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


//Service is only responsible for Business Logic and exception handling and nothing more.
// It shouldnt handle database connectivity and more. It shouldnt be over burdened.

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee findOne(String id) {
        Employee existing =  repository.findOne(id);
        if ( existing == null){
            // exception handling 404
            throw new ResourceNotFoundException("Employee with id " + id + "doesn't exist.");

        }
        return existing;
    }

    @Transactional
    public Employee create(Employee emp) {
        Employee existing = repository.findByEmail(emp.getEmail());
        if (existing != null ){
            // exception handling, 400 Bad Request
            throw new BadRequestException("Employee with email id " + emp.getEmail() + "already exists.");
        }
        return repository.create(emp);
    }

    @Transactional
    public Employee update(String id, Employee emp) {
        Employee existing = repository.findOne(id);
        if ( existing == null ){
            // exception handling 404
            throw new ResourceNotFoundException("Employee with id " + id + "doesn't exist.");
        }
        return repository.update(emp);
    }

    @Transactional
    public void delete(String id) {
        Employee existing = repository.findOne(id);
        if ( existing == null ) {
            // exception handling 404
            throw new ResourceNotFoundException("Employee with id " + id + "doesn't exist.");
        }
        repository.delete(existing);

    }
}
