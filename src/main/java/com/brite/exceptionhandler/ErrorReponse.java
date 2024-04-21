package com.brite.exceptionhandler;

import org.springframework.http.HttpStatus;

public class ErrorReponse {

    private HttpStatus errorcode ;
    private  String  errormessage ;

    public HttpStatus getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(HttpStatus errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }
}
