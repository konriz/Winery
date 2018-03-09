package com.wineyard.winery.controller;


import com.wineyard.winery.exceptions.NoItemException;
import com.wineyard.winery.tools.HTMLBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(NoItemException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String noItemError(NoItemException ex)
    {
        return HTMLBuilder.getNoWine();
    }

}
