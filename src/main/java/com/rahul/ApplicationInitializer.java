package com.rahul;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


// This class deals with all the requests and then redirects them to their specific controller and sends data response back to client.
// It is class interacting with the client.
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        // This is used to specify the configurations classes in our application.
        return new Class[]{Application.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    protected String[] getServletMappings() {
        // this is used to tell the server that we only care about requests that have /api/ as prefix.
        return new String[]{"/api/*"};
    }
}
