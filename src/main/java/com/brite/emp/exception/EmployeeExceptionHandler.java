package com.brite.emp.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.sql.SQLException;

@ControllerAdvice
public class EmployeeExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeExceptionHandler.class);


    @ExceptionHandler(SQLException.class)
    public @ResponseBody ErrorReponse handleSQLException(HttpServletRequest request, Exception ex){
        logger.info("SQLException Occurred:: URL="+request.getRequestURL());
        ErrorReponse errorReponse = new ErrorReponse();
        errorReponse.setErrorcode(HttpStatus.NOT_FOUND);
        errorReponse.setErrormessage(ex.getMessage());
        return errorReponse;
    }

    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occurred")
    @ExceptionHandler(IOException.class)
    public void handleIOException(){
        logger.error("IOException handler executed");
        //returning 404 error code
    }


}
