package com.meloafc.meeting.config;

import com.meloafc.meeting.exception.BaseException;
import com.meloafc.meeting.exception.NotFoundException;
import com.meloafc.meeting.exception.RestErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String UNEXPECTED_ERROR = "app.unexpectedError";

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private final MessageSource messageSource;

    @Autowired
    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<RestErrorMessage> handleNotFoundException(NotFoundException ex, Locale locale) {
        logInfo(ex);
        return getRestErrorMessageResponseEntity(locale, ex.getMessage(), ex.getArgs(), HttpStatus.NOT_FOUND, ex);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<RestErrorMessage> handleIllegalArgument(BaseException ex, Locale locale) {
        logInfo(ex);
        return getRestErrorMessageResponseEntity(locale, ex.getMessage(), ex.getArgs(), HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestErrorMessage> handleExceptions(Exception ex, Locale locale) {
        logError(ex);
        return getRestErrorMessageResponseEntity(locale, UNEXPECTED_ERROR, new String[]{ex.getMessage()}, HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    private ResponseEntity<RestErrorMessage> getRestErrorMessageResponseEntity(Locale locale, String message, String[] args, HttpStatus httpStatus, Exception ex) {
        String errorMessage = "";
        if (message != null) {
            errorMessage = messageSource.getMessage(message, args, message, locale);
        }
        return new ResponseEntity<>(new RestErrorMessage(errorMessage, ex), httpStatus);
    }

    private void logError(Exception ex) {
        if (log.isErrorEnabled()) {
            log.error(ex.getMessage(), ex);
        }
    }

    private void logInfo(Exception ex) {
        if (log.isInfoEnabled()) {
            log.info(ex.getMessage(), ex);
        }
    }
}
