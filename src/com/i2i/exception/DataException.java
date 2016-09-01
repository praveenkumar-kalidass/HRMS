package com.i2i.exception;

import java.lang.Exception;

/**
 * <p>
 * DataException is used to create user Defined Exception
 * Throw the exception from services and dao's 
 * </p>
 *
 * @author Praveen RaJ
 *
 * @created 2016-09-01
 */

public class DataException extends Exception {
    /**
     * Handling message from the exception
     * 
     * @param message
     *      contains error message
     */
    public DataException(String message){
        super(message);
    }   
}
