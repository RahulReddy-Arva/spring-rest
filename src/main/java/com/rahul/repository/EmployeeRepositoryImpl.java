package com.rahul.repository;

import com.rahul.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


// Repository layer is used to communicate with the database and get the data for the service layer to work with.

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    // Instead of injecting Entity manager factory and using createEntityManager(), spring directly provides us with Entity Manager
    // using @persistenceContext.

    @PersistenceContext
    private EntityManager entityManager;


    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findAll",
                                                               Employee.class);
        return query.getResultList();
    }

    public Employee findOne(String id) {
        return entityManager.find(Employee.class,id);
    }

    public Employee findByEmail(String email) {
        TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findByEmail",
                Employee.class);
        query.setParameter("paramEmail",email);
        List<Employee> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1 ){
            return resultList.get(0);
        }
        else {
            return null;
        }
    }


    public Employee create(Employee emp) {
        entityManager.persist(emp);
        return emp;
    }

    public Employee update(Employee emp) {
        return entityManager.merge(emp);
    }

    public void delete(Employee emp) {
        entityManager.remove(emp);
    }

}
