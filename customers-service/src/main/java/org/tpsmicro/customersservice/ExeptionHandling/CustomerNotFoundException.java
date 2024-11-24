package org.tpsmicro.customersservice.ExeptionHandling;

/**
 * @author lamaachi
 **/
public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
