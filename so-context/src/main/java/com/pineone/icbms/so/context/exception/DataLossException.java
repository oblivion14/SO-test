package com.pineone.icbms.so.context.exception;

/**
 * Created by melvin on 2016. 7. 13..
 */
public class DataLossException extends Exception {

    public DataLossException(){
        super("Important Data Loss Exception");
    }

    public DataLossException(String message){
        super(message);
    }
}
