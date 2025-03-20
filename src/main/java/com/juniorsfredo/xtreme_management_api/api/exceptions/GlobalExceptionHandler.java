    package com.juniorsfredo.xtreme_management_api.api.exceptions;

    import com.juniorsfredo.xtreme_management_api.domain.exceptions.DataNaoDisponivelException;
    import com.juniorsfredo.xtreme_management_api.domain.exceptions.EntityNotFoundException;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.ControllerAdvice;
    import org.springframework.web.bind.annotation.ExceptionHandler;
    import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

    import java.time.Instant;
    import java.time.LocalDateTime;

    @ControllerAdvice
    public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity<GlobalErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            return ResponseEntity.status(status)
                                .body(this.newErrorResponse(status.value(),
                                                            ex.getMessage())
                                );
        }

        @ExceptionHandler(DataNaoDisponivelException.class)
        public ResponseEntity<GlobalErrorResponse> handleDataNaoDisponivelException(DataNaoDisponivelException ex) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            return ResponseEntity.status(status)
                    .body(this.newErrorResponse(status.value(), ex.getMessage()));
        }

        private GlobalErrorResponse newErrorResponse(Integer statusCode, String message) {
            return new GlobalErrorResponse(statusCode, message, LocalDateTime.now());
        }
    }
