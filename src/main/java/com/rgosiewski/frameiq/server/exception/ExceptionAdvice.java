package com.rgosiewski.frameiq.server.exception;

import com.rgosiewski.frameiq.repository.exception.NewRepositoryDirectoryException;
import com.rgosiewski.frameiq.repository.exception.NewRepositoryFileException;
import com.rgosiewski.frameiq.server.application.security.exception.SecuredAccessException;
import com.rgosiewski.frameiq.server.common.exception.ExceptionResponse;
import com.rgosiewski.frameiq.server.common.exception.MultiDetailException;
import com.rgosiewski.frameiq.server.common.exception.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionAdvice {
    private static final Logger logger = LogManager.getLogger(ExceptionAdvice.class);

    @ExceptionHandler({MissingServletRequestParameterException.class,
            ValidationException.class
    })
    public ResponseEntity<ExceptionResponse> handleBadRequestCauses(Exception exception) {
        return resolveResponse(exception, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler()
//    public ResponseEntity<ExceptionResponse> handleBadRequestMultiDetailsCauses(MultiDetailException exception) {
//        return resolveResponse(exception, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler()
//    public ResponseEntity<ExceptionResponse> handleNotFoundCauses(Exception exception) {
//        return resolveResponse(exception, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler({ NewRepositoryDirectoryException.class,
            NewRepositoryFileException.class })
    public ResponseEntity<ExceptionResponse> handleInternalCauses(Exception exception) {
        return resolveResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }
//
//    @ExceptionHandler()
//    public ResponseEntity<ExceptionResponse> handleInternalMultiDetailsCauses(MultiDetailException exception) {
//        return resolveResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleServerCauses(Exception exception) {
        return resolveResponse("Server error response", "Try again or contact the development team", exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SecuredAccessException.class)
    public ResponseEntity<ExceptionResponse> handleNotAuthorizedCauses(SecuredAccessException exception) {
        return resolveResponse(exception, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleSpringValidationException(MethodArgumentNotValidException exception) {
        String description = exception.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(" "));

        return resolveResponse("Validation exception", description, exception, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ExceptionResponse> resolveResponse(Exception exception, HttpStatus httpStatus) {
        logger.error("Exception caught", exception);
        return ResponseEntity.status(httpStatus).body(new ExceptionResponse(httpStatus, exception));
    }

    private ResponseEntity<ExceptionResponse> resolveResponse(String message, String description, Exception exception, HttpStatus httpStatus) {
        logger.error("Exception caught", exception);
        return ResponseEntity.status(httpStatus).body(new ExceptionResponse(httpStatus, message, description, exception));
    }

    private ResponseEntity<ExceptionResponse> resolveResponse3(MultiDetailException exception, HttpStatus httpStatus) {
        logger.error("Exception caught", exception);
        return ResponseEntity.status(httpStatus).body(new ExceptionResponse(httpStatus, exception.getMessage(), exception.getDetails()));
    }
}
