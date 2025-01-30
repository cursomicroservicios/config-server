package com.deivid.microservices.model.dto;

import java.time.LocalDateTime;

public record ErrorResponseDTO(LocalDateTime timestamp, int status, String error, String message) {}
