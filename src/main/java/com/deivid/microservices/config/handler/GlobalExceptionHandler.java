package com.deivid.microservices.config.handler;

import com.deivid.microservices.exception.BranchNotAllowedException;
import com.deivid.microservices.exception.ProfileNotAllowedException;
import com.deivid.microservices.model.dto.ErrorResponseDTO;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Order(-1)
public class GlobalExceptionHandler {

    @ExceptionHandler(ProfileNotAllowedException.class)
    public ResponseEntity<ErrorResponseDTO> handleProfileNotAllowedException(ProfileNotAllowedException ex) {
        ErrorResponseDTO body = buildResponse(HttpStatus.FORBIDDEN, ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(BranchNotAllowedException.class)
    public ResponseEntity<ErrorResponseDTO> handleBranchNotAllowedException(BranchNotAllowedException ex) {
        ErrorResponseDTO body = buildResponse(HttpStatus.FORBIDDEN, ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.FORBIDDEN);
    }

    private ErrorResponseDTO buildResponse(HttpStatus status, String message) {
        return new ErrorResponseDTO(LocalDateTime.now(), status.value(), status.getReasonPhrase(), message);
    }
}
