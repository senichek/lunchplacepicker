package com.olexiy.lunchplacepicker.utils.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {

    //When validation fails it triggers an exception. The methods marked by @ExceptionHandler will handle the exception.

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, ConstraintViolationException cEx) throws Exception {
        return logAndGetExceptionView(req, cEx, true, null);
    }

    private ModelAndView logAndGetExceptionView(HttpServletRequest req, ConstraintViolationException e, boolean logException, String code) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        String errorMessage = "";
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation c : constraintViolations) {
            errorMessage = c.getPropertyPath().toString() + " " + c.getMessage();
            errors.add(errorMessage);
        }
        log.info(errors.toString());

        /*The content of the exception.jsp is available via the ".done" part of ajax call,
        see "saveUser" function in "lunchplacepicker.admin.js" file for reference.*/
        ModelAndView mav = new ModelAndView("exception", Map.of("errorMessages", errors));
        return mav;
    }
}