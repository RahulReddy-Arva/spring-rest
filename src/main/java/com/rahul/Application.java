package com.rahul;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan
public class Application {

}

//EnableWebMVC : this makes sure that all the components requires for web are initialised like http sessions, request , response.
// The above annotation is must for all spring-mvc projects.