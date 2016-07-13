package com.pineone.icbms.so.context.external.itf.user;

import com.pineone.icbms.so.context.GeneralContext;

/**
 * Created by melvin on 2016. 7. 13..
 */
public class ResponseMessageToUser {

    private String exceptionMessage;
    private String message;

    public static ResponseMessageToUser newResponseMessage(){
        ResponseMessageToUser responseMessage = new ResponseMessageToUser();
        return responseMessage;
    }


    public String generalContextResultMessage(GeneralContext generalContext){
        message = "Name : " + generalContext.getName() + " Virtual Object : " + generalContext.getDeviceObject()
                + " Concept Service" + generalContext.getConceptService() +
                " Minimum Value : " + generalContext.getMinValue() + " Maximum Value : " + generalContext.getMaxValue();
        return message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
