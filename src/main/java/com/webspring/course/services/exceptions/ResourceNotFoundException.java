package com.webspring.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Resource not Found. id: "+id);

    }
}
