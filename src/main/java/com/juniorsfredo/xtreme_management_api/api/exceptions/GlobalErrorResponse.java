package com.juniorsfredo.xtreme_management_api.api.exceptions;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class GlobalErrorResponse {

    private Integer statusCode;
    private String message;
    private LocalDateTime timestamp;
}
