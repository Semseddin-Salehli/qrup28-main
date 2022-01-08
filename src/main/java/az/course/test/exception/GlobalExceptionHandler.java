package az.course.test.exception;

import az.course.test.dto.response.ErrorResponse;
import az.course.test.enums.ExceptionCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handling(StudentNotFoundException exception, WebRequest request) {
        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .path(request.getContextPath())
                .message(exception.getMessage())
                .errorCode(ExceptionCode.STUDENT_NOT_FOUND_EXCEPTION.getCode())
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handling(ConstraintViolationException exception, WebRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .path(request.getContextPath())
                .message(exception.getMessage())
                .errorCode(ExceptionCode.VALIDATION_EXCEPTION.getCode())
                .build();
        return error;
    }
}
