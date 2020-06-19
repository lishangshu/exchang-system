package com.fuxi.exception;

/**
 * ResourceNotFoundException
 */
public class ResourceNotFoundException extends ServiceException {

    public ResourceNotFoundException(String... args) {
        super("K-000003", args);
    }
}
