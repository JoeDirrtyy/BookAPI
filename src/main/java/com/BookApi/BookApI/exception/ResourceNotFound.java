package com.BookApi.BookApI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceNotFound {


    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException() {
            super();
        }

        public ResourceNotFoundException(String message) {
            super(message);
        }

        public ResourceNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
