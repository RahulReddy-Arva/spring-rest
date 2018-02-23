package com.rahul.controller;

import com.rahul.entity.Employee;
import com.rahul.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// It should just implement the end points and not the business logic.
// Business logic is implemented by the service layer.


// Instead of using both controller and responsebody we can directly use RestController.
@RestController
//@Controller //Controller is nothing but a component. It is used for readability and is used spring-mvc.
//@ResponseBody // This is needed just to tell spring to write the data directly to the response instead of looking for the view template. Write the obtained data into response in json format and send it to client.
@RequestMapping( value = "/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @RequestMapping (method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public List<Employee> findAll() {
        return service.findAll();
    }

    @RequestMapping (method = RequestMethod.GET , value = "/{id}" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public Employee findOne(@PathVariable("id") String empId) {
        return service.findOne(empId);
    }

    @RequestMapping (method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE , produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public Employee create(@RequestBody Employee emp ) {
        return service.create(emp);
    }

    @RequestMapping (method = RequestMethod.PUT , value = "/{id}" , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE , produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public Employee update(@PathVariable("id") String empId, @RequestBody Employee emp) {
        return service.update(empId, emp);
    }

    @RequestMapping (method = RequestMethod.DELETE , value = "/{id}")
    public void delete(@PathVariable("id") String empId) {
        service.delete(empId);
    }

}
