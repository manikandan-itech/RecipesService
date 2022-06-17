package com.mycode.recipesservice.app;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
import static org.springframework.http.ResponseEntity.status;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.mycode.recipesservice.core.exceptions.RecipeDataNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class RestControllerExceptionHandlerConfiguration {

    private static final String EXCEPTION_TEXT =
            "There is an error while processing request. please contact support team.";

    @ExceptionHandler(HttpServerErrorException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    ResponseEntity<String> httpServerErrorException(HttpServerErrorException e) {
        return internalServerError(e);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(BAD_REQUEST)
    ResponseEntity<String> httpMessageNotReadableException(HttpMessageNotReadableException e) {
        return badRequest(e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(UNPROCESSABLE_ENTITY)
    ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return returnUnprocessableEntity(e);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    ResponseEntity<String> throwable(Throwable e) {
        return internalServerError(e);
    }

    @ExceptionHandler(RecipeDataNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    ResponseEntity<String> deselectApplicantDocumentException(RecipeDataNotFoundException e) {
        return badRequest(e);
    }

    private ResponseEntity<String> internalServerError(Throwable e) {
        return ResponseEntity.internalServerError().body(error(e));
    }

    private ResponseEntity<String> badRequest(Exception e) {
        return ResponseEntity.badRequest().body(error(e));
    }

    private ResponseEntity<String> returnUnprocessableEntity(MethodArgumentNotValidException e) {
        return ResponseEntity.unprocessableEntity().body(error(e));
    }

    private static String error(Throwable throwable) {
        log.error(throwable.getMessage(), throwable);
        return EXCEPTION_TEXT;
    }
}
