package com.dolnikova.Lab3.exception.handler;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolnikova.Lab3.exception.PasswordsDoNotMatch;
import com.dolnikova.Lab3.exception.UserAlreadyExists;
import com.dolnikova.Lab3.exception.UserNotFoundException;
import com.dolnikova.Lab3.util.Constants;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserAlreadyExists.class, PasswordsDoNotMatch.class})
    public final ModelAndView handleUserAlreadyExistsAndPasswordsDoNotMatch(Exception ex,
            RedirectAttributes redirectAttributes) {

        String errorMessage = ex.getMessage();
        log.warn(errorMessage);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setStatus(HttpStatus.UNAUTHORIZED);
        redirectAttributes.addFlashAttribute("error", errorMessage);
        modelAndView.setViewName("redirect:/registration");
        return modelAndView;
    }

    @ExceptionHandler({UserNotFoundException.class})
    public final ModelAndView handleUserNotFoundException(Exception ex, RedirectAttributes redirectAttributes) {
        String errorMessage = ex.getMessage();
        log.warn(errorMessage);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setStatus(HttpStatus.UNAUTHORIZED);
        redirectAttributes.addFlashAttribute("error", Constants.CANNOT_AUTHENTICATE_USER);
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }

}
