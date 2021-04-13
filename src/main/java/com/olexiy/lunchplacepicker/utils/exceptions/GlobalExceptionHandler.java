package com.olexiy.lunchplacepicker.utils.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    //When validation fails it triggers an exception. The methods marked by @ExceptionHandler will handle the exception.

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, ConstraintViolationException cEx) throws Exception {
        Set<ConstraintViolation<?>> constraintViolations = cEx.getConstraintViolations();
        String errorMessage = "";
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation c : constraintViolations) {
            errorMessage = "[" + c.getPropertyPath().toString() + " - " + c.getMessage() + "]";
            errors.add(errorMessage);
        }
        log.info(errors.toString());

        return logAndGetExceptionView(errors);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView dataIntegrityHandler(Exception e) throws Exception {
        List<String> errors = new ArrayList<>();
        if (e.getMessage().contains("unique_userlike_per_restaurant_idx") || e.getMessage().contains("unique_userlike_per_menu_idx")) {
            errors.add("Too late. You can remove your vote only before 11:00 AM");
            log.info(errors.toString());
            return logAndGetExceptionView(errors);
        }
        else {
            errors.add(e.getLocalizedMessage());
            log.info(errors.toString());
            return logAndGetExceptionView(errors);
        }
    }

    private ModelAndView logAndGetExceptionView(List<String> errors) {
        /*The content of the exception.jsp is available via the ".done" part of ajax call,
        see "saveUser" function in "lunchplacepicker.admin.js" file for reference.*/
        ModelAndView mav = new ModelAndView("exception", Map.of("errorMessages", errors));
        return mav;
    }
}